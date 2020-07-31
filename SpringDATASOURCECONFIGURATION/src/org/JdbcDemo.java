package org;



import org.dao.JdbcDaoImpl;
import org.model.Circle;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class JdbcDemo {

	
	public static void main(String[] args) {


  ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
  JdbcDaoImpl dao=context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		//Circle circle=dao.getCircle(1);
		//System.out.println(circle.getName());
	//	System.out.println(dao.getCircleforId(1).getName());
		dao.insertCircle(new Circle(3,"third circles"));
		System.out.println(dao.getAllCircles().size());
		//dao.createTriangleTable();

	}

}
