package com.model.simpreserv;

import com.controller.CtrlRoom;
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

  public Room(int id, int roomNumber, RoomFloor roomFloor, String roomDescription, double roomPrice, String roomType, RoomStatus roomStatus) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.roomFloor = roomFloor;
    this.roomDescription = roomDescription;
    this.roomPrice = roomPrice;
    this.roomType = roomType;
    this.roomStatus = roomStatus;
  }

  public Room() {}

  public void saveRoomsList(Map<Integer, Room> roomsList){
    CtrlRoom rmData = new CtrlRoom();
    rmData.saveRoomsList(roomsList);
  }

  public Room searchRoomByNumber(int roomNumber){
    CtrlRoom rmData = new CtrlRoom();
    return rmData.findRoomByRoomNumber(roomNumber);
  }

  public void changeRoomStatusById(int roomId, RoomStatus roomStatus){
    CtrlRoom rmData = new CtrlRoom();
    rmData.updateRoomStatusById(roomId, roomStatus);
  }

  public void printRooms(){
    CtrlRoom rmData = new CtrlRoom();
    rmData.printRoomsList();
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
