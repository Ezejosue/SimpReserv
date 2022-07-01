package com.hotelreservation.simpreserv;

import enums.RoomStatus;
import lombok.Getter;
import lombok.Setter;

public class Room {
  @Getter @Setter private int id;
  @Getter @Setter private int roomNumber;
  @Getter @Setter private int roomFloor;
  @Getter @Setter private String roomDescription;
  @Getter @Setter private String roomFeatures;
  @Getter @Setter private float roomPrice;
  @Getter @Setter private String roomType;
  @Getter @Setter private RoomStatus roomState;

  public Room(
      int roomNumber,
      int roomFloor,
      String roomDescription,
      String roomFeatures,
      float roomPrice,
      String roomType,
      RoomStatus roomState) {
    this.id++;
    this.roomNumber = roomNumber;
    this.roomFloor = roomFloor;
    this.roomDescription = roomDescription;
    this.roomFeatures = roomFeatures;
    this.roomPrice = roomPrice;
    this.roomType = roomType;
    this.roomState = roomState;
  }

  public Room() {}
}
