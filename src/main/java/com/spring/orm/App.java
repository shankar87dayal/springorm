package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * configuration done now
 * we are working with CRUD
 * C-> Create
 * R->Read
 * U->Update
 * D->Delete
 * and
 * finally we create 
 * one Console based Application
 *PRESS 1 for add new student
 *PRESS 2 for display all students
 *PRESS 3 for get detail of single student
 *PRESS 4 for delete students
 *PRESS 5 for update student
 *PRESS 6 for exit
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
      StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
      
//      Student student = new Student(1,"Raushan ranjan","chennai");
//      
//      int r = studentDao.insert(student);
//      System.out.println("done" + r);
      
      BufferedReader br= new BufferedReader(new InputStreamReader( System.in));
      
      boolean go=true;
     while(go)
     {
    	 System.out.println("PRESS 1 for add new student");
         System.out.println("PRESS 2 for display all students");
         System.out.println("PRESS 3 for get detail of single student");
         System.out.println("PRESS 4 for delete students");
         System.out.println("PRESS 5 for update student");
         System.out.println("PRESS 6 for exit");
         
         try {
        	 int input = Integer.parseInt(br.readLine());
        	 //using if else method
//        	 if(input ==1)
//        	 {
//        		 //add a new student
//        		 
//        	 }else if(input==2)
//        	 {
//        		 
//        	 }
        	 //using switch case
        	 switch (input) {
			case 1:
				//add a new student
				// taking inputs from users
				System.out.println("Enter studentId : ");
				int sId = Integer.parseInt(br.readLine());

				System.out.println("Enter studentName  :");
				String sName = br.readLine();

				System.out.println("Enter studentCity: ");
				String sCity = br.readLine();

				// creating student object and setting values
				Student s = new Student();
				s.setStudentId(sId);
				s.setStudentName(sName);
				s.setStudentCity(sCity);

				// saving student object to database by calling insert of student dao
				int r = studentDao.insert(s);
				System.out.println(r + " student added");
				System.out.println("***************************************");
				System.out.println();
				break;

             case 2:
				//display all students
            	 System.out.println("**************************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("studentId : " + st.getStudentId());
						System.out.println("studentName : " + st.getStudentName());
						System.out.println("studentCity : " + st.getStudentCity());
						System.out.println("___________________________________");
					}

					System.out.println("**************************************");
					break;
				
             case 3:
 				//detail of single student
            	 System.out.println("Enter  studentId : ");
					int studentId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(studentId);
					System.out.println("studentId : " + student.getStudentId());
					System.out.println("studentName : " + student.getStudentName());
					System.out.println("studentCity : " + student.getStudentCity());
					System.out.println("___________________________________");
 				break;
             case 4:
 				// delete students
            	 System.out.println("Enter student id : ");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted...");
					break;
             case 5:
 				//update student
 				break;
             case 6:
 				//exit
            	 go=false;
 				break;
			
			}
			
		} catch (Exception e) {
			System.out.println("invalid input try with another !!");
			System.out.println(e.getMessage());
		}
     }
     System.out.println("Thank u for using my application");
     System.out.println("see u soon !!");
      
    }
}
