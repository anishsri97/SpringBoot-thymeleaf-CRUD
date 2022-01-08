package com.myApp.myApplication.Service;

import java.util.List;

import com.myApp.myApplication.entity.employee;

public interface employeeService 
{
	public List<employee> employeeList();
	   
	   public employee getById(int id);
	   
	   public employee add(employee emp);
	   
	   public void deleteByid(int id);
	   
	   public void save(employee theEmployee);
}
