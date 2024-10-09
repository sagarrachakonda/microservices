package com.microservices.department_service.employeeclient;

import com.microservices.department_service.model.Employee;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {


    @GetExchange("/employee/departmentId/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
