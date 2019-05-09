package com.lesson18.entity;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    void addEmployee(Employee employee);

    void editEmployee(Employee employee, int employeeId);

    void deleteEmployee(int employeeId);

    Optional<Employee> find(int employeeId);

    List<Employee> findAll();
}
