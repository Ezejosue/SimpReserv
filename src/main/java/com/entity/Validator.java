package com.entity;

public interface Validator {
  public String formatDate(String date);
  public boolean formatPassword(String pass);
  public boolean formatUsername(String user);
  public boolean validateTypeUser(int typeU);
}
