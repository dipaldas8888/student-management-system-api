package com.dipaldas.employee_management_system_api.dto;


import java.time.LocalDate;

public class StudentFilterDTO {
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private Boolean studentStatus;
    private Integer classId;
  public StudentFilterDTO(){

   }

    public StudentFilterDTO(String name, String email, Object o, LocalDate dateOfBirth, Boolean studentStatus, Integer classId) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

  @Override
   public String toString() {
      return "StudentFilterDTO{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
               ", studentStatus=" + studentStatus +
               ", classId=" + classId +
               '}';
   }
}
