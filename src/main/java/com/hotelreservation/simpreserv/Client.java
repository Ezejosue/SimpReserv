package com.hotelreservation.simpreserv;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Client extends Person {
  @Setter @Getter private int ID;
  @Setter @Getter private Membership membership;
  @Setter @Getter private CreditCard creditCardInfo;
  //private List<Person> persons; Borre la lista de personas

  public Client() {
    super();
  }


  public Client(String name, String lastname, Date dateOfBirt, String gender, String numberOfDocument, String address, String phoneNumber, String email, int ID, Membership membership, CreditCard creditCardInfo) {
    super(name, lastname, dateOfBirt, gender, numberOfDocument, address, phoneNumber, email);
    this.ID++;
    this.membership = membership;
    this.creditCardInfo = creditCardInfo;
  }

  @Override
  public String toString() {
    return "Client{" +
            "ID=" + ID +
            ", membership=" + membership +
            ", creditCardInfo=" + creditCardInfo +
            '}';
  }
}
