package com.model.simpreserv;

import com.controller.RoomMethods;
import com.enums.RoomFloor;
import com.enums.RoomStatus;
import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

public class Room implements Serializable {
  @Serial private static final long serialVersionUID = -652876445407826972L;
  @Getter @Setter private int id;
  @Getter @Setter private int roomNumber;
  @Getter @Setter private RoomFloor roomFloor;
  @Getter @Setter private String roomDescription;
  @Getter @Setter private double roomPrice;
  @Getter @Setter private String roomType;
  @Getter @Setter private RoomStatus roomStatus;

  public Room(
      int id,
      int roomNumber,
      RoomFloor roomFloor,
      String roomDescription,
      double roomPrice,
      String roomType,
      RoomStatus roomStatus) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.roomFloor = roomFloor;
    this.roomDescription = roomDescription;
    this.roomPrice = roomPrice;
    this.roomType = roomType;
    this.roomStatus = roomStatus;
  }

  public Room() {}

  public int calculateRoomPrice(String roomType) {
    int price;
    if (roomType.equalsIgnoreCase("Single")) {
      price = 95;
    } else if (roomType.equalsIgnoreCase("Double")) {
      price = 83;
    } else if (roomType.equalsIgnoreCase("Triple")) {
      price = 125;
    } else {
      price = 170;
    }
    return price;
  }

  public Room findRoomByNumber(int roomNumber){
    RoomMethods rmData = new RoomMethods();
    return rmData.findRecordByNumber(roomNumber);
  }

  @Override
  public String toString() {
    return "Room Info: " +
            " | id:  " + id +
            " | roomNumber: " + roomNumber +
            " | roomPrice:  " + roomPrice +
            " | roomFloor:  " + roomFloor +
            " | roomType:   " + roomType +
            " | roomStatus: " + roomStatus +
            " | roomDescription: " + roomDescription +
            " \n";
  }

}
