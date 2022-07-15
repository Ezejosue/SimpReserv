package com.controller;

import com.model.simpreserv.Client;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.Reservation;
import com.model.simpreserv.WriteObject;
import com.enums.ReservationStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class ReservationMethods {
  private final String filePath;

  public ReservationMethods() {
    this.filePath = "src\\main\\resources\\reservations.dat";
  }

  private Map<Integer, Reservation> readFromFile() {
      try (FileInputStream fis = new FileInputStream(filePath)) {
        ReadObject ro = new ReadObject(filePath);
        return (Map<Integer, Reservation>) ro.loadInputStream(fis);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
  }

  public void saveAllRecords(Map<Integer, Reservation> listRecords) {
    WriteObject wo = new WriteObject(filePath, listRecords);
    wo.writeToFile();
  }

  public Map<Integer, Reservation> loadAllRecords() {
    return readFromFile();
  }

  public void addNewRecord(Reservation newReservation) {
    int lastId;
    Map<Integer, Reservation> list = loadAllRecords();
    if (list.size() != 0) {
      lastId = list.get(list.size()).getId();
    } else {
      lastId = 0;
    }
    lastId++;
    newReservation.setId(lastId);
    list.put(lastId, newReservation);
    //saveAllRecords(list);
    this.saveAllRecords(list);
  }

  public Reservation findRecordById(int id) {
    Map<Integer, Reservation> list = loadAllRecords();
    return list.get(id);
  }

  public Reservation findRecordByClientId(int clientId) {
    Map<Integer, Reservation> list = loadAllRecords();
    Reservation reserva = new Reservation();
    for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
      if (item.getValue().getClient().getId() == clientId) {
        reserva = item.getValue();
        break;
      }
    }
    return reserva;
  }
  //Metodo de prueba
  public Reservation findRecordByClientName(String  clientName) {
    Map<Integer, Reservation> list = loadAllRecords();
    Reservation reserva = new Reservation();
    for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
      if (item.getValue().getClient().getName().compareTo(clientName)==0) {
        reserva = item.getValue();
        break;
      }
    }
    return reserva;
  }

  public void updateRecordById(int id, Reservation newReservation) {
    Map<Integer, Reservation> list = loadAllRecords();
    list.replace(id, newReservation);
    saveAllRecords(list);
  }


  public void updatePamentStatus(int id, boolean payment) {//Metodo que actualiza el pago
    Map<Integer, Reservation> list = loadAllRecords();
    list.get(id).setPaidStatus(payment);
    saveAllRecords(list);
  }

  public void updateRecordStatusById(int id, ReservationStatus reservationStatus) {
    Map<Integer, Reservation> list = loadAllRecords();
    list.get(id).setReservationStatus(reservationStatus);
    saveAllRecords(list);
  }

  public void deleteRecordById(int id) {
    Map<Integer, Reservation> list = loadAllRecords();
    list.remove(id);
    saveAllRecords(list);
  }

  public void showReservations() {
    Map<Integer, Reservation> list = loadAllRecords();
    for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
      System.out.println(item.getKey() + " - " + item.getValue());
    }
  }
}
