package com.lesson18.service;

import com.lesson18.entity.Employee;
import com.lesson18.entity.EmployeeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void editEmployee(Employee employee, int employeeId) {
        employeeDao.editEmployee(employee, employeeId);
    }

    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    public Optional<Employee> find(int employeeId) {
        return employeeDao.find(employeeId);
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
