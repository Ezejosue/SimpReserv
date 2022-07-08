package com.entity;

public interface ControllerInterface {

  public void processPayment();

  public void cancelPayment();

  public void viewPoints();

  public void changePoints();

  public void viewBalance();

  public void viewHotelInformation();

  public void viewCard(String name);

  public void updateCard();

  public void removeCard(String cardOwner);

  public void addCard(String cardOwner, String cardName, String expDate);
}
