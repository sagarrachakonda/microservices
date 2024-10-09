package com.employee_service.employee_service.model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {

    // record has no setters only getters
}
