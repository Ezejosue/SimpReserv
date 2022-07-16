package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;

import com.controller.CtrlHotel;
import lombok.Getter;
import lombok.Setter;

public class Hotel implements Serializable {
  @Serial private static final long serialVersionUID = -4571758478266775676L;
  @Getter @Setter private int id;
  @Getter @Setter private String name;
  @Getter @Setter private String location;
  @Getter @Setter private String category;
  @Getter @Setter private int roomQuantity;

  public Hotel(int id, String name, String location, String category, int roomQuantity) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.category = category;
    this.roomQuantity = roomQuantity;
  }

  public Hotel() {}

  public Hotel loadHotelInfo(){
    CtrlHotel htlData = new CtrlHotel();
    return htlData.loadHotelInfo();
  }

  public void saveHotelInfo(Hotel newHotelInfo){
    CtrlHotel htlData = new CtrlHotel();
    htlData.saveHotelInfo(newHotelInfo);
  }

  @Override
  public String toString() {
    return "Hotel{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", location='"
        + location
        + '\''
        + ", category='"
        + category
        + '\''
        + ", roomQuantity="
        + roomQuantity
        + '}';
  }
}
