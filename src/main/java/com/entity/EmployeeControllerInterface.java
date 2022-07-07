package com.entity;

import com.model.simpreserv.Client;

public interface EmployeeControllerInterface {

  public void cancelPayments();

  public void processRefund();

  public void sendEmail();

  public void updateNights();

  public Client createUser();

  public Client updateUser();

  public Client removeUser();

  public void requestMembership(Client client, String name);

  // public void cancelMembership(Client client, String name);
}
