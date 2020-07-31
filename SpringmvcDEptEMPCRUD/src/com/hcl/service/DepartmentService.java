package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.DepartmentDao;
import com.hcl.dto.Department;

@Service
@Transactional
public class DepartmentService {
    
	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> getAllEmployees(){
		System.out.println("In Service");
		return departmentDao.getAllDepartments();
	}
	
	public void insertDepartment(Department department) {
		departmentDao.insertDepartment(department);
	}
	
	public void deleteDepartment(int DeptID) {
		departmentDao.deleteDepartment(DeptID);
	}
}
