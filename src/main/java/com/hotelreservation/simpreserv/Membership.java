package com.hotelreservation.simpreserv;
import lombok.Setter;
import lombok.Getter;

public class Membership {
    @Setter @Getter
    private long id;
    @Setter @Getter
    private MembershipType membershipType;
    @Setter @Getter
    private String description;
    @Setter @Getter
    private double discountPercentage;

    public Membership(long id, MembershipType membershipType, String description, double discountPercentage) {
        this.id = id;
        this.membershipType = membershipType;
        this.description = description;
        this.discountPercentage = discountPercentage;
    }

    public Membership() {

    }



}
