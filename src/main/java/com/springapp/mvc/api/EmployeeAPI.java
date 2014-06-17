package com.springapp.mvc.api;

import com.springapp.mvc.model.Employee;
import com.springapp.mvc.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
/**
 * Created by solomonyan on 17/6/14.
 */
@Component
@Path("/employee")
public class EmployeeAPI {

    @Autowired
    private EmployeeManager employeeManager;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUserById(@PathParam("id") Integer id)
    {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstname("FirstName");
        employee.setLastname("LastName");
        employee.setEmail("email@email.com");
        employee.setTelephone("12345678");
        return Response.status(200).entity(employee).build();
    }

    @GET
    @Path("/all/")
    @Produces("application/json")
    public Response getAllUsers()
    {
        return Response.status(200).entity(employeeManager.getAllEmployees()).build();
    }
}
