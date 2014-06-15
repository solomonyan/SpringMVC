package com.springapp.mvc.service;

import com.springapp.mvc.model.EmployeeEntity;

import java.util.List;

public interface EmployeeManager {
	public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
