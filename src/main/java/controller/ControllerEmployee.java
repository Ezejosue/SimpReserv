package controller;

import com.hotelreservation.simpreserv.Client;
import entity.ControllerInterface;
import entity.EmployeeControllerInterface;

public class ControllerEmployee implements EmployeeControllerInterface, ControllerInterface {

  @Override
  public void processPayment() {}

  @Override
  public void cancelPayment() {}

  @Override
  public void viewPoints() {}

  @Override
  public void changePoints() {}

  @Override
  public void viewBalance() {}

  @Override
  public void viewHotelInformation() {}

  @Override
  public void viewCard() {}

  @Override
  public void updateCard() {}

  @Override
  public void removeCard() {}

  @Override
  public void cancelPayments() {}

  @Override
  public void processRefund() {}

  @Override
  public void sendEmail() {}

  @Override
  public void updateNights() {}

  @Override
  public Client createUser() {
    return null;
  }

  @Override
  public Client updateUser() {
    return null;
  }

  @Override
  public Client removeUser() {
    return null;
  }
}
