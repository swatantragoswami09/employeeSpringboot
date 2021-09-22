package hibernateDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;
import com.mysql.cj.Session;

public class DBController {
	Scanner sc=new Scanner(System.in);
	
	public void StoreDataInDB(Store s) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//open session
		org.hibernate.Session session=  factory.openSession();
		
		//transact session
		org.hibernate.Transaction tx= session.beginTransaction();
		
		//save object in the session
		session.save(s);
		
		//commit the session
		tx.commit();
	
		//close the session
		session.close();
		
		//close factory
		factory.close();

	}
	
	public void viewDatafromDB(Store s,int id) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		s.setId(id);
		//open session
		org.hibernate.Session session=  factory.openSession();
		
		Store s1= session.get(Store.class, s.getId());
		System.out.println(s1.toString());
		
	}
	
	//HQL queries for fetching the complex data from database
	public void searchProduct() {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		String x="price";
		
		//open session
		org.hibernate.Session session=  factory.openSession();
		
		//fetch the query
		String query="from Store where color=:c and size=:s and gender=:g order by "+x+" desc";
		
		//create the query
		org.hibernate.Query q=session.createQuery(query);
		
		//take the query input from user
		System.out.print("Enter your Color:");
		q.setParameter("c",sc.next().toUpperCase());
		System.out.print("Enter your size (S/M/L): ");
		q.setParameter("s",sc.next().toUpperCase());
		System.out.print("Enter your gender:");
		q.setParameter("g",sc.next().toUpperCase());
		System.out.println("Enter output Preference :");
		System.out.println("1. Price");
		System.out.println("2. Rating");
		System.out.println("3. Both");

		int ch=sc.nextInt();
		
		switch(ch) {
			case 1: x="price";
					break;
			case 2: x="rating";
					break;
			case 3: x="price and rating";
					break;
			default: System.out.println("Please enter correct value");
			 		System.exit(0);
		}
		//getting data in list from DB
		List<Store> list =q.list();
		for(Store s:list) {
			System.out.println(s);
		}
		
		//close the session
		session.close();
		//close the factory
		factory.close();
	}

}
