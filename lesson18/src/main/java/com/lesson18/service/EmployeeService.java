package com.lesson18.service;

import com.lesson18.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void editEmployee(Employee employee, int employeeId);

    void deleteEmployee(int employeeId);

    Optional<Employee> find(int employeeId);

    List<Employee> findAll();
}

