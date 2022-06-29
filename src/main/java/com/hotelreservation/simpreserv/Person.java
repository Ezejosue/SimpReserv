package com.hotelreservation.simpreserv;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Setter
    @Getter
    private int ID;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String lastname;
    @Setter
    @Getter
    private Date age;
    @Setter
    @Getter
    private String gender;
    @Setter
    @Getter
    private String typeOfDocument;
    @Setter
    @Getter
    private String numberOfDocument;
    @Setter
    @Getter
    private String address;
    @Setter
    @Getter
    private String phoneNumber;
    @Setter
    @Getter
    private String email;

    public Person() {
    };

    public Person(int ID, String name, String lastname, Date age, String gender, String typeOfDocument,
            String numberOfDocument, String address, String phoneNumber, String email) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.typeOfDocument = typeOfDocument;
        this.numberOfDocument = numberOfDocument;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    };
}
