package com.hotelreservation.simpreserv;

import enums.EmployeeStatus;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Employee extends Person implements Serializable {
  @Serial private static final long serialVersionUID = 463034257352516815L;
  @Setter @Getter private int id;
  @Setter @Getter private String cardCompany;
  @Setter @Getter private float salary;
  @Setter @Getter private EmployeeStatus status;
  @Setter @Getter private String position;
  @Setter @Getter private String schedule;

  public Employee() {
    super();
  }

  public Employee(
      int employeeId,
      String name,
      String dateOfBirth,
      String gender,
      String numberOfDocument,
      String email,
      int personId,
      String cardCompany,
      float salary,
      EmployeeStatus status,
      String position,
      String schedule) {
    super(personId, name, dateOfBirth, gender, numberOfDocument, email);
    this.id = employeeId;
    this.cardCompany = cardCompany;
    this.salary = salary;
    this.status = status;
    this.position = position;
    this.schedule = schedule;
  }
}
