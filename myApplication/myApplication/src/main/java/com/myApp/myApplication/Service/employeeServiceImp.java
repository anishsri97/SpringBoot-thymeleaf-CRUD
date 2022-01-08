package com.myApp.myApplication.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//import com.myApp.myApplication.employeeDAO.employeeDAO;
import com.myApp.myApplication.employeeDAO.employeeRepo;
import com.myApp.myApplication.entity.employee;


@Service
public class employeeServiceImp implements employeeService {

	
	private employeeRepo empDao;
	
	@Autowired
	employeeServiceImp(employeeRepo empDao)
	{
		this.empDao=empDao;
	}
	
	@Override
	public List<employee> employeeList() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public employee getById(int id) {
		// TODO Auto-generated method stub
		return empDao.getById(id);
	}

	@Override
	public employee add(employee emp) {
		// TODO Auto-generated method stub
		empDao.save(emp);
		return emp;

	}
   
	@Override
	public void save(employee emp)
	{
		empDao.save(emp);
	}
	
	
	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
           empDao.deleteById(id);
	}

}
