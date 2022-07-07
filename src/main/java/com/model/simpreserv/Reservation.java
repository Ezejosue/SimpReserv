package com.model.simpreserv;

import com.controller.ReservationMethods;
import com.enums.ReservationStatus;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Reservation implements Serializable {
  @Serial private static final long serialVersionUID = -8851858411740955710L;
  @Getter @Setter private int id;
  @Getter @Setter private Client client;
  @Getter @Setter private Employee employee;
  @Getter @Setter private Room room;
  @Getter @Setter private String reservationType;
  @Getter @Setter private Date reservationDate;
  @Getter @Setter private Date checkInDate;
  @Getter @Setter private Date checkOutDate;
  @Getter @Setter private double reservationPrice;
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
    this.client = new Client();
    this.employee = new Employee();
    this.room = new Room();
    this.reservationType = reservationType;
    this.reservationDate = reservationDate;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.reservationPrice = reservationPrice;
    this.reservationStatus = reservationStatus;
  }

  public Reservation() {}

  public void createReservation(Reservation newReserva){
    ReservationMethods rsmData = new ReservationMethods();
    rsmData.addNewRecord(newReserva);
  }

  @Override
  public String toString() {
    return "Reservation{"
        + "id="
        + id
        + ", idClient="
        + client
        + ", idEmployee="
        + employee
        + ", idRoom="
        + room
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
