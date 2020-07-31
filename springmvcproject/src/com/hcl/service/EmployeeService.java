package com.hcl.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.EmployeeDao;
import com.hcl.dto.Employee;

@Service
@Transactional
public class EmployeeService {
	
     @Autowired
     private EmployeeDao employeeDao;
     
   
     public void insertEmployee(Employee employee) {
    	 employeeDao.insertEmployee(employee);
     }
     
     public List<Employee> getAllEmployess(){
    	 System.out.println("service");
    	 return employeeDao.getAllEmployees();
     }
     
     public void deleteEmployee(int empid) {
    	 employeeDao.deleteEmployee(empid);
     }
     
//     public Employee updateEmployee(Employee employee) {
//    	 return employeeDao.updateEmployee(employee);
//     }
     
     public Employee getEmployee(int empid) {
    	 return employeeDao.getEmployee(empid);
     }
}
