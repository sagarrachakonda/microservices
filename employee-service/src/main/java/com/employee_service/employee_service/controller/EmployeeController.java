package com.employee_service.employee_service.controller;

import com.employee_service.employee_service.model.Employee;
import com.employee_service.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}"+ employee);
        return employeeRepository.add(employee);

    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee fins");
        return employeeRepository.findAll();
    }


    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("Employee find id={}", id);
        return employeeRepository.findById(id);
    }


    @GetMapping("/departmentId/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find by departmentid={}", departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }
}
