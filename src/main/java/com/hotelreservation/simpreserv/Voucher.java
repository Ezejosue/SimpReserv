package com.hotelreservation.simpreserv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Voucher {
  @Setter @Getter private long voucherId;
  @Setter @Getter private  Date issueDate;
  @Setter @Getter private Payment paymentAmount;
 // @Setter @Getter private Client client;
//  @Setter @Getter private Employee employee;

  public Voucher(double amount) {
    this.voucherId++;
    this.paymentAmount=new Payment(amount);
   // this.client.setName(client);
   // this.employee.setName(employee);
    this.issueDate = new Date();
  }


  @Override
  public String toString() {
    return "Voucher{" +
            "voucherId=" + voucherId +
            ", issueDate=" + issueDate +
            ", paymentAmount=" + paymentAmount +
            '}';
  }

  public static void main(String[] args) {

    Voucher vaucher=new Voucher(356.89);

    System.out.println(vaucher);
  }

}
