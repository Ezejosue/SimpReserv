package com.hotelreservation.simpreserv;

import controller.ControllerUser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class User {
  SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
  Calendar calendar = Calendar.getInstance();

  Date dateObj = calendar.getTime();
  @Getter @Setter private int ID = 1;
  @Getter @Setter private String userName = "";
  @Getter @Setter private String password = "";
  @Getter @Setter private int typeOfUser = 1;
  @Getter @Setter private Date registerDate = dateObj;

  private User[] users = new User[3];

  public User() {
    chargeInformation();
  }

  public User(int ID, String userName, String password, int typeOfUser, Date registerDate) {
    this.ID = ID;
    this.userName = userName;
    this.password = password;
    this.typeOfUser = typeOfUser;
    this.registerDate = registerDate;
  }

  public int login(String user, String pass) {
    ControllerUser con = new ControllerUser();

    for (int i = 0; i < users.length; i++) {
      if (con.validatePassword(users[i].getPassword(), pass) == true
          && con.validateUser(users[i].getUserName(), user) == true
          && con.validateTypeOfUser(users[i].getTypeOfUser()) == 1) {
        return 1;
      } else if (con.validatePassword(users[i].getPassword(), pass) == true
          && con.validateUser(users[i].getUserName(), user) == true
          && con.validateTypeOfUser(users[i].getTypeOfUser()) == 2) {
        return 2;
      }
    }
    return 0;
  }

  public void register() {}

  public void chargeInformation() {

    User user = new User(1, "Josue", "12345", 1, dateObj);
    users[0] = user;
    User user2 = new User(2, "Carlos", "1234", 2, dateObj);
    users[1] = user2;
    User user3 = new User(3, "Stalyn", "123", 1, dateObj);
    users[2] = user3;
  }

  public void updateProfile() {}

  public void passwordRecovery() {}
}
