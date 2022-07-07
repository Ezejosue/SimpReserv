package com.hotelreservation.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class CreditCard implements Serializable {
  @Serial
  private static final long serialVersionUID = -808952222592281123L;
  @Setter @Getter private Client client;
  @Setter @Getter private String CardName;
  @Setter @Getter private Date expDate;

  public CreditCard() {}

  public CreditCard(Client client, String cardName, long expDate) {
    this.client = client;
    CardName = cardName;
    this.expDate = new Date(expDate);
  }

  @Override
  public String toString() {
    return "CreditCard{"
        + "client="
        + client
        + ", CardName='"
        + CardName
        + '\''
        + ", expDate="
        + expDate
        + '}';
  }
}
