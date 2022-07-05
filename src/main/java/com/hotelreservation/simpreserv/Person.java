package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public abstract class Person {//La converti en una clase abstracta
  @Setter @Getter private int ID;
  @Setter @Getter private String name;
  @Setter @Getter private String lastname;
  @Setter @Getter private Date dateOfBirt;
  @Setter @Getter private String gender;
  @Setter @Getter private String numberOfDocument;
  @Setter @Getter private String address;
  @Setter @Getter private String phoneNumber;
  @Setter @Getter private String email;
//Borre el constructor y lo volvi a recrear
  public Person() {}

  public Person(String name, String lastname, Date dateOfBirt, String gender, String numberOfDocument, String address, String phoneNumber, String email) {
    this.ID++;
    this.name = name;
    this.lastname = lastname;
    this.dateOfBirt = dateOfBirt;
    this.gender = gender;
    this.numberOfDocument = numberOfDocument;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Person{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", dateOfBirt=" + dateOfBirt +
            ", gender='" + gender + '\'' +
            ", numberOfDocument='" + numberOfDocument + '\'' +
            ", address='" + address + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
