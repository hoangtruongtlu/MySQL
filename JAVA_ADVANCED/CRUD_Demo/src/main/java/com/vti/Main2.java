package main.java.com.vti;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.com.vti.entity.Account;
import main.java.com.vti.utils.HibernateUtil;

public class Main2 {

	public static void main(String[] args) {
		HibernateUtil hibernateUtils = HibernateUtil.getInstance();
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();

		Account account = new Account();

		account.setAccountID(101);
		account.setFullName("Truong Hoang Van");
		account.setEmail("Trpuongpro9xx@gmail.com");
		account.setUserName("truongpro9xx");
		account.setDepartmentID(2);
		account.setPositionID(2);
		account.setCreateDate(new Date(2020, 10, 28));

		session.save(account);
		
		transaction.commit();
		
		hibernateUtils.closeFactory();

		session.close();
	}

}
