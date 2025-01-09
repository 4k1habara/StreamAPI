package com.courseworkto.streamapihw.service;

import com.courseworkto.streamapihw.Employee;

import java.util.List;
import java.util.Map;

public interface DepService {
    public Employee maxSalary(int departmentId);

    public Employee minSalary(int departmentId);
    public List<Employee> getEmployeesByDep(int departmentId);

    public Map<Integer, List<Employee>> allEmployeesByDeps();
}
