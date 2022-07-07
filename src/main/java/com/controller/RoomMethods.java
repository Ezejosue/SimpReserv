package com.controller;

import com.model.simpreserv.ReadObject;
import com.model.simpreserv.Room;
import com.model.simpreserv.WriteObject;
import com.enums.RoomStatus;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class RoomMethods {
  private final String filePath;

  public RoomMethods() {
    this.filePath = "src\\main\\resources\\rooms.dat";
  }

  private Map<Integer, Room> readFromFile() {
    try (FileInputStream fis = new FileInputStream(filePath)) {
      ReadObject ro = new ReadObject(filePath);
      return (Map<Integer, Room>) ro.loadInputStream(fis);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void saveAllRecords(Map<Integer, Room> listRecords) {
    WriteObject wo = new WriteObject(filePath, listRecords);
    wo.writeToFile();
  }

  public Map<Integer, Room> loadAllRecords() {
    return readFromFile();
  }

  public void addNewRecord(int id, Room newRoom) {
    Map<Integer, Room> list = loadAllRecords();
    list.put(id, newRoom);
    saveAllRecords(list);
  }

  public Room findRecordById(int id) {
    Map<Integer, Room> list = loadAllRecords();
    return list.get(id);
  }

  public Room findRecordByNumber(int roomNumber) {
    Map<Integer, Room> list = loadAllRecords();
    Room room = new Room();
    for (Map.Entry<Integer, Room> item : list.entrySet()) {
      if (item.getValue().getRoomNumber() == roomNumber) {
        room = item.getValue();
        break;
      }
    }
    return room;
  }

  public Map<Integer, Room> findRecordByType(String roomType) {
    Map<Integer, Room> list = loadAllRecords();
    Map<Integer, Room> filteredList = new TreeMap<>();
    for (Map.Entry<Integer, Room> item : list.entrySet()) {
      if (item.getValue().getRoomType().equals(roomType)) {
        filteredList.put(item.getKey(), item.getValue());
      }
    }
    return filteredList;
  }

  public void updateRecordById(int id, Room newRoom) {
    Map<Integer, Room> list = loadAllRecords();
    list.replace(id, newRoom);
    saveAllRecords(list);
  }

  public void updateRecordStatusById(int id, RoomStatus roomStatus) {
    Map<Integer, Room> list = loadAllRecords();
    list.get(id).setRoomStatus(roomStatus);
    saveAllRecords(list);
  }

  public void deleteRecordById(int id) {
    Map<Integer, Room> list = loadAllRecords();
    list.remove(id);
    saveAllRecords(list);
  }
}
