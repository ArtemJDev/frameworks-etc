package main.studentOrder.src.ru.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {

  private String passportSeria;
  private String passportNumber;
  private LocalDate issueDate;
  private String issueDepartament;
  private String university;
  private String StudentId;

  public Adult(String surName, String givenName, String patronymic,
      LocalDate dateOfBirthday) {
    super(surName, givenName, patronymic, dateOfBirthday);
  }




  public String getPersonString(){
    return getSurName() + " " + getGivenName()+ " "  + passportNumber;
  }

  public String getPassportSeria() {
    return passportSeria;
  }

  public void setPassportSeria(String passportSeria) {
    this.passportSeria = passportSeria;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public String getIssueDepartament() {
    return issueDepartament;
  }

  public void setIssueDepartament(String issueDepartament) {
    this.issueDepartament = issueDepartament;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public String getStudentId() {
    return StudentId;
  }

  public void setStudentId(String studentId) {
    StudentId = studentId;
  }
}
