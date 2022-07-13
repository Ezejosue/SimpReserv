package com.entity;

public interface UserValidator {
  public String formatDate(String date);
  public boolean formatPassword(String pass);
  public boolean formatUsername(String user);
  public boolean validateTypeUser(int typeU);
}
