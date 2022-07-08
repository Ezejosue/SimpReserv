package com.entity;

import com.model.simpreserv.Client;

public interface EmployeeControllerInterface {

  public void cancelPayments();

  public void processRefund();

  public void updateNights();

  public Client createUser();

  public Client updateUser();

  public Client removeUser();

  public void requestMembership(String membership, String name);

   public void cancelMembership(String name);

}
