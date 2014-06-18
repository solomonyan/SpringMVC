package com.springapp.mvc.service;

import com.springapp.mvc.model.Employee;

import java.util.List;

public interface EmployeeManager {
    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public List<Employee> getRangeOfEmployees(int from, int to);
}
