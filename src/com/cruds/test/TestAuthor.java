package com.cruds.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cruds.entity.Author;
import com.cruds.entity.Book;
import com.cruds.util.Hibernateutil;

public class TestAuthor 
{
	/*public static void delete()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Book b1 = (Book) session.load(Book.class, new Long(1));
		session.delete(b1);
		//session.saveOrUpdate(session);;
		tx.commit();
		session.close();
		Hibernateutil.shutdown();
	}*/
	
	public static void listBook()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		
		List<Book> list = (List<Book>) session.createQuery("from Book").list();
		for(Book b : list)
		{
			System.out.println(b);
		}
		session.close();
		Hibernateutil.shutdown();
	}
	
	public static void getBookbyAuthor()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		Author a3 = (Author) session.load(Author.class, new Long(9));
		Hibernate.initialize(a3.getBooks());
		
		System.out.println(a3);
		
		session.close();
		Hibernateutil.shutdown();
	}
	
	public static void getBookbyTitle()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		
		Book b5 = (Book) session.load(Book.class, new Long(15));
		Hibernate.initialize(b5.getTitle());
		System.out.println(b5);
		session.close();
		Hibernateutil.shutdown();
	}
	
	
	public static void getBookbyId()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		
		Book b5 = (Book) session.load(Book.class, new Long(15));
		Hibernate.initialize(b5.getISBN());
		System.out.println(b5);
		session.close();
		Hibernateutil.shutdown();
	}
	
	
	
	
	
	
	public static void updateBook()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Book b1 = (Book) session.load(Book.class, new Long(1));
		b1.setTitle("Hanuman");
		session.update(b1);
		tx.commit();
		session.close();
		Hibernateutil.shutdown();
		
	}
	
	public static void updateAuthor()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Author a3 = (Author) session.load(Author.class, new Long(9));
		a3.setName("K.V.Puttappa");
		
		session.update(a3);
		tx.commit();
		session.close();
		Hibernateutil.shutdown();
	}

	public static void create()
	{
		SessionFactory sf = Hibernateutil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Author a2 = new Author("J.K.Rowling", "jkr@gmail.com");
		Book b3 = new Book("103", "Harry Potter 2", "Fantasy", 6);
		Book b4 = new Book("104", "Harry Potter", "Fantasy", 5);
		Set<Book> books = new HashSet<>();
		books.add(b3);
		books.add(b4);
		a2.setBooks(books);
		session.save(a2);*/
		Author a3 = new Author("Kuvempu", "k@gmail.com");
		Book b5 = new Book("105", "Ramayana darshanam", "Mythology", 1);
		Book b6 = new Book("106", "Malegalalli madumagalu", "Drama", 2);
		
		Set<Book> books = new HashSet<>();
		books.add(b5);
		books.add(b6);
		a3.setBooks(books);
		session.save(a3);
		tx.commit();
		session.close();
		Hibernateutil.shutdown();
	}

	public static void main(String[] args) 
	{
		//delete(); // we dont delete data from database, we just make it inactive
		//create();
		//updateBook();
		//updateAuthor();
		//getBookbyId();
		//getBookbyTitle();
		getBookbyAuthor();
		//listBook();
	}

}
