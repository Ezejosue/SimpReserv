package com.controller;

import com.model.simpreserv.Employee;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class EmployeeMethods {
  private final String filePath;

  public EmployeeMethods() {
    this.filePath = "src\\main\\resources\\employees.dat";
  }

  private Map<Integer, Employee> readFromFile() {
    try (FileInputStream fis = new FileInputStream(filePath)) {
      ReadObject ro = new ReadObject(filePath);
      return (Map<Integer, Employee>) ro.loadInputStream(fis);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void saveAllRecords(Map<Integer, Employee> listRecords) {
    WriteObject wo = new WriteObject(filePath, listRecords);
    wo.writeToFile();
  }

  public Map<Integer, Employee> loadAllRecords() {
    return readFromFile();
  }

  public void addNewRecord(Employee newEmployee) {
    int lastId;
    Map<Integer, Employee> list = loadAllRecords();
    if (list.size() != 0) {
      lastId = list.get(list.size()).getId();
    } else {
      lastId = 0;
    }
    lastId++;
    newEmployee.setId(lastId);
    list.put(lastId, newEmployee);
    saveAllRecords(list);
  }

  public Employee findRecordById(int id) {
    Map<Integer, Employee> list = loadAllRecords();
    return list.get(id);
  }

  public Employee findRecordByCardCompany(String cardCompany) {
    Map<Integer, Employee> list = loadAllRecords();
    Employee employee = new Employee();
    for (Map.Entry<Integer, Employee> item : list.entrySet()) {
      if (item.getValue().getCarnet().equals(cardCompany)) {
        employee = item.getValue();
        break;
      }
    }
    return employee;
  }

  public Employee findRecordByName(String name) {
    Map<Integer, Employee> list = loadAllRecords();
    Employee employee = new Employee();
    for (Map.Entry<Integer, Employee> item : list.entrySet()) {
      if (item.getValue().getName().equals(name)) {
        employee = item.getValue();
        break;
      }
    }
    return employee;
  }

  public void updateRecordById(int id, Employee newEmployee) {
    Map<Integer, Employee> list = loadAllRecords();
    list.replace(id, newEmployee);
    saveAllRecords(list);
  }

  public void deleteRecordById(int id) {
    Map<Integer, Employee> list = loadAllRecords();
    list.remove(id);
    saveAllRecords(list);
  }

  public void showEmployees() {
    Map<Integer, Employee> list = loadAllRecords();
    for (Map.Entry<Integer, Employee> item : list.entrySet()) {
      System.out.println(item.getKey() + " - " + item.getValue());
    }
  }
}
