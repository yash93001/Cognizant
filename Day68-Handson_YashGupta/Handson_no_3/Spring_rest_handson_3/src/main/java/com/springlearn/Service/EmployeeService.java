package com.springlearn.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlearn.Employee;
import com.springlearn.Exception.EmployeeNotFoundException;
import com.springlearn.daoClasses.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;

	public List<Employee> getAllEmployees(){
		
		return employeedao.getAllEmployee();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		return employeedao.updateEmployee(employee);
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		
		employeedao.deleteEmployee(id);
		
	}
	
}
	