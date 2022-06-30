package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Payment {
  @Setter @Getter private long id;
  @Setter @Getter private double tax;
  @Setter @Getter private double totalPayment;
  @Setter @Getter private Date paymentDay;

  public Payment(double totalPayment) {
    this.id++;
    this.tax = totalPayment/100*10;
    this.totalPayment = totalPayment+this.getTax();
    this.paymentDay=new Date();
  }

  public Payment() {}

  @Override
  public String toString() {
    return "Payment{" +
            "id=" + id +
            ", tax=" + tax +
            ", totalPayment=" + totalPayment +
            ", paymentDay=" + paymentDay +
            '}';
  }
}
