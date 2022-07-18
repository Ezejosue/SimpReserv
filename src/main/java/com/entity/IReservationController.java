package com.entity;

import com.enums.ReservationStatus;
import com.model.simpreserv.Reservation;

import java.util.Map;
import java.util.TreeMap;

public interface IReservationController {
    TreeMap<Integer, Reservation> loadAllReservations();
    void saveAllReservations(Map<Integer, Reservation> reservationsList);
    void addNewReservation(Reservation newReservation);
    Reservation findReservationById(int reservationId);
    Reservation findReservationByClientId(int clientId);
    Reservation findReservationByClientName(String clientName);
    void updateReservationById(int reservationId, Reservation newReservation);
    void updateReservationStatusById(int reservationId, ReservationStatus reservationStatus);
    void deleteReservationById(int reservationId);
    void printReservationsList();

}
