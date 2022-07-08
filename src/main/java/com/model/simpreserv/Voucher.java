package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.controller.HotelMethods;
import lombok.Getter;
import lombok.Setter;

public class Voucher implements Serializable {
  @Serial
  private static final long serialVersionUID = 868134809357923068L;
  @Setter @Getter private int voucherId;
  @Setter @Getter private Date issueDate;
  @Setter @Getter private double paymentAmount;

  public Voucher(double amount) {
    this.voucherId++;
    this.paymentAmount = amount;
    this.issueDate = new Date();
  }

  public void printVoucher() {

    Client client = new Client();
    Employee employee = new Employee();
    Room room = new Room();
    HotelMethods hotelMethods = new HotelMethods();
    Hotel hotel = hotelMethods.loadRecord();

    hotel.getName();
    hotel.getLocation();
    hotel.getCategory();
    /*
    System.out.println("Codigo: " + this.getVoucherId());
    System.out.println("Precio: " + this.getPaymentAmount());
    System.out.println("Fecha: " + this.getIssueDate());
    System.out.println("Hotel: " + hotel.getName());
    System.out.println("Direccion: " + hotel.getLocation());
    System.out.println("Numero habitacion: " + room.getRoomNumber());
    System.out.println("Piso: " + room.getRoomFloor());
    System.out.println("Tipo habitacion: " + room.getRoomType());
    System.out.println("Nombre del cliente: " + client.getName());
    System.out.println("Atendido por: " + employee.getName());  */

  }

  @Override
  public String toString() {
    return "Voucher{"
        + "voucherId="
        + voucherId
        + ", issueDate="
        + issueDate
        + ", paymentAmount="
        + paymentAmount
        + '}';
  }
}
