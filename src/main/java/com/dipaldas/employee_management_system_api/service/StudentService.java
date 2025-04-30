package com.dipaldas.employee_management_system_api.service;

import com.dipaldas.employee_management_system_api.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student createStudent(Student student);
    Student updateStudent(long id, Student student);
    void deleteStudent(long id);
}