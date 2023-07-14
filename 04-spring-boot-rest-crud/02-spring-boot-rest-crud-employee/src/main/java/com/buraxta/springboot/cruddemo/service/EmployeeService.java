package com.buraxta.springboot.cruddemo.service;

import com.buraxta.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
