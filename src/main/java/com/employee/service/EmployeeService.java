package com.employee.service;

import com.employee.dto.Response;
import com.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public abstract Response<Employee> addEmployee(Employee employee);

    public abstract Response<Employee> updateEmployee(Employee employee);

    public abstract Response<Employee> getEmployeeById(int id);

    public abstract Response<List<Employee>> getAllEmployees(String filterValue);

    public abstract Response<List<Employee>> getAllEmployeesByManagerId(int id);

    public Response<Employee> logIn(String email, String password);

    public Response<String> deleteEmployeeById(int id);

    public Response<List<Employee>> getAllManagers();

}
