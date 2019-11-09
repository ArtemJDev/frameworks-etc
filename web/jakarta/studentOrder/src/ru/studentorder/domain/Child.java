package main.studentOrder.src.ru.studentorder.domain;

import java.time.LocalDate;

public class Child extends Person   {

  private String certificateNumber;
  private LocalDate issueDate;
  private String issueDepartment;

  public Child(String surName, String givenName, String patronymic,
      LocalDate dateOfBirthday) {
    super(surName, givenName, patronymic, dateOfBirthday);
  }

  public String getCertificateNumber() {
    return certificateNumber;
  }

  public void setCertificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public String getIssueDepartment() {
    return issueDepartment;
  }

  public void setIssueDepartment(String issueDepartment) {
    this.issueDepartment = issueDepartment;
  }
}
