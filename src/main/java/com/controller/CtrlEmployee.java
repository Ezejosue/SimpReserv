package com.controller;

import com.entity.IEmployeeController;
import com.model.simpreserv.Employee;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class CtrlEmployee implements IEmployeeController {

    private final static String FILEPATH = "src\\main\\resources\\employees.dat";

    @Override
    public Map<Integer, Employee> loadAllEmployees() {
        try (FileInputStream fis = new FileInputStream(FILEPATH)) {
            ReadObject ro = new ReadObject(FILEPATH);
            return (Map<Integer, Employee>) ro.loadInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> employeesList) {
        WriteObject wo = new WriteObject(FILEPATH, employeesList);
        wo.writeToFile();
    }

    @Override
    public void addNewEmployee(Employee newEmployee) {
        int lastId;
        Map<Integer, Employee> list = this.loadAllEmployees();
        if (list.size() != 0) {
            lastId = list.get(list.size()).getId();
        } else {
            lastId = 0;
        }
        lastId++;
        newEmployee.setId(lastId);
        list.put(lastId, newEmployee);
        this.saveAllEmployees(list);
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        Map<Integer, Employee> list = this.loadAllEmployees();
        return list.get(employeeId);
    }

    @Override
    public Employee findEmployeeByCarnet(String carnet) {
        Map<Integer, Employee> list = this.loadAllEmployees();
        Employee employee = new Employee();
        for (Map.Entry<Integer, Employee> item : list.entrySet()) {
            if (item.getValue().getCarnet().equals(carnet)) {
                employee = item.getValue();
                break;
            }
        }
        return employee;
    }

    @Override
    public Employee findEmployeeByName(String name) {
        Map<Integer, Employee> list = this.loadAllEmployees();
        Employee employee = new Employee();
        for (Map.Entry<Integer, Employee> item : list.entrySet()) {
            if (item.getValue().getName().equals(name)) {
                employee = item.getValue();
                break;
            }
        }
        return employee;
    }

    @Override
    public void updateEmployeeById(int employeeId, Employee newEmployee) {
        Map<Integer, Employee> list = this.loadAllEmployees();
        list.replace(employeeId, newEmployee);
        this.saveAllEmployees(list);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        Map<Integer, Employee> list = this.loadAllEmployees();
        list.remove(employeeId);
        this.saveAllEmployees(list);
    }

    public void printEmployeesList() {
        Map<Integer, Employee> list = this.loadAllEmployees();
        for (Map.Entry<Integer, Employee> item : list.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }
}
