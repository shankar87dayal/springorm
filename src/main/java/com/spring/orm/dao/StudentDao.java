package com.spring.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
 
	private HibernateTemplate hibernateTemplate;
	
	//save student details
	public int insert(Student student)
	{
		//insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
		
				
	}
}
