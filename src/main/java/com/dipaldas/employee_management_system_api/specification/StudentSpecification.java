package com.dipaldas.employee_management_system_api.specification;

import com.dipaldas.employee_management_system_api.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StudentSpecification {

    private static final Logger log= LoggerFactory.getLogger(StudentSpecification.class);
    public static Specification<Student> filterByCriteria(String name, String email,
                                                          Boolean studentStatus, Integer classId, LocalDate dateOfBirth) {
        log.debug("Creating specification with filters: name={}, email={}, studentStatus={}, classId={}, dateOfBirth={}",
                name, email, studentStatus, classId, dateOfBirth);
        System.out.printf("Creating specification with filters: name=%s, email=%s, studentStatus=%s, classId=%s, dateOfBirth=%s%n",
                name, email, studentStatus, classId, dateOfBirth);
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Name filter (case-insensitive partial match)
            if (name != null && !name.trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"));
                log.debug("Applying name filter: {} " ,name);
            }

            // Email filter (case-insensitive exact match)
            if (email != null && !email.trim().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("email")),
                        email.toLowerCase()));
                System.out.println("Applying email filter: " + email);
            }

            // Status filter
            if (studentStatus != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("studentStatus"),
                        studentStatus));
                System.out.println("Applying status filter: " + studentStatus);
            }

            // Class ID filter
            if (classId != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("classId"),
                        classId));
                System.out.println("Applying classId filter: " + classId);
            }

            // Date of birth filter
            if (dateOfBirth != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("dateofBirth"),  // Make sure this matches entity
                        dateOfBirth));
                System.out.println("Applying dateOfBirth filter: " + dateOfBirth);
            }

            System.out.println("Total predicates applied: " + predicates.size());
            return predicates.isEmpty()
                    ? criteriaBuilder.conjunction()
                    : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}