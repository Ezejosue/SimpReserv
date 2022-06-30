package com.hotelreservation.simpreserv;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Client extends Person {
  @Setter @Getter private int ID;
  @Setter @Getter private String membership;
  @Setter @Getter private String creditCardInfo;
  private List<Person> persons;

  public Client() {
    super();
  }

  public Client(
      int ID,
      String membership,
      String creditCardInfo,
      List<Person> persons
   ) {
    this.ID = ID;
    this.membership = membership;
    this.creditCardInfo = creditCardInfo;
    this.persons=persons;
  }
<<<<<<< Updated upstream
=======




>>>>>>> Stashed changes
}
