package com.hotelreservation.simpreserv;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Voucher {
  @Setter @Getter private long voucherId;
  @Setter @Getter private static Date issueDate;
  @Setter @Getter private Payment paymentAmount;
  @Setter @Getter private Client client;
  @Setter @Getter private Employee employee;

  public Voucher(Date issueDate, Payment paymentAmount, Client client, Employee employee) {
    this.voucherId++;
    this.issueDate = issueDate;
    this.paymentAmount = paymentAmount;
    this.client = client;
    this.employee = employee;
  }

  public Voucher() {}

  public List<String> generateVoucher(List<String> list) {
    list.add(String.valueOf(this.getVoucherId()));
     this.getIssueDate().getTime();
    list.add(String.valueOf(this.getPaymentAmount().getFullPayment()));
     list.add(this.getClient().getName());
     list.add(this.getEmployee().getName());
    return list;
  }

  public static void main(String[] args) {
    getIssueDate().setTime(22/5/1958);
  }
}
