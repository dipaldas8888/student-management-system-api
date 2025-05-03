package com.dipaldas.employee_management_system_api.service;

import com.dipaldas.employee_management_system_api.dto.StudentFilterDTO;
import com.dipaldas.employee_management_system_api.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);

    Student getStudentById(long id);
    Student createStudent(Student student);
    Student updateStudent(long id, Student student);
    void deleteStudent(long id);
    List<Student> filterStudents(StudentFilterDTO filterDTO); // Add this method

}