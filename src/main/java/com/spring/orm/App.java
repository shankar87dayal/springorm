package com.spring.orm;

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
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
      StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
      
      Student student = new Student(1,"Raushan ranjan","chennai");
      
      int r = studentDao.insert(student);
      System.out.println("done" + r);
    }
}
