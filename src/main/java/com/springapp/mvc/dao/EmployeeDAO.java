package com.springapp.mvc.dao;

import com.springapp.mvc.model.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    public void addEmployee(EmployeeEntity employee);

    public List<EmployeeEntity> getAllEmployees();

    public void deleteEmployee(Integer employeeId);
}