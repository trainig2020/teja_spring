package com.hcl.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.DepartmentDAO;
import com.hcl.dto.Department;

@Service
@Transactional
public class DepartmentService {
	
     @Autowired
     private DepartmentDAO departmentDAO;
     
   
     public void insertDepartment(Department department) {
    	 departmentDAO.insertDepartment(department);
     }
     
     public List<Department> getAllDepartment(){
    	 System.out.println("service");
    	 return departmentDAO.getAllDepartment();
     }
     
     public void deleteDepartment(int DeptID) {
    	 departmentDAO.deleteDepartment(DeptID);
     }
     
     public Department getDepartment(int DeptID) {
    	 return departmentDAO.getDepartment(DeptID);
     }
}
