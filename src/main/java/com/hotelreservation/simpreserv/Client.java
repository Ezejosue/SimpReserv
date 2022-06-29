package com.hotelreservation.simpreserv;

import entity.PaymentInterface;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Client extends Person implements PaymentInterface{
  @Setter @Getter private int ID;
  @Setter @Getter private String membership;
  @Setter @Getter private String creditCardInfo;

  public Client() {
    super();
  }

  public Client(
      int ID,
      String membership,
      String creditCardInfo,
      int idClient,
      String nameClient,
      String lastnameClient,
      Date ageClient,
      String genderClient,
      String typeOfDocument,
      String numberOfDocument,
      String address,
      String phoneNumber,
      String emailClient) {
    super(
        idClient,
        nameClient,
        lastnameClient,
        ageClient,
        genderClient,
        typeOfDocument,
        numberOfDocument,
        address,
        phoneNumber,
        emailClient);
    this.ID = ID;
    this.membership = membership;
    this.creditCardInfo = creditCardInfo;
  }
  
  @Override
  public String viewPoints() {
    return null;
  }

  @Override
  public void applyPoints() {

  }

  @Override
  public void setMembership() {

  }

  @Override
  public void cancelMembership() {

  }

  @Override
  public void updateMembership() {
  }
}
