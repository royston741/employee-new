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

    @PutMapping("/updateEmployee")
    public Response<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/getEmployeeById")
    public Response<Employee> getEmployeeById(@RequestParam(name = "employeeId") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getAllEmployeesByManagerId")
    public Response<List<Employee>> getAllEmployeesByManagerId(@RequestParam(name = "managerId") int id) {
        return employeeService.getAllEmployeesByManagerId(id);
    }

    @GetMapping("/getAllEmployees")
    public Response<List<Employee>> getAllEmployees(@RequestParam(name = "filterValue",defaultValue = "") String filterValue) {
        return employeeService.getAllEmployees(filterValue);
    }

    @GetMapping("/getAllManagers")
    public Response<List<Employee>> getAllManagers() {
        return employeeService.getAllManagers();
    }

    @GetMapping("/logIn")
    public Response<Employee> logIn(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "password") String password) {
        return employeeService.logIn(email, password);
    }
    @DeleteMapping("/deleteEmployeeById")
    public Response<String> deleteEmployeeById(@RequestParam(name = "employeeId") int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
