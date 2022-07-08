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
  @Getter @Setter private Date reservationDate;
  @Getter @Setter private Date checkInDate;
  @Getter @Setter private Date checkOutDate;
  @Getter @Setter private double reservationPrice;
  @Getter @Setter private ReservationStatus reservationStatus;

  public Reservation(
      int id,
      Client client,
      Employee employee,
      Room room,
      Date reservationDate,
      Date checkInDate,
      Date checkOutDate,
      double reservationPrice,
      ReservationStatus reservationStatus) {
    this.id = id;
    this.client = client;
    this.employee = employee;
    this.room = room;
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
    return "Reservation{" +
            "id=" + id +
            ", client=" + client +
            ", employee=" + employee +
            ", room=" + room +
            ", reservationDate=" + reservationDate +
            ", checkInDate=" + checkInDate +
            ", checkOutDate=" + checkOutDate +
            ", reservationPrice=" + reservationPrice +
            ", reservationStatus=" + reservationStatus +
            '}';
  }
}
