package com.hotelreservation.simpreserv;

import controller.Validator;
import lombok.Getter;
import lombok.Setter;

public class Client extends Person {

  Validator val = new Validator();
  @Setter @Getter private int id;
  @Setter @Getter private Membership membership;
  @Setter @Getter private CreditCard creditCardInfo;

  public Client[] clients = new Client[3];

  public Client() {
    super();
  }

  public Client(
      Membership membership,
      CreditCard creditCardInfo,
      int idClient,
      String completeName,
      String birthDay,
      String gender,
      String numberOfDocument,
      String email) {
    super(completeName, birthDay, gender, numberOfDocument, email);
    this.id = idClient;
    this.membership = membership;
    this.creditCardInfo = creditCardInfo;
  }
}
