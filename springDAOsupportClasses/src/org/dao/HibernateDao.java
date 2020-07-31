package org.dao;

import org.hibernate.SessionFactory;

public class HibernateDao {
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public int getCircleCount() {
		return 0;
		
	  }

}
