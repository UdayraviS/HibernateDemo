package com.cruds.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cruds.entity.Employee;
import com.cruds.entity.Project;
import com.cruds.util.Hibernateutil;

public class TestManytoManyMapping 
{

	public static void  assign()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee e1 = new Employee("Ram");
		Employee e2 = new Employee("Shyam");
		
		Project p1 = new Project("Library Management System");
		Project p2 = new Project("Department Maintenance");
		
		List<Employee> list1 = new ArrayList<>();
		List<Project> list2 = new ArrayList<>();
		
		list1.add(e1);
		list1.add(e2);
		list2.add(p2);
		list2.add(p1);
		e1.setProjects(list2);
		p2.setEmployees(list1);
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		Hibernateutil.shutdown();
		
	}
	
	
	public static void main(String[] args)
	{
		assign();
	}

}
