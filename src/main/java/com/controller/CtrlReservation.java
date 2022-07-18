package com.controller;

import com.entity.IReservationController;
import com.enums.ReservationStatus;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.Reservation;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CtrlReservation implements IReservationController {

    private static final String FILEPATH = "src\\main\\resources\\reservations.dat";

    @Override
    public TreeMap<Integer, Reservation> loadAllReservations() {
        try (FileInputStream fis = new FileInputStream(FILEPATH)) {
            ReadObject ro = new ReadObject(FILEPATH);
            return (TreeMap<Integer, Reservation>)  ro.loadInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAllReservations(Map<Integer, Reservation> reservationsList) {
        WriteObject wo = new WriteObject(FILEPATH, reservationsList);
        wo.writeToFile();
    }

    @Override
    public void addNewReservation(Reservation newReservation) {
        int lastId;
        TreeMap<Integer, Reservation> list = this.loadAllReservations();
        if (list.size() != 0) {
            lastId = list.get(list.lastKey()).getId();
        } else {
            lastId = 0;
        }
        lastId++;
        newReservation.setId(lastId);
        list.put(lastId, newReservation);
        this.saveAllReservations(list);
    }

    @Override
    public Reservation findReservationById(int reservationId) {
        Map<Integer, Reservation> list = this.loadAllReservations();
        return list.get(reservationId);
    }

    @Override
    public Reservation findReservationByClientId(int clientId) {
        Map<Integer, Reservation> list = this.loadAllReservations();
        Reservation reserva = new Reservation();
        for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
            if (item.getValue().getClient().getId() == clientId) {
                reserva = item.getValue();
                break;
            }
        }
        return reserva;
    }

    @Override
    public Reservation findReservationByClientName(String clientName) {
        Map<Integer, Reservation> list = this.loadAllReservations();
        Reservation reserva = new Reservation();
        for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
            if (item.getValue().getClient().getName().equals(clientName)) {
                reserva = item.getValue();
                break;
            }
        }
        return reserva;
    }

    @Override
    public void updateReservationById(int reservationId, Reservation newReservation) {
        Map<Integer, Reservation> list = this.loadAllReservations();
        list.replace(reservationId, newReservation);
        this.saveAllReservations(list);
    }

    @Override
    public void updateReservationStatusById(int reservationId, ReservationStatus reservationStatus) {
        Map<Integer, Reservation> list = this.loadAllReservations();
        list.get(reservationId).setReservationStatus(reservationStatus);
        this.saveAllReservations(list);
    }

    @Override
    public void deleteReservationById(int reservationId) {
        Map<Integer, Reservation> list = this.loadAllReservations();
        list.remove(reservationId);
        this.saveAllReservations(list);
    }

    @Override
    public void printReservationsList() {
        Map<Integer, Reservation> list = this.loadAllReservations();
        for (Map.Entry<Integer, Reservation> item : list.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }

    public static void main (String[] args){
        CtrlReservation test = new CtrlReservation();
        TreeMap<Integer, Reservation> list = test.loadAllReservations();
        System.out.println("Map size = " + list.size());
        System.out.println("Map last id = " + list.lastKey());
        System.out.println("Map data in position 1 = " + list.get(1).toString());
        System.out.println("Map data in position 2 = " + list.get(2).toString());
        System.out.println("Map data in position 3 = " + list.get(3).toString());
        System.out.println("Map data in position 5 = " + list.get(5).toString());
    }
}
