package com.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements com.entity.UserValidator {

  private static final String PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
  private static final String PATTERNUSER = "^[a-zA-Z0-9._-]{3,}$";

  @Override
  public boolean formatPassword(String pass) {
    Pattern pattern = Pattern.compile(PATTERN);
    Matcher matcher = pattern.matcher(pass);
    if (matcher.matches()){
      return true;
    } else {
      System.out.println("La clave no cumple con el formato!!");
      return false;
    }

  }

  @Override
  public boolean formatUsername(String user) {
    Pattern pattern = Pattern.compile(PATTERNUSER);
    Matcher matcher = pattern.matcher(user);
    if (matcher.matches()){
      return true;
    }else {
      System.out.println("El usuario es muy corto o tiene espacios en blanco!!");
      return false;
    }
  }

  @Override
  public boolean validateTypeUser(int typeU) {
    if (typeU==1||typeU==2){
      return true;
    } else {
      System.out.println("Ese tipo de usuario no existe!!");
      return false;
    }
  }
}
