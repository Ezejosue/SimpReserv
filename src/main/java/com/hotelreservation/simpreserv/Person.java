package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Person {
  @Setter @Getter private int ID;
  @Setter @Getter private String name;
  @Setter @Getter private String lastname;
  @Setter @Getter private Date dateOfBirt;
  @Setter @Getter private String gender;
  @Setter @Getter private String numberOfDocument;
  @Setter @Getter private String address;
  @Setter @Getter private String phoneNumber;
  @Setter @Getter private String email;

  public Person() {}
  ;

  public Person(
      String name,
      String lastname,
      long dateOfBirt,
      String gender,
      String numberOfDocument,
      String address,
      String phoneNumber,
      String email) {
    this.ID++;
    this.name = name;
    this.lastname = lastname;
    this.dateOfBirt = new Date(dateOfBirt);
    this.gender = gender;
    this.numberOfDocument = numberOfDocument;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }
  ;
}
