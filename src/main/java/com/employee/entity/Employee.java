package com.employee.entity;

import com.employee.constants.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employee")
    private List<Task> task=new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
}
