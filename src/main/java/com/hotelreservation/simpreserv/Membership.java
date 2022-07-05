package com.hotelreservation.simpreserv;

import lombok.Getter;
import lombok.Setter;

public class Membership {
  @Setter @Getter private long id;
  @Setter @Getter private MembershipType membershipType;
  @Setter @Getter private String description;
  @Setter @Getter private double discountPercentage;

  @Setter @Getter private int pointsAmount;

  public Membership(MembershipType membership) {
    this.id++;
    this.membershipType = membership;
    this.description = this.membershipDescription(membership.getMembership());
    this.discountPercentage = this.membershipType.benefits(membership.getMembership());
  }

  public Membership() {}

  public String membershipDescription(String membership) {
    String description = null;
    if (membership.equalsIgnoreCase("Silver")) {
      description = "Membresia Basica";
    } else if (membership.equalsIgnoreCase("Gold")) {
      description = "Membrecia media";
    } else if (membership.equalsIgnoreCase("Platinum")) {
      description = "Membrecia de lujo";
    }
    return description;
  }

  @Override
  public String toString() {
    return "Membership{"
        + "id="
        + id
        + ", membershipType="
        + membershipType
        + ", description='"
        + description
        + '\''
        + ", discountPercentage="
        + discountPercentage
        + ", pointsAmount="
        + pointsAmount
        + '}';
  }
}
