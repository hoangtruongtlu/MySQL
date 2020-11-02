package main.java.com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.com.vti.entity.Account;

public class HibernateUtil {
	private static HibernateUtil instance;
	private Configuration configuration;
	private SessionFactory sessionFactory;

	private HibernateUtil() {
		config();
	}

	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

	private SessionFactory buildSessionFactory() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();
			sessionFactory = configuration.buildSessionFactory(registry);
		}
		return sessionFactory;
	}

	public void closeFactory() {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	private void config() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Account.class);

	}

	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
}
