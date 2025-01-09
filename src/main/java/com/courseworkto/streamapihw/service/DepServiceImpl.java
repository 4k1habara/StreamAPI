package com.courseworkto.streamapihw.service;

import com.courseworkto.streamapihw.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepServiceImpl implements DepService {
    private final EmployeeService employeeService;

    public DepServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalary(int departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);
    }

    @Override
    public Employee minSalary(int departmentId) {
        List<Employee> employees = new ArrayList<>(employeeService.getAllEmployees());
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    @Override
    public List<Employee> getEmployeesByDep ( int departmentId) {
        List<Employee> employees = new ArrayList<>(employeeService.getAllEmployees());
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> allEmployeesByDeps () {
        List<Employee> employeess = new ArrayList<>(employeeService.getAllEmployees());
        Map<Integer, List<Employee>> employeesByDep = employeess.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return employeesByDep;
    }
}