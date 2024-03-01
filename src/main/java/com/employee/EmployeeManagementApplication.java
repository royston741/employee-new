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
        log.info("Server is running....");

        Employee managerJhon = new Employee(1, "Jhon", "Doe", "jhon@gmail.com", "918178272", "sam1234", null, Role.MANAGER, null);

        Employee employeeRaj =
                new Employee(2, "Raj", "Gatle", "raj@gmail.com", "91727728", "raj1234", null, Role.EMPLOYEE, managerJhon);
        employeeRaj.setTask(List.of(new Task(1,"Work-11","Button UI",new Date(), Priority.LOW,false,employeeRaj)));

        Employee employeeSham =
                new Employee(3, "Sham", "Gilai", "sham@gmail.com", "8919191", "sham12341234", null, Role.EMPLOYEE, managerJhon);
        employeeSham.setTask(List.of(new Task(2,"Work-12","Nav UI",new Date(), Priority.MEDIUM,false,employeeSham)));

        Employee employeeLila =
                new Employee(4, "Lila", "Kal", "lila@gmail.com", "82892389", "lila1234", null, Role.EMPLOYEE, managerJhon);
        employeeLila.setTask(List.of(new Task(3,"Work-13","Filter UI",new Date(), Priority.HIGH,false,employeeLila)));

        Employee managerRam = new Employee(5, "Ram", "Sharma", "ram@gmail.com", "92323889", "ram1234", null, Role.MANAGER, null);

        Employee employeeTina =
                new Employee(2, "Tina", "Fila", "tina@gmail.com", "9218778", "tina1234", null, Role.EMPLOYEE, managerRam);
        employeeTina.setTask(List.of(new Task(4,"Work-14","Form UI",new Date(), Priority.LOW,false,employeeTina)));

        empList = List.of(managerJhon, managerRam, employeeRaj, employeeLila, employeeSham, employeeTina);
        details(1);
        details(5);
    }

}
