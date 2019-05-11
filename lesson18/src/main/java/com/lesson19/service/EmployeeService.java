package com.lesson19.service;

import com.lesson19.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void editEmployee(Employee employee, int employeeId);

    void deleteEmployee(int employeeId);

    Employee find(int employeeId);

    List<Employee> findAll();
}

