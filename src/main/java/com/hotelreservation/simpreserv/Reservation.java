package com.hotelreservation.simpreserv;

import enums.ReservationStatus;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Reservation implements Serializable {
  @Serial private static final long serialVersionUID = -8851858411740955710L;
  @Getter @Setter private int id;
  @Getter @Setter private Client idClient;
  @Getter @Setter private Employee idEmployee;
  @Getter @Setter private Room idRoom;
  @Getter @Setter private String reservationType;
  @Getter @Setter private Date reservationDate;
  @Getter @Setter private Date checkInDate;
  @Getter @Setter private Date checkOutDate;
  @Getter @Setter private float reservationPrice;
  @Getter @Setter private ReservationStatus reservationStatus;

  public Reservation(
      int id,
      String reservationType,
      Date reservationDate,
      Date checkInDate,
      Date checkOutDate,
      float reservationPrice,
      ReservationStatus reservationStatus) {
    this.id = id;
    this.idClient = new Client();
    this.idEmployee = new Employee();
    this.idRoom = new Room();
    this.reservationType = reservationType;
    this.reservationDate = reservationDate;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.reservationPrice = reservationPrice;
    this.reservationStatus = reservationStatus;
  }

  public Reservation() {}

  @Override
  public String toString() {
    return "Reservation{"
        + "id="
        + id
        + ", idClient="
        + idClient
        + ", idEmployee="
        + idEmployee
        + ", idRoom="
        + idRoom
        + ", reservationType='"
        + reservationType
        + '\''
        + ", reservationDate="
        + reservationDate
        + ", checkInDate="
        + checkInDate
        + ", checkOutDate="
        + checkOutDate
        + ", reservationPrice="
        + reservationPrice
        + ", reservationStatus="
        + reservationStatus
        + '}';
  }
}