package com.employee.controller;

import com.employee.dto.Response;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Response<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/updateEmployee")
    public Response<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/getEmployeeById")
    public Response<Employee> getEmployeeById(@RequestParam(name = "employeeId") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getAllEmployees")
    public Response<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


}
