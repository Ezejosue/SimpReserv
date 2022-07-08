package com.controller;

import com.model.simpreserv.Client;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class ClientMethods {
  private final String filePath;

  public ClientMethods() {
    this.filePath = "src\\main\\resources\\clients.dat";
  }

  private Map<Integer, Client> readFromFile() {
    try (FileInputStream fis = new FileInputStream(filePath)) {
      ReadObject ro = new ReadObject(filePath);
      return (Map<Integer, Client>) ro.loadInputStream(fis);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void saveAllRecords(Map<Integer, Client> listRecords) {
    WriteObject wo = new WriteObject(filePath, listRecords);
    wo.writeToFile();
  }

  public Map<Integer, Client> loadAllRecords() {
    return readFromFile();
  }

  public void addNewRecord(Client newClient) {
    int lastId;
    Map<Integer, Client> list = loadAllRecords();
    if (list.size() != 0) {
      lastId = list.get(list.size()).getId();
    } else {
      lastId = 0;
    }
    lastId++;
    newClient.setId(lastId);
    list.put(lastId, newClient);
    saveAllRecords(list);
  }

  public Client findRecordById(int id) {//Devuelve una lista
    Map<Integer, Client> list = loadAllRecords();
    return list.get(id);
  }


  public Client findRecordByDocNumber(String docNumber) {
    Map<Integer, Client> list = loadAllRecords();
    Client client = new Client();
    for (Map.Entry<Integer, Client> item : list.entrySet()) {
      if (item.getValue().getNumberOfDocument().equals(docNumber)) {
        client = item.getValue();
        break;
      }
    }
    return client;
  }

  public void updateRecordById(int id, Client newClient) {
    Map<Integer, Client> list = loadAllRecords();
    list.replace(id, newClient);
    saveAllRecords(list);
  }

  public void deleteRecordById(int id) {
    Map<Integer, Client> list = loadAllRecords();
    list.remove(id);
    saveAllRecords(list);
  }

  public void showClients() {
    Map<Integer, Client> list = loadAllRecords();
    for (Map.Entry<Integer, Client> item : list.entrySet()) {
      System.out.println(item.getKey() + " - " + item.getValue());
    }
  }

}
