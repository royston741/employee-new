package com.employee.entity;

import com.employee.constants.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "task_completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
