package com.dipaldas.employee_management_system_api.controller;

import com.dipaldas.employee_management_system_api.dto.StudentFilterDTO;
import com.dipaldas.employee_management_system_api.entity.Student;
import com.dipaldas.employee_management_system_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/filter")
    public List<Student> filterStudents(@RequestBody StudentFilterDTO filterDTO) {
        return studentService.filterStudents(filterDTO);
    }
    @GetMapping("/filter")
    public List<Student> filterStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Boolean studentStatus,
            @RequestParam(required = false) Integer classId,
            @RequestParam(required = false) LocalDate dateOfBirth
    ) {
        System.out.printf("Filtering students with criteria: name=%s, email=%s, studentStatus=%s, classId=%s, dateOfBirth=%s%n",
                name, email, studentStatus, classId, dateOfBirth);
        StudentFilterDTO studentFilterDTO=new StudentFilterDTO();
        studentFilterDTO.setName(name);
        studentFilterDTO.setEmail(email);
        studentFilterDTO.setStudentStatus(studentStatus);
        studentFilterDTO.setClassId(classId);
        studentFilterDTO.setDateOfBirth(dateOfBirth);
        System.out.println("Filtering students with criteria: " + studentFilterDTO);
        return studentService.filterStudents(studentFilterDTO
        );
    }
}