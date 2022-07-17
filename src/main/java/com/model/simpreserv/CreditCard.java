package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class CreditCard implements Serializable {
  @Serial
  private static final long serialVersionUID = 8769359512255526693L;
  @Setter @Getter private String client;
  @Setter @Getter private String CardName;
  @Setter @Getter private LocalDate expDate;

  @Setter @Getter private double balance;
  public CreditCard() {}

  public CreditCard(String client, String cardName, String date) {
    this.client = client;
    CardName = cardName;
    this.expDate = LocalDate.parse(date);
    this.balance=this.cardBalance();
  }

  public void cardInfo(){
    System.out.println("Cliente: "+this.getClient());
    System.out.println("Tipo de tarja: "+this.getCardName());
    System.out.println("Fecha de expiracion: "+this.getExpDate());
    System.out.println("Balance: "+this.getBalance());
  }

  public double cardBalance(){
    double balance=0;
    if(this.getCardName().compareTo("Visa")==0){
      balance=2800.00;
    }else if (this.getCardName().compareTo("Mastercard")==0){
      balance=3800.00;
    }else if(this.getCardName().compareTo("Discovery")==0){
      balance=4800.00;
    }
    return balance;
  }

  @Override
  public String toString() {
    return "CreditCard{" +
            "client='" + client + '\'' +
            ", CardName='" + CardName + '\'' +
            ", expDate=" + expDate +
            ", balance=" + balance +
            '}';
  }
}
