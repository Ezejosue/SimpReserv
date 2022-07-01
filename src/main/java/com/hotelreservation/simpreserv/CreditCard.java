package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class CreditCard {
  @Setter @Getter private Client client;
  @Setter @Getter private String CardName;
  @Setter @Getter private Date expDate;

  public CreditCard() {}

  public CreditCard(Client client, String cardName, Date expDate) {
    this.client = client;
    CardName = cardName;
    this.expDate = expDate;
  }
}
