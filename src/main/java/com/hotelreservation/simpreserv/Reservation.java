package com.hotelreservation.simpreserv;

import enums.ReservationStatus;
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
  @Getter @Setter private Date checkInDate;
  @Getter @Setter private Date checkOutDate;
  @Getter @Setter private float reservationPrice;
  @Getter @Setter private ReservationStatus reservationState;

  public Reservation(String reservationType, Date reservationDate, Date checkInDate, Date checkOutDate, float reservationPrice, ReservationStatus reservationState) {
    this.id++;
    this.idClient = new Client();
    this.idEmployee = new Employee();
    this.idRoom = new Room();
    this.reservationType = reservationType;
    this.reservationDate = reservationDate;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.reservationPrice = reservationPrice;
    this.reservationState = reservationState;
  }

  public Reservation() {}
}
