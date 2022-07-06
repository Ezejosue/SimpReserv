package com.hotelreservation.simpreserv;

import enums.ReservationStatus;
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

  private void saveAllRecords(Map<Integer, Reservation> listRecords) {
    WriteObject wo = new WriteObject(filePath, listRecords);
    wo.writeToFile();
  }

  public Map<Integer, Reservation> loadAllRecords() {
    return readFromFile();
  }

  public void addNewRecord(int id, Reservation newReservation) {
    Map<Integer, Reservation> list = loadAllRecords();
    list.put(id, newReservation);
    saveAllRecords(list);
  }

  public Reservation findRecordById(int id) {
    Map<Integer, Reservation> list = loadAllRecords();
    return list.get(id);
  }

  public Reservation findRecordByClientId(int clientId) {
    Map<Integer, Reservation> list = loadAllRecords();
    Reservation reserva = new Reservation();
    for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
      if (item.getValue().getIdClient().getId() == clientId) {
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
}
