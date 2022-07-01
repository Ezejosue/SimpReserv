package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Voucher {
  @Setter @Getter private long voucherId;
  @Setter @Getter private Date issueDate;
  @Setter @Getter private Payment paymentAmount;

  public Voucher(double amount) {
    this.voucherId++;
    this.paymentAmount = new Payment(amount);
    this.issueDate = new Date();
  }

  public void printVoucher() {
    Client client = new Client();
    Employee employee = new Employee();

    System.out.println(this.getVoucherId());
    System.out.println(this.getPaymentAmount());
    System.out.println(this.getIssueDate());
    System.out.println(client.toString());
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

  public static void main(String[] args) {
    Voucher voucher = new Voucher(150.02);

    voucher.printVoucher();
  }
}
