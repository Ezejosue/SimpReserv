package com.hotelreservation.simpreserv;

import enums.RoomStatus;
import lombok.Getter;
import lombok.Setter;

public class Room {
  @Getter @Setter private int id;
  @Getter @Setter private int roomNumber;
  @Getter @Setter private Enum roomFloor;
  @Getter @Setter private String roomDescription;
  @Getter @Setter private String roomFeatures;
  @Getter @Setter private float roomPrice;
  @Getter @Setter private String roomType;
  @Getter @Setter private Enum roomStatus;

  public Room(
      int roomNumber,
      Enum roomFloor,
      String roomDescription,
      String roomFeatures,
      String roomType,
      RoomStatus roomStatus) {
    this.id++;
    this.roomNumber = roomNumber;
    this.roomFloor = roomFloor;
    this.roomDescription = roomDescription;
    this.roomFeatures = roomFeatures;
    this.roomPrice = this.calculateRoomPrice(roomType);
    this.roomType = roomType;
    this.roomStatus = roomStatus;
  }

  public Room() {}

  public void roomInfo(String roomType) {
    System.out.println("Habitacion #: " + this.getRoomNumber());
    System.out.println("Piso: " + this.getRoomFloor());
    System.out.println("Descripcion: " + this.getRoomDescription());
    System.out.println("Precio: " + this.getRoomPrice());
    System.out.println("Estado: " + this.getRoomStatus());
  }

  public int calculateRoomPrice(String roomType) {
    int price = 0;
    if (roomType.equalsIgnoreCase("Simple")) {
      price = 95;
    } else if (roomType.equalsIgnoreCase("Double")) {
      price = 83;
    } else if (roomType.equalsIgnoreCase("Queen")) {
      price = 125;
    } else {
      price = 170;
    }
    return price;
  }

  @Override
  public String toString() {
    return "Room{"
        + "id="
        + id
        + ", roomNumber="
        + roomNumber
        + ", roomFloor="
        + roomFloor
        + ", roomDescription='"
        + roomDescription
        + '\''
        + ", roomFeatures='"
        + roomFeatures
        + '\''
        + ", roomPrice="
        + roomPrice
        + ", roomType='"
        + roomType
        + '\''
        + ", roomStatus="
        + roomStatus
        + '}';
  }
}
