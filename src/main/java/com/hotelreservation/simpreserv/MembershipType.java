package com.hotelreservation.simpreserv;

import lombok.Getter;
import lombok.Setter;

public class MembershipType {
  @Setter @Getter private String membership;
  @Setter @Getter private double benefits;

  public MembershipType() {}

  public MembershipType(String membership) {
    this.membership = membership;
    this.benefits = this.benefits(membership);
  }

  public double benefits(String membership) {
    this.setMembership(membership);
    if (this.getMembership().equalsIgnoreCase("Silver")) {
      this.setBenefits(10);
    } else if (this.getMembership().equalsIgnoreCase("Gold")) {
      this.setBenefits(20);
    } else if (this.getMembership().equalsIgnoreCase("Platinum")) {
      this.setBenefits(30);
    }
    return this.getBenefits();
  }

  @Override
  public String toString() {
    return "MembershipType{" + "membership='" + membership + '\'' + ", benefits=" + benefits + '}';
  }
}
