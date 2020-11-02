package main.java.com.vti;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import main.java.com.vti.entity.Account;

public class Main {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Account account = new Account();
		
		account.setAccountID(101);
		account.setFullName("Truong Hoang Van");
		account.setEmail("Truongpro9xx@gmail.com");
		account.setUserName("truongpro9xx");
		account.setDepartmentID(2);
		account.setPositionID(2);
		account.setCreateDate(new Date(2020,10,28));
		
		session.save(account);
		
		transaction.commit();
		
		factory.close();
		
		session.close();
	}
}
