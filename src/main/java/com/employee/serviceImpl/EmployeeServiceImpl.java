package com.employee.serviceImpl;

import com.employee.constants.Role;
import com.employee.dto.Response;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Response<Employee> addEmployee(Employee employee) {
        Response<Employee> response = new Response<>();
        try {
            if (employee != null) {
                employee.setTask(new ArrayList<>());
                Employee savedEmployee = employeeRepository.save(employee);
                response.setSuccess(true);
                response.setData(savedEmployee);
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employee not added");
            log.error("Error in addEmployee {}", e);
        }
        return response;
    }

    @Override
    public Response<Employee> updateEmployee(Employee employee) {
        Response<Employee> response = new Response<>();
        try {
            if (employee != null) {
                Employee updatedEmployee = employeeRepository.save(employee);
                response.setSuccess(true);
                response.setData(updatedEmployee);
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employee not updated");
            log.error("Error in updateEmployee {}", e);
        }
        return response;
    }

    @Override
    public Response<Employee> getEmployeeById(int id) {
        Response<Employee> response = new Response<>();
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if (employee.isEmpty()) {
                response.getErrorMessages().add("Employee not found");
            } else {
                response.setSuccess(true);
                response.setData(employee.get());
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employee not found");
            log.error("Error in getEmployeeById {}", e);
        }
        return response;
    }

    @Override
    public Response<List<Employee>> getAllEmployees(String filterValue) {
        Response<List<Employee>> response = new Response<>();
        try {
            List<Employee> employee;
            if (filterValue.equals("")) {
                employee = employeeRepository.findAll();
            } else {
                employee = employeeRepository.searchEmployee(filterValue);
            }
            if (employee.isEmpty()) {
                response.getErrorMessages().add("Employees not found");
            } else {
                response.setSuccess(true);
                response.setData(employee);
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employees not found");
            log.error("Error in getAllEmployees {}", e);
        }
        return response;
    }

    @Override
    public Response<List<Employee>> getAllEmployeesByManagerId(int id) {
        Response<List<Employee>> response = new Response<>();
        try {
            List<Employee> employee = employeeRepository.getAllEmployeesByManagerId(id);
            if (employee.isEmpty()) {
                response.getErrorMessages().add("Employees not found");
            } else {
                response.setSuccess(true);
                response.setData(employee);
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employees not found");
            log.error("Error in getAllEmployeesByManagerId {}", e);
        }
        return response;
    }

    @Override
    public Response<String> deleteEmployeeById(int id) {
        Response<String> response = new Response<>();
        try {
            Employee employee = getEmployeeById(id).getData();
            if (employee != null) {
                if (employee.getRole() != Role.MANAGER) {
                    employeeRepository.deleteById(id);
                    response.setSuccess(true);
                } else {
                    employeeRepository.deleteById(id);
                }
            } else {
                response.getErrorMessages().add("Employees not deleted");
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employees not deleted");
            log.error("Error in deleteEmployeeById {}", e);
        }
        return response;
    }

    @Override
    public Response<List<Employee>> getAllManagers() {
        Response<List<Employee>> response = new Response<>();
        try {
            List<Employee> managers = employeeRepository.findAllMangers();
            if (managers.isEmpty()) {
                response.getErrorMessages().add("Managers not found");
            } else {
                response.setSuccess(true);
                response.setData(managers);
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Managers not found");
            log.error("Error in getAllManagers {}", e);
        }
        return response;
    }

    @Override
    public Response<Employee> logIn(String email, String password) {
        Response<Employee> response = new Response<>();
        try {
            Employee employee = employeeRepository.findByEmailAndPassword(email, password);
            if (employee != null) {
                response.setData(employee);
                response.setSuccess(true);
            } else {
                response.getErrorMessages().add("invalid username or password");
            }
        } catch (Exception e) {
            response.getErrorMessages().add("Employee not found");
            log.error("Error in getEmployeeById {}", e);
        }
        return response;
    }
}
