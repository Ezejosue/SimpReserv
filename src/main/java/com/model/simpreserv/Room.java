package com.model.simpreserv;

import com.enums.RoomFloor;
import com.enums.RoomStatus;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Room implements Serializable {
  @Serial private static final long serialVersionUID = -652876445407826972L;
  @Getter @Setter private int id;
  @Getter @Setter private int roomNumber;
  @Getter @Setter private RoomFloor roomFloor;
  @Getter @Setter private String roomDescription;
  @Getter @Setter private String roomFeatures;
  @Getter @Setter private float roomPrice;
  @Getter @Setter private String roomType;
  @Getter @Setter private RoomStatus roomStatus;

  public Room(
      int id,
      int roomNumber,
      RoomFloor roomFloor,
      String roomDescription,
      String roomFeatures,
      float roomPrice,
      String roomType,
      RoomStatus roomStatus) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.roomFloor = roomFloor;
    this.roomDescription = roomDescription;
    this.roomFeatures = roomFeatures;
    this.roomPrice = roomPrice;
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
