package com.controller;

import com.model.simpreserv.Client;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.User;
import com.model.simpreserv.WriteObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class UserMethods {
  private final String filePath;

  public UserMethods() {
    this.filePath = "src\\main\\resources\\users.dat";
  }

  private Map<Integer, User> readFromFile() {
    try (FileInputStream fis = new FileInputStream(filePath)) {
      ReadObject ro = new ReadObject(filePath);
      return (Map<Integer, User>) ro.loadInputStream(fis);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void saveAllRecords(Map<Integer, User> listRecords) {
    WriteObject wo = new WriteObject(filePath, listRecords);
    wo.writeToFile();
  }

  public Map<Integer, User> loadAllRecords() {
    return readFromFile();
  }

  public void addNewRecord(User newUser) {
    int lastId;
    Map<Integer, User> list = loadAllRecords();
    if (list.size() != 0) {
      lastId = list.get(list.size()).getId();
    } else {
      lastId = 0;
    }
    lastId++;
    newUser.setId(lastId);
    list.put(lastId, newUser);
    saveAllRecords(list);
  }

  public User findRecordById(int id) {
    Map<Integer, User> list = loadAllRecords();
    return list.get(id);
  }

  public User findRecordByTypeOfUser(int typeOfUser) {
    Map<Integer, User> list = loadAllRecords();
    User user = new User();
    for (Map.Entry<Integer, User> item : list.entrySet()) {
      if (item.getValue().getTypeOfUser()==typeOfUser) {
        user = item.getValue();
        break;
      }
    }
    return user;
  }

  public User findRecordByUserName(String userName) {
    Map<Integer, User> list = loadAllRecords();
    User user = new User();
    for (Map.Entry<Integer, User> item : list.entrySet()) {
      if (item.getValue().getUserName().equals(userName)) {
        user = item.getValue();
        break;
      }
    }
    return user;
  }
  public User findRecordByPassWord(String password) {
    Map<Integer, User> list = loadAllRecords();
    User user = new User();
    for (Map.Entry<Integer, User> item : list.entrySet()) {
      if (item.getValue().getPassword().equals(password)) {
        user = item.getValue();
        break;
      }
    }
    return user;
  }
  public void updateRecordById(int id, User newUser) {
    Map<Integer, User> list = loadAllRecords();
    list.replace(id, newUser);
    saveAllRecords(list);
  }

  public void deleteRecordById(int id) {
    Map<Integer, User> list = loadAllRecords();
    list.remove(id);
    saveAllRecords(list);
  }

  public void showUsers() {
    Map<Integer, User> list = loadAllRecords();
    for (Map.Entry<Integer, User> item : list.entrySet()) {
      System.out.println(item.getKey() + " - " + item.getValue());
    }
  }
}