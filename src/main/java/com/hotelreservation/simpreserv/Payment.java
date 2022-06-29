package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Payment {
  @Setter @Getter private long id;
  @Setter @Getter private int idReservation;
  @Setter @Getter private Voucher voucher;
  @Setter @Getter private double tax;
  @Setter @Getter private double fullPayment;
  @Setter @Getter private Date issueDate;
  @Setter @Getter private Date paymentDay;

  public Payment(long id, int idReservation, Voucher voucher, double tax, double fullPayment, Date issueDate, Date paymentDay) {
    this.id = id;
    this.idReservation = idReservation;
    this.voucher = voucher;
    this.tax = tax;
    this.fullPayment = fullPayment;
    this.issueDate = issueDate;
    this.paymentDay = paymentDay;
  }

  public Payment() {}
}
