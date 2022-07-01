package com.hotelreservation.simpreserv;

import lombok.Getter;
import lombok.Setter;

public class Membership {
  @Setter @Getter private long id;
  @Setter @Getter private MembershipType membershipType;
  @Setter @Getter private String description;
  @Setter @Getter private double discountPercentage;

  @Setter @Getter private int pointsAmount;

  public Membership(String membershipType, String description, MembershipType membership) {
    this.id++;
    this.membershipType.setMembership(membershipType);
    this.description = description;
    this.discountPercentage = this.membershipDiscounts(membership);
  }

  public Membership() {}

  public double membershipDiscounts(MembershipType m) {
    if (m.getMembership().equalsIgnoreCase("Silver")) {
      this.setDiscountPercentage(10.0);
    } else if (m.getMembership().equalsIgnoreCase("Gold")) {
      this.setDiscountPercentage(20.0);
    } else if (m.getMembership().equalsIgnoreCase("Platinum")) {
      this.setDiscountPercentage(20.0);
    }
    return this.getDiscountPercentage();
  }
}
