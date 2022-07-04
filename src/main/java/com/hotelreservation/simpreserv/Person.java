package com.hotelreservation.simpreserv;

import controller.Validator;
import lombok.Getter;
import lombok.Setter;

public class Person {
  @Setter @Getter private int ID;
  @Setter @Getter private String name;
  @Setter @Getter private String dateOfBirt;
  @Setter @Getter private String gender;
  @Setter @Getter private String numberOfDocument;
  @Setter @Getter private String email;


  public Person() {}
  ;

  public Person(
      int ID,
      String name,
      String dateOfBirt,
      String gender,
      String numberOfDocument,
      String email) {
    this.ID = ID;
    this.name = name;
    this.dateOfBirt = dateOfBirt;
    this.gender = gender;
    this.numberOfDocument = numberOfDocument;
    this.email = email;
  };
  public void chargeInformation(){};


}
