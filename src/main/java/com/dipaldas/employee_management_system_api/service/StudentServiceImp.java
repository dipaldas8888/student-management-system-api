package com.dipaldas.employee_management_system_api.service;

import com.dipaldas.employee_management_system_api.dto.StudentFilterDTO;
import com.dipaldas.employee_management_system_api.entity.Student;
import com.dipaldas.employee_management_system_api.repository.StudentRepository;
import com.dipaldas.employee_management_system_api.specification.StudentSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private static final Logger log= LoggerFactory.getLogger(StudentServiceImp.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setDateofBirth(student.getDateofBirth());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
    public List<Student> filterStudents(StudentFilterDTO filterDTO) {
        log.debug("Filtering students with criteria: {}", filterDTO);
        System.out.printf("Filtering students with criteria: %s%n", filterDTO);
        return studentRepository.findAll(StudentSpecification.filterByCriteria(
                filterDTO.getName(),
                filterDTO.getEmail(),
                filterDTO.getStudentStatus(),
                filterDTO.getClassId(),
                filterDTO.getDateOfBirth()
        ));
    }
}