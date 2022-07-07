package com.controller;

import com.model.simpreserv.Hotel;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;

public class HotelMethods {
  private final String filePath;

  public HotelMethods() {
    this.filePath = "src\\main\\resources\\hotel.dat";
  }

  private Hotel readFromFile() {
    try (FileInputStream fis = new FileInputStream(filePath)) {
      ReadObject ro = new ReadObject(filePath);
      return (Hotel) ro.loadInputStream(fis);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void saveRecord(Hotel newRecord) {
    WriteObject wo = new WriteObject(filePath, newRecord);
    wo.writeToFile();
  }

  public Hotel loadRecord() {
    return readFromFile();
  }

  public void updateRecord(Hotel newRecord) {
    saveRecord(newRecord);
  }
}
