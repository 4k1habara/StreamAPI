package com.courseworkto.streamapihw.controller;

import com.courseworkto.streamapihw.Employee;
import com.courseworkto.streamapihw.service.DepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepController {
    private final DepService depService;

    public DepController(DepService depService) {
        this.depService = depService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return depService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return depService.minSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesByDep(@RequestParam int departmentId) {
        return depService.getEmployeesByDep(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployeesByDeps() {
        return depService.allEmployeesByDeps();
    }

}