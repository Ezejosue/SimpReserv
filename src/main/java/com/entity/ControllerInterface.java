package com.entity;

public interface ControllerInterface {

  public void processPayment(String name, String dateIn, String dateOut);

  public void cancelPayment(String nombre);


  public void viewHotelInformation();

  public void viewCard(String name);

  public void removeCard(String cardOwner);

  public void addCard(String cardOwner, String cardName, String expDate);
}
