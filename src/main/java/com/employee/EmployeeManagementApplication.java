package com.employee;

import com.employee.constants.Priority;
import com.employee.constants.Role;
import com.employee.entity.Employee;
import com.employee.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootApplication
public class EmployeeManagementApplication {
    static List<Employee>  empList=new ArrayList<>();

    public static void details(int maagerId){
        Employee selectedManager= empList.stream().filter(manager->manager.getId()==maagerId).findFirst().get();
        System.out.println(selectedManager.getFirstName()+"----------------");
        empList.forEach(employee -> {
            try {
                if (employee.getManager().getId() == maagerId) {
                    System.out.println(employee.getFirstName());
                        employee.getTask().forEach(task-> System.out.println("    "+task.getTitle()+"----->"+task.getDescription()));
                }
            }catch (Exception e){

            }
        });
    }
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

}
