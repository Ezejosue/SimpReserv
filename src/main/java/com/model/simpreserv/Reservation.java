package com.model.simpreserv;

import com.controller.CtrlReservation;
import com.controller.ReservationMethods;
import com.enums.ReservationStatus;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

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
  @Getter @Setter private boolean paidStatus;

  public Reservation(
      int id,
      Client client,
      Employee employee,
      Room room,
      Date reservationDate,
      Date checkInDate,
      Date checkOutDate,
      double reservationPrice,
      ReservationStatus reservationStatus,
      boolean paidStatus) {
    this.id = id;
    this.client = client;
    this.employee = employee;
    this.room = room;
    this.reservationDate = reservationDate;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.reservationPrice = reservationPrice;
    this.reservationStatus = reservationStatus;
    this.paidStatus = paidStatus;
  }

  public Reservation() {}

  public void saveAllReservations(Map<Integer, Reservation> reservationsList) {
    CtrlReservation rsvData = new CtrlReservation();
    rsvData.saveAllReservations(reservationsList);
  }
  public void createReservation(Reservation newReserva){
    CtrlReservation rsvData = new CtrlReservation();
    rsvData.addNewReservation(newReserva);
  }

  public Reservation searchReservationById(int reservationId){
    CtrlReservation rsvData = new CtrlReservation();
    return rsvData.findReservationById(reservationId);
  }

  public Reservation searchReservationByClientName(String clientName){
    CtrlReservation rsvData = new CtrlReservation();
    return rsvData.findReservationByClientName(clientName);
  }

  public void updateReservationStatusById(int reservationId, ReservationStatus reservationStatus){
    CtrlReservation rsvData = new CtrlReservation();
    rsvData.updateReservationStatusById(reservationId, reservationStatus);
  }

  public void deleteReservationById(int reservationId){
    CtrlReservation rsvData = new CtrlReservation();
    rsvData.deleteReservationById(reservationId);
  }

  public void printReservations(){
    CtrlReservation rsvData = new CtrlReservation();
    rsvData.printReservationsList();
  }


  @Override
  public String toString() {
    return "Reservation{" +
            "id=" + id +
            " | client=" + client +
            " | employee=" + employee +
            " | room=" + room +
            " | reservationDate=" + reservationDate +
            " | checkInDate=" + checkInDate +
            " | checkOutDate=" + checkOutDate +
            " | reservationPrice=" + reservationPrice +
            " | reservationStatus=" + reservationStatus +
            " | paidStatus=" + paidStatus +
            '}';
  }
}
