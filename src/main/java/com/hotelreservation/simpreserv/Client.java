package com.hotelreservation.simpreserv;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Client extends Person {
  @Setter @Getter private int ID;
  @Setter @Getter private Membership membership;
  @Setter @Getter private CreditCard creditCardInfo;
  private List<Person> persons;

  public Client() {
    super();
  }

  public Client(int ID, Membership membership, CreditCard creditCardInfo, List<Person> persons) {
    this.ID = ID;
    this.membership = membership;
    this.creditCardInfo = creditCardInfo;
    this.persons = persons;
  }

  @Override
  public String toString() {
    return "Client{"
        + "ID="
        + ID
        + ", membership='"
        + membership
        + '\''
        + ", creditCardInfo='"
        + creditCardInfo
        + '\''
        + ", persons="
        + persons
        + '}';
  }
}
