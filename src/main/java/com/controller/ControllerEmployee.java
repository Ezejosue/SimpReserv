package com.controller;

import com.model.simpreserv.Client;
import com.entity.ControllerInterface;
import com.entity.EmployeeControllerInterface;

import java.util.ArrayList;
import java.util.List;

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

  @Override//Solicitar membrecia
  public void requestMembership(Client client, String name) {
    List<Client> list=new ArrayList<>();
    for (int i=0;i<list.size();i++){
      if (list.get(i).getName().compareTo("Jose")==0){
        client=list.get(i);
        list.remove(i);
      }
    }

    if (client.getMembership()==null){
     // client.setMembership(mn);
      list.add(client);
    }

    for (Client cl:list) {
      System.out.println(cl);
    }

  }
/*
  @Override //Metodo cancela la membresia
  public void cancelMembership(Client client, String name) {
    ClientData list=new ClientData();

    for(int i=0;i<list.clientList().size();i++){
      if(list.clientList().get(i).getName().compareTo(name)==0){
        client=list.clientList().get(i);
      }
    }

    if (client.getMembership()!=null){
      System.out.println("Su membresia ha sido cancelada");
        client.setMembership(null);
    }else {
      System.out.println("Su membrecia ya habia sido cancelada antes");
    }
  }*/
}
