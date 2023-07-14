package com.buraxta.springboot.cruddemo.dao;

import com.buraxta.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
