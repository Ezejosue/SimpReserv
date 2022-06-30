package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Reservation {
  @Getter @Setter private int id;
  @Getter @Setter private Client idClient;
  @Getter @Setter private Employee idEmployee;
  @Getter @Setter private Room idRoom;
  @Getter @Setter private String reservationType;
  @Getter @Setter private Date reservationDate;
  @Getter @Setter private Date admissionDate;
  @Getter @Setter private Date departureDate;
  @Getter @Setter private float reservationPrice;
  @Getter @Setter private Enum reservationState;

  public Reservation(
      Client idClient,
      Employee idEmployee,
      Room idRoom,
      String reservationType,
      Date reservationDate,
      Date admissionDate,
      Date departureDate,
      float reservationPrice,
      Enum reservationState) {
    this.id++;
    this.idClient = idClient;
    this.idEmployee = idEmployee;
    this.idRoom = idRoom;
    this.reservationType = reservationType;
    this.reservationDate = reservationDate;
    this.admissionDate = admissionDate;
    this.departureDate = departureDate;
    this.reservationPrice = reservationPrice;
    this.reservationState = reservationState;
  }

  public Reservation() {}
}
