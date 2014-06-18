package com.springapp.mvc.controller;

import com.springapp.mvc.model.Employee;
import com.springapp.mvc.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String defaultPage(ModelMap map) {
        return "redirect:employee/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {

        map.addAttribute("employee", new Employee());
        map.addAttribute("employeeList", employeeManager.getAllEmployees());
        return "Employee/editEmployeeList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(
            @ModelAttribute(value = "employee") Employee employee,
            BindingResult result) {
        employeeManager.addEmployee(employee);
        return "redirect:employee/list";
    }

    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
        employeeManager.deleteEmployee(employeeId);
        return "redirect:employee/list";
    }

    @RequestMapping("/rest")
    @ResponseBody
    public List getRangeOfEmployee(@RequestParam(value="from", required=false) int from, @RequestParam(value="to", required=false) int to) {
       return employeeManager.getRangeOfEmployees(from,to);
    }
}
