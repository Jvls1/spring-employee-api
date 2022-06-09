package com.jojo.springboot.cruddemo.rest;

import com.jojo.springboot.cruddemo.entity.Employee;
import com.jojo.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employee/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {

        if (employeeId == null) {
            throw new RuntimeException("id is null");
        }

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("not found - " + employeeId);
        }

        return employee;
    }

    @PostMapping("/save/employee")
    public Employee addEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/update/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/delete/{employeeId}")
    public Employee deleteEmployee(@PathVariable Integer employeeId) {

        if (employeeId == null) {
            throw new RuntimeException("id is null");
        }

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return employee;
    }
}
