package com.springapp.mvc.controller;

import com.springapp.mvc.model.EmployeeEntity;
import com.springapp.mvc.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public String defaultPage(ModelMap map) {
        return "redirect:employee/list";
    }

    @RequestMapping(value = "employee/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {

        map.addAttribute("employee", new EmployeeEntity());
        map.addAttribute("employeeList", employeeManager.getAllEmployees());
        return "Employee/editEmployeeList";
    }

    @RequestMapping(value = "employee/add", method = RequestMethod.POST)
    public String addEmployee(
            @ModelAttribute(value = "employee") EmployeeEntity employee,
            BindingResult result) {
        employeeManager.addEmployee(employee);
        return "redirect:employee/list";
    }

    @RequestMapping("employee/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
        employeeManager.deleteEmployee(employeeId);
        return "redirect:employee/list";
    }
}
