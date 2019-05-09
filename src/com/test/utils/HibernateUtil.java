package com.test.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	/*
	public static SessionFactory sessionFactory; 
	public static Session session;
	
	static {
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	*/
	/**
	 * 开启一个新线程
	 * @return
	 */
	/*
	public static Session getSession(){
		session = sessionFactory.openSession();		
		return session;
	}
	
	*/
	/**
	 * 绑定当前线程
	 */
	/*
	public static Session getCurrentSession() {
		
		session = sessionFactory.getCurrentSession();
		
		return session;
		
	}
	*/
}
