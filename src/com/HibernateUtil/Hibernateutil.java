package com.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pojo.User;

public class Hibernateutil {
	
	
	public static SessionFactory registerUser(User user) {
		SessionFactory sessionFactory=null;
		if(sessionFactory==null) {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

}
