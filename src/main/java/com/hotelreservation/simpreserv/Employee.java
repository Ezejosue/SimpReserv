package com.hotelreservation.simpreserv;

import enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Employee extends Person {
  @Setter @Getter private int ID;
  @Setter @Getter private String cardCompany;//Podemos presindir de este atributo
  @Setter @Getter private int salary;//El salario puede ser una constante
  @Setter @Getter private EmployeeStatus status;
  @Setter @Getter private String position;//Podemos presindir de este atributo
  @Setter @Getter private String schedule;

  public Employee() {
    super();
  }


//Reice el constructor
  public Employee(String cardCompany, int salary, EmployeeStatus status, String position, String schedule) {
    this.ID++;
    this.cardCompany = cardCompany;
    this.salary = salary;
    this.status = status;
    this.position = position;
    this.schedule = schedule;
  }

  public Employee(String name, String lastname, Date dateOfBirt, String gender, String numberOfDocument, String address, String phoneNumber, String email, int ID, String cardCompany, int salary, EmployeeStatus status, String position, String schedule) {
    super(name, lastname, dateOfBirt, gender, numberOfDocument, address, phoneNumber, email);
    this.ID = ID;
    this.cardCompany = cardCompany;
    this.salary = salary;
    this.status = status;
    this.position = position;
    this.schedule = schedule;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "ID=" + ID +
            ", cardCompany='" + cardCompany + '\'' +
            ", salary=" + salary +
            ", status=" + status +
            ", position='" + position + '\'' +
            ", schedule='" + schedule + '\'' +
            '}';
  }
}
