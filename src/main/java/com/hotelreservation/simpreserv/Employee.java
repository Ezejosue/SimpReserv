package com.hotelreservation.simpreserv;

import enums.EmployeeStatus;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Employee extends Person {
  @Setter @Getter private int ID;
  @Setter @Getter private String cardCompany;
  @Setter @Getter private int salary;
  @Setter @Getter private EmployeeStatus status;
  @Setter @Getter private String position;
  @Setter @Getter private String schedule;

  public Employee() {
    super();
  }

  public Employee(
      int ID,
      String cardCompany,
      int salary,
      EmployeeStatus state,
      String position,
      String schedule,
      int idEmployee,
      String nameEmployee,
      String lastnameEmployee,
      Date ageEmployee,
      String genderEmployee,
      String typeOfDocument,
      String numberOfDocument,
      String address,
      String phoneNumber,
      String emailEmployee) {

    super(
        idEmployee,
        nameEmployee,
        lastnameEmployee,
        ageEmployee,
        genderEmployee,
        typeOfDocument,
        numberOfDocument,
        address,
        phoneNumber,
        emailEmployee);
    this.ID = ID;
    this.cardCompany = cardCompany;
    this.salary = salary;
    this.status = state;
    this.position = position;
    this.schedule = schedule;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "ID="
        + ID
        + ", cardCompany='"
        + cardCompany
        + '\''
        + ", salary="
        + salary
        + ", status="
        + status
        + ", position='"
        + position
        + '\''
        + ", schedule='"
        + schedule
        + '\''
        + '}';
  }
}
