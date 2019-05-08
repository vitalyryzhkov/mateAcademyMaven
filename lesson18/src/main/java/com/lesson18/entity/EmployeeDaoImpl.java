package com.lesson18.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
@Qualifier("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private static final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class.getName());

    private final static String INSERT = "INSERT INTO persons (first_name, last_name, age) VALUES (?, ?, ?)";
    private final static String UPDATE = "UPDATE persons SET first_name = ? , last_name = ? , age = ? WHERE id = ?";
    private final static String DELETE = "DELETE from persons WHERE id = ?";
    private final static String SELECT = "SELECT * FROM persons where id = ?";
    private final static String SELECT_ALL = "SELECT * FROM persons";

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addEmployee(Employee employee) {
        jdbcTemplate.update(INSERT, employee.getFirstName(), employee.getLastName(), employee.getAge());
        LOGGER.info("Employee added!");
    }

    public void editEmployee(Employee employee, int employeeId) {
        jdbcTemplate.update(UPDATE, employee.getFirstName(), employee.getLastName(), employee.getAge(), employeeId);
        LOGGER.info("Employee updated!");
    }

    public void deleteEmployee(int employeeId) {
        jdbcTemplate.update(DELETE, employeeId);
        LOGGER.info("Employee deleted!");
    }

    public Optional<Employee> find(int employeeId) {
        try {
            Employee employee = jdbcTemplate.queryForObject(SELECT,
                    new Object[]{employeeId}, new BeanPropertyRowMapper<>(Employee.class));
            return Optional.ofNullable(employee);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Employee> findAll() {
        try {
            return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<>(Employee.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
