package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class CreditCard implements Serializable {
  @Serial
  private static final long serialVersionUID = 8769359512255526693L;
  @Setter @Getter private String client;
  @Setter @Getter private String CardName;
  @Setter @Getter private Date expDate;

  public CreditCard() {}

  public CreditCard(String client, String cardName, String date) {
    this.client = client;
    CardName = cardName;
    this.expDate = new Date(date);
  }

  public void cardInfo(){
    System.out.println("Cliente: "+this.getClient());
    System.out.println("Tipo de tarja: "+this.getCardName());
    System.out.println("Fecha de expiracion: "+this.getExpDate());
  }

  @Override
  public String toString() {
    return "CreditCard{" +
            "client=" + client +
            ", CardName='" + CardName + '\'' +
            ", expDate=" + expDate +
            '}';
  }

}
