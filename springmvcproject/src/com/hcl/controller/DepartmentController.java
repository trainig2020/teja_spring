package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dto.Department;
import com.hcl.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
    
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(HttpServletRequest request) {

		List<Department> lst = departmentService.getAllDepartment();
		ModelAndView modelAndView2 = new ModelAndView("home1");
		modelAndView2.addObject("DepartmentList", lst);
		HttpSession session = request.getSession();
		session.setAttribute("DepartmentList", lst);
		return modelAndView2;
	}

	@RequestMapping(value = "/newDepartment", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model,HttpServletRequest request) {
		String Register  = "NewForm";
		HttpSession session1 = request.getSession();
		List<Department> lst =(List<Department>)session1.getAttribute("DepartmentList");
		session1.setAttribute("DepartmentList", lst);
		model.addObject("Register", Register);
		model.addObject("insertDepartment", "newdepartment");
		model.setViewName("home1");
		Department department = new Department();
		model.addObject("department", department);
		return model;
	}
	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute Department department) {
		
		Department department1 = new Department();
		department1.setDeptID(department.getDeptID());
		department1.setDeptName(department.getDeptName());
		departmentService.insertDepartment(department1);
		return new ModelAndView("redirect:/");		
	}
	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(HttpServletRequest request) {
		int DeptID = Integer.parseInt(request.getParameter("id"));
		departmentService.deleteDepartment(DeptID);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/getDepartment", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int DeptID = Integer.parseInt(request.getParameter("id"));
		HttpSession session2 = request.getSession();
		Department department = departmentService.getDepartment(DeptID);
		session2.setAttribute("department",department);
		List<Department> lst =(List<Department>) session2.getAttribute("DepartmentList");
		session2.setAttribute("DepartmentList", lst);
		ModelAndView model = new ModelAndView("home1");
		model.addObject("DepartmentList", lst);
		model.addObject("departmentid", DeptID);    
		return model;
	}
	@ExceptionHandler(value=ConstraintViolationException.class)
	public String handleException(Exception e){
		System.out.println("Please provide some value in text"+e);
		return "ConstraintViolationException";
	}
}
