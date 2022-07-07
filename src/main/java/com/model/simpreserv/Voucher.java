package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
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
}
