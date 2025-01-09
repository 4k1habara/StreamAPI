package com.courseworkto.streamapihw.service;

import com.courseworkto.streamapihw.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName, int department, int salary);


    Employee removeEmployee(String lastName, String firstName, int department, int salary);


    Employee findEmployee(String lastName, String firstName, int department, int salary);

    Collection<Employee> getAllEmployees();
}
