package com.model.simpreserv;

import com.controller.ClientMethods;
import com.controller.ControllerUser;
import com.controller.UserMethods;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class User implements Serializable {
  @Serial
  private static final long serialVersionUID = -7397263011125385531L;

  Calendar calendar = Calendar.getInstance();

  Date dateObj = calendar.getTime();
  @Getter @Setter private int id = 1;
  @Getter @Setter private String userName = "";
  @Getter @Setter private String password = "";
  @Getter @Setter private int typeOfUser = 1;
  @Getter @Setter private Date registerDate = dateObj;

  public User() {}

  public User(int id, String userName, String password, int typeOfUser, Date registerDate) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.typeOfUser = typeOfUser;
    this.registerDate = registerDate;
  }

  public int login(String user, String pass) {
    UserMethods userData = new UserMethods();

    int type = userData.findRecordByUserName(user).getTypeOfUser();
    if (userData.findRecordByUserName(user).getUserName().equals(user)&&userData.findRecordByPassWord(pass).getPassword().equals(pass)&&type==1){
        return 1;
    } else if(userData.findRecordByUserName(user).getUserName().equals(user)&&userData.findRecordByPassWord(pass).getPassword().equals(pass)&&type==2){
      return 2;
    }
    return 0;
  }


  public void addUser(User newUser, String userN){
    UserMethods userData = new UserMethods();
    if (userData.findRecordByUserName(userN).getUserName().equals(userN))
    {
      System.out.println("Ese nombre de usuario ya existe!!");
    } else {

      userData.addNewRecord(newUser);
      System.out.println("Usuario agregado satisfactoriamente.");
    }
  }

  public User searchUserById(int id) {
    UserMethods userData = new UserMethods();
    return userData.findRecordById(id);
  }
  public User searchUserByName(String username) {
    UserMethods userData = new UserMethods();
    return userData.findRecordByUserName(username);
  }

  public void updateUserById(int id, User user) {
    UserMethods userData = new UserMethods();
    userData.updateRecordById(id, user);
  }

  public void deleteUserById(int id) {
    UserMethods userData = new UserMethods();
    userData.deleteRecordById(id);
  }



  @Override
  public String toString() {
    return "User "
        + "id "
        + id
        + " - "
        + super.toString()
        + " | userName: "
        + userName
        + " | password: "
        + password
        + "| typeOfClient: "
        + typeOfUser
        + "| registerDate: "
        + registerDate;
  }
}
