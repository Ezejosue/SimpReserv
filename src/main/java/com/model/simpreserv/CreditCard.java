package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;
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

  public CreditCard(String client, String cardName, Date expDate) {
    this.client = client;
    CardName = cardName;
    this.expDate = expDate;
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
