package com.courseworkto.streamapihw.service;

import com.courseworkto.streamapihw.Employee;
import com.courseworkto.streamapihw.exceptions.EmployeeAlreadyAddedException;
import com.courseworkto.streamapihw.exceptions.EmployeeNotFoundException;
import com.courseworkto.streamapihw.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final static int maxQuantity = 10;
    private final static List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String lastName, String firstName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.size() == EmployeeServiceImpl.maxQuantity) {
            throw new EmployeeStorageIsFullException();
        }
        if (!employees.contains(employee)) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
