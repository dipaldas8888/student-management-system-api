package com.dipaldas.employee_management_system_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;

    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String phone;
    @Column(name = "date_of_birth")
    private LocalDate dateofBirth;

    private boolean studentStatus;

    private int classId;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status = EmployeeStatus.ACTIVE;
    public Student() {
    }
}

enum EmployeeStatus {
    ACTIVE, ON_LEAVE, TERMINATED
}


