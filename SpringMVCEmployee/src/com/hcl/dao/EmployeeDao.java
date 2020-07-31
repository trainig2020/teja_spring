package com.hcl.dao;

import java.util.List;



import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dto.Employee;

@Repository
@Transactional
public class EmployeeDao {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void  insertEmployee(Employee employee) {
	      sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	public List<Employee> getAllEmployees()  {
		System.out.println("Dao");
	  return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}
	
//	public Employee updateEmployee(Employee employee) {
//		sessionFactory.getCurrentSession().update(employee);
//		return employee;
//	}
	public void deleteEmployee(int empid) {
			Employee employee= (Employee) sessionFactory.getCurrentSession().load(Employee.class, empid);
			if (employee != null) {
				this.sessionFactory.getCurrentSession().delete(employee);
			}
	}
	public Employee getEmployee(int empid) {
		Employee employee= (Employee) sessionFactory.getCurrentSession().load(Employee.class, empid);
		return employee;
	}
}
