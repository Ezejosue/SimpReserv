package com.hotelreservation.simpreserv;

import java.util.Date;

import enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

public class Reservation {
  @Getter @Setter private int id;
  @Getter @Setter private Client idClient;
  @Getter @Setter private Employee idEmployee;
  @Getter @Setter private Room idRoom;
  @Getter @Setter private String reservationType;
  @Getter @Setter private Date reservationDate;
  @Getter @Setter private Date checkInDate;
  @Getter @Setter private Date checkOutDate;
  @Getter @Setter private float reservationPrice;
  @Getter @Setter private ReservationStatus reservationState;

  public Reservation(
      Client idClient,
      Employee idEmployee,
      Room idRoom,
      String reservationType,
      Date reservationDate,
      Date checkInDate,
      Date checkOutDate,
      float reservationPrice,
      ReservationStatus reservationState) {
    this.id++;
    this.idClient = idClient;
    this.idEmployee = idEmployee;
    this.idRoom = idRoom;
    this.reservationType = reservationType;
    this.reservationDate = reservationDate;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.reservationPrice = reservationPrice;
    this.reservationState = reservationState;
  }

  public Reservation() {}
}
