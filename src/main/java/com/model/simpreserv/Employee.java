package com.model.simpreserv;

import com.controller.EmployeeMethods;
import com.enums.EmployeeStatus;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Employee extends Person implements Serializable {
  @Serial private static final long serialVersionUID = 463034257352516815L;
  @Setter @Getter private int id;
  @Setter @Getter private String carnet;
  @Setter @Getter private double salary;
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
      String carnet,
      double salary,
      EmployeeStatus status,
      String position,
      String schedule) {
    super(name, dateOfBirth, gender, numberOfDocument, email);
    this.id = employeeId;
    this.carnet = carnet;
    this.salary = salary;
    this.status = status;
    this.position = position;
    this.schedule = schedule;
  }

  public void addEmployee(Employee emp) {
    EmployeeMethods empData = new EmployeeMethods();
    empData.addNewRecord(emp);
  }

  public Employee searchEmployeeById(int id) {
    EmployeeMethods empData = new EmployeeMethods();
    return empData.findRecordById(id);
  }

  public Employee searchEmployeeByCarnet(String cardCompany) {
    EmployeeMethods empData = new EmployeeMethods();
    return empData.findRecordByCardCompany(cardCompany);
  }

  public Employee searchEmployeeByName(String name){
    EmployeeMethods empData = new EmployeeMethods();
    return empData.findRecordByName(name);
  }

  public void updateEmployeeById(int id, Employee emp) {
    EmployeeMethods empData = new EmployeeMethods();
    empData.updateRecordById(id, emp);
  }

  public void deleteEmployeeById(int id) {
    EmployeeMethods empData = new EmployeeMethods();
    empData.deleteRecordById(id);
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", cardCompany='"
        + carnet
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
        + "} "
        + super.toString();
  }
}
