package com.microservices.department_service.model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {

    // record has no setters only getters
}
