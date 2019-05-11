package com.lesson19.service;

import com.lesson19.entity.Employee;
import com.lesson19.entity.EmployeeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Employee find(int employeeId) {
        return employeeDao.find(employeeId).orElse(new Employee());
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
