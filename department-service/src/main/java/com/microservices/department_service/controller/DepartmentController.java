package com.microservices.department_service.controller;

import com.microservices.department_service.model.Department;
import com.microservices.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

      private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

      @Autowired
      private DepartmentRepository repository;

      @PostMapping
      public Department add(@RequestBody Department department){
          LOGGER.info("Department add: {}",department);
          return repository.addDepartment(department);
      }

      @GetMapping
      public List<Department> findAll(){
          LOGGER.info("Department findAll: {}");
          return repository.findAll();
      }

      @GetMapping("/{id}")
      public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department findById: {}",id);
        return repository.findById(id);
      }

}
