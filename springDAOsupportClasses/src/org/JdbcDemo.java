package org;



import org.dao.HibernateDaoImpl;
import org.dao.JdbcDaoImpl;
import org.dao.SimpleJdbcDaoImpl;
import org.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JdbcDemo {

	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//SimpleJdbcDaoImpl dao=context.getBean("simpleJdbcDaoImpl",SimpleJdbcDaoImpl.class);
		HibernateDaoImpl dao=context.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());

	}

}
