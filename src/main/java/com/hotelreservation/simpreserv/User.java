package com.hotelreservation.simpreserv;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class User {

  @Getter @Setter private int ID;
  @Getter @Setter private String userName;
  @Getter @Setter private String password;
  @Getter @Setter private String typeOfUser;
  @Getter @Setter private Date registerDate;
  @Getter @Setter private Enum logged;

  public User() {}

  public void login() {}

  public void register() {}

  public void updateProfile() {}

  public void passwordRecovery() {}
}
