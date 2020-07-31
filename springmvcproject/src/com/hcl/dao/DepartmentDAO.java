package com.hcl.dao;

import java.util.List;



import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dto.Department;


@Repository
@Transactional
public class DepartmentDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void  insertDepartment(Department department) {
	      sessionFactory.getCurrentSession().saveOrUpdate(department);
	}

	public List<Department> getAllDepartment()  {
		System.out.println("Dao");
	  return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}
	
	public void deleteDepartment(int DeptID) {
			Department department= (Department) sessionFactory.getCurrentSession().load(Department.class, DeptID);
			if (department != null) {
				this.sessionFactory.getCurrentSession().delete(department);
			}
	}
	public Department getDepartment(int DeptID) {
		Department department= (Department) sessionFactory.getCurrentSession().load(Department.class, DeptID);
		return department;
	}
}
