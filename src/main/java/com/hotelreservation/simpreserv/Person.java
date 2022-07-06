package com.hotelreservation.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public abstract class Person implements Serializable {
  @Serial private static final long serialVersionUID = 2847339137205318831L;
  @Setter @Getter private String name;
  @Setter @Getter private String dateOfBirth;
  @Setter @Getter private String gender;
  @Setter @Getter private String numberOfDocument;
  @Setter @Getter private String email;

  public Person(
      String name, String dateOfBirth, String gender, String numberOfDocument, String email) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.numberOfDocument = numberOfDocument;
    this.email = email;
  }

  public Person() {}

  @Override
  public String toString() {
    return "Person{"
        + "name='"
        + name
        + '\''
        + ", dateOfBirth='"
        + dateOfBirth
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", numberOfDocument='"
        + numberOfDocument
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
}
