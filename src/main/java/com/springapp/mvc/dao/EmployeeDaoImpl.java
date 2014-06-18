package com.springapp.mvc.dao;

import com.springapp.mvc.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(Employee employee) {
        this.sessionFactory.getCurrentSession().save(employee);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllEmployees() {
        return this.sessionFactory.getCurrentSession().createQuery("from Employee ").list();
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }

    @Override
    public List<Employee> getRangeOfEmployees(int from, int to) {
        return this.sessionFactory.getCurrentSession().createQuery("from Employee where id between " + from +" and " + to).list();
    }
}
