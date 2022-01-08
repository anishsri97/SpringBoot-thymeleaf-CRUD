package com.myApp.myApplication.employeeDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.myApplication.entity.employee;

public interface employeeRepo extends JpaRepository<employee, Integer> {

}
