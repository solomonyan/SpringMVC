package com.springapp.mvc.dao;

import com.springapp.mvc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);
}