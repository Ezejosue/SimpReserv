package com.controller;

import com.entity.UserControllerInterface;

public class ControllerUser implements UserControllerInterface {

  @Override
  public boolean validatePassword(String password, String password1) {
    if (password.equals(password1)) {
      return true;
    } else {

      return false;
    }
  }

  @Override
  public boolean validateUser(String user, String user1) {
    if (user.equals(user1)) {
      return true;
    } else {

      return false;
    }
  }

  @Override
  public int validateTypeOfUser(int userType) {
    if (userType == 2) {
      return 2;
    } else if (userType == 1) {

      return 1;
    } else {
      return 3;
    }
  }
}
