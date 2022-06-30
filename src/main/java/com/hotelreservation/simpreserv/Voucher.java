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
  @Setter @Getter private Client client;
  @Setter @Getter private Employee employee;

  public Voucher(double amount) {
    this.voucherId++;
    this.paymentAmount=new Payment(amount);
    this.client.getName();
    this.employee.getName();
    this.issueDate = new Date();
  }


  public List<String> generateVoucher(List<String> list) {
    Client cl=new Client();
    cl.setName("Andres");
    this.setClient(cl);
    Employee emp=new Employee();
    cl.setName("Josue");
    this.setEmployee(emp);

    list.add(String.valueOf(this.getVoucherId()));
    list.add(String.valueOf(this.paymentAmount.getTotalPayment()));
    list.add(this.getClient().getName());
    list.add(this.getEmployee().getName());
    list.add(this.getIssueDate().toString());
    return list;
  }

  @Override
  public String toString() {
    return "Voucher{" +
            "voucherId=" + voucherId +
            ", issueDate=" + issueDate +
            ", paymentAmount=" + paymentAmount +
            ", client=" + client +
            ", employee=" + employee +
            '}';
  }

  public static void main(String[] args) {


    Voucher va=new Voucher(356.98);

    List<String >list=new ArrayList<>();

    list=va.generateVoucher(list);

    list.get(0);
    System.out.println(list.get(0));
  }

}
