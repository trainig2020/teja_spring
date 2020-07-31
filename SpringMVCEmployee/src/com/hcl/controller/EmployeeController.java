package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dto.Employee;
import com.hcl.service.EmployeeService;

@Controller
//@Scope("session")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
    
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(HttpServletRequest request) {

		List<Employee> lst = employeeService.getAllEmployess();
		ModelAndView modelAndView2 = new ModelAndView("home1");
		modelAndView2.addObject("EmployeeList", lst);
		HttpSession session = request.getSession();
		session.setAttribute("EmployeeList", lst);
		return modelAndView2;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model,HttpServletRequest request) {
		String Register  = "NewForm";
		HttpSession session1 = request.getSession();
		List<Employee> lst =(List<Employee>)session1.getAttribute("EmployeeList");
		session1.setAttribute("EmployeeList", lst);
		model.addObject("Register", Register);
		model.addObject("insertEmployee", "newemployee");
		model.setViewName("home1");
		Employee employee = new Employee();
		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		
		Employee employee1 = new Employee();
		employee1.setEmpid(employee.getEmpid());
		employee1.setEmpname(employee.getEmpname());
		employee1.setEmpsalary(employee.getEmpsalary());
		employeeService.insertEmployee(employee1);
		return new ModelAndView("redirect:/");		
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		HttpSession session2 = request.getSession();
		Employee employee = employeeService.getEmployee(employeeId);
		session2.setAttribute("employee",employee);
		List<Employee> lst =(List<Employee>) session2.getAttribute("EmployeeList");
		session2.setAttribute("EmployeeList", lst);
		ModelAndView model = new ModelAndView("home1");
		model.addObject("EmployeeList", lst);
		model.addObject("employeeid", employeeId);    
		return model;
	}
}
