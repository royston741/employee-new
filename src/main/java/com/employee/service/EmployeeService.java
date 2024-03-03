package com.employee.service;

import com.employee.dto.Response;
import com.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public abstract Response<Employee> addEmployee(Employee employee);
    public abstract Response<Employee> updateEmployee(Employee employee);
    public abstract Response<Employee> getEmployeeById(int id);
    public abstract Response<List<Employee>> getAllEmployees();
}
