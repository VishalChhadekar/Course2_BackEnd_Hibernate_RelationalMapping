package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Course;
import com.hibernate.entity.Customer;
import com.hibernate.entity.PhoneNumber;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
//		Step 1: Create Config obj and provide DB info.
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// provide mapping
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Course.class);
		configuration.addAnnotatedClass(PhoneNumber.class);

//		Step2: Create seesion factory obje and return
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;

	}

}
