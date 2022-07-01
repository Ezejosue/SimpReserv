package com.hotelreservation.simpreserv;

import lombok.Getter;
import lombok.Setter;

public class Hotel {
  @Getter @Setter private int id;
  @Getter @Setter private String name;
  @Getter @Setter private String location;
  @Getter @Setter private String category;
  @Getter @Setter private int roomQuantity;

  public Hotel(String name, String location, String category, int roomQuantity) {
    this.id++;
    this.name = name;
    this.location = location;
    this.category = category;
    this.roomQuantity = roomQuantity;
  }

  public Hotel() {}
}
