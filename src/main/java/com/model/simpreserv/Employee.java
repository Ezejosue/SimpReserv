package com.model.simpreserv;

import com.controller.CtrlEmployee;
import com.enums.EmployeeStatus;
import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

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

  public Employee(int employeeId, String name, String dateOfBirth, String gender, String numberOfDocument, String email, String carnet, double salary, EmployeeStatus status, String position, String schedule) {
    super(name, dateOfBirth, gender, numberOfDocument, email);
    this.id = employeeId;
    this.carnet = carnet;
    this.salary = salary;
    this.status = status;
    this.position = position;
    this.schedule = schedule;
  }

  public void saveAllEmployees(Map<Integer, Employee> employeesList){
    CtrlEmployee empData = new CtrlEmployee();
    empData.saveAllEmployees(employeesList);
  }
  public void addEmployee(Employee emp) {
    CtrlEmployee empData = new CtrlEmployee();
    empData.addNewEmployee(emp);
  }

  public Employee searchEmployeeById(int id) {
    CtrlEmployee empData = new CtrlEmployee();
    return empData.findEmployeeById(id);
  }

  public Employee searchEmployeeByCarnet(String cardCompany) {
    CtrlEmployee empData = new CtrlEmployee();
    return empData.findEmployeeByCarnet(cardCompany);
  }

  public Employee searchEmployeeByName(String name){
    CtrlEmployee empData = new CtrlEmployee();
    return empData.findEmployeeByName(name);
  }

  public void updateEmployeeById(int id, Employee emp) {
    CtrlEmployee empData = new CtrlEmployee();
    empData.updateEmployeeById(id, emp);
  }

  public void deleteEmployeeById(int id) {
    CtrlEmployee empData = new CtrlEmployee();
    empData.deleteEmployeeById(id);
  }

  public void printEmployees() {
    CtrlEmployee empData = new CtrlEmployee();
    empData.printEmployeesList();
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
