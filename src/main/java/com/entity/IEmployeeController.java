package com.entity;

import com.model.simpreserv.Employee;

import java.util.Map;

public interface IEmployeeController {
    Map<Integer, Employee> loadAllEmployees();
    void saveAllEmployees(Map<Integer, Employee> employeesList);
    void addNewEmployee(Employee newEmployee);
    Employee findEmployeeById(int employeeId);
    Employee findEmployeeByCarnet(String carnet);
    Employee findEmployeeByName(String name);
    void updateEmployeeById(int employeeId, Employee newEmployee);
    void deleteEmployeeById(int employeeId);
    void printEmployeesList();
}
