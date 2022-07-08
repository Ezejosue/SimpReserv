package com.controller;


import com.model.simpreserv.*;
import com.entity.ControllerInterface;
import com.entity.EmployeeControllerInterface;

import java.util.*;

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
  public void viewHotelInformation() {

  }

  @Override
  public void viewCard(String name) {
    ClientMethods cm=new ClientMethods();
    cm.loadAllRecords();


    int id=0;
    for (int i=1;i<cm.loadAllRecords().size();i++){
      if(cm.findRecordById(i).getName().compareTo(name)==0){
        cm.findRecordById(i).getCreditCardInfo().cardInfo();
      }
    }
  }

  @Override
  public void updateCard() {}

  @Override
  public void removeCard(String cardOwner) {
    ClientMethods cm=new ClientMethods();
    cm.loadAllRecords();

    Client aux;
    int id=0;
    for (int i=1;i<cm.loadAllRecords().size();i++){
      if(cm.findRecordById(i).getName().compareTo(cardOwner)==0){
        aux=cm.findRecordById(i);
        aux.setCreditCardInfo(null);
        id=i;
        cm.updateRecordById(id,aux);
        System.out.println("La tarjeta de credito ha sido eliminada exitosamente");
      }
    }
    cm.showClients();
  }

  @Override
  public void addCard(String cardOwner, String cardName, String expDate) {
    ClientMethods cm=new ClientMethods();
    CreditCard cc=new CreditCard(cardOwner,cardName,expDate);
    Iterator<Map.Entry<Integer, Client>> entries = cm.loadAllRecords().entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<Integer, Client> entry = entries.next();
      if(entry.getValue().getName().compareTo(cardOwner)==0){
        entry.getValue().setCreditCardInfo(cc);
        cm.updateRecordById(entry.getKey(), entry.getValue());
        System.out.println("La la tarjeta de credito ha sido agregada ha sido agregada");
      }
    }
    cm.showClients();

  }

  @Override
  public void cancelPayments() {}

  @Override
  public void processRefund() {}


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
  public void requestMembership(String membership, String name) {
    ClientMethods cm=new ClientMethods();
    MembershipType mt=new MembershipType(membership);
    Membership mn=new Membership(mt);


    Iterator<Map.Entry<Integer, Client>> entries = cm.loadAllRecords().entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<Integer, Client> entry = entries.next();
      if(entry.getValue().getName().compareTo(name)==0){
        entry.getValue().setMembership(mn);
        cm.updateRecordById(entry.getKey(), entry.getValue());
        System.out.println("La membrecia ha sido agregada");
      }else if(entry.getValue().getName().compareTo(name)!=0&& entries.hasNext()==false){
        System.out.println("El nombre del cliente no es correcto");
        System.out.println("Favor consultar la lista de clientes a continuacion");
      }
    }
    cm.showClients();
  }

  @Override //Metodo cancelar la membresia
  public void cancelMembership(String name) {
    ClientMethods cm=new ClientMethods();
    cm.loadAllRecords();

    Iterator<Map.Entry<Integer, Client>> entries = cm.loadAllRecords().entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<Integer, Client> entry = entries.next();
      if(entry.getValue().getName().compareTo(name)==0){
        entry.getValue().setMembership(null);
        cm.updateRecordById(entry.getKey(), entry.getValue());
        System.out.println("La membrecia ha sido Cancelada");
      }else if(entry.getValue().getName().compareTo(name)!=0&& entries.hasNext()==false){
        System.out.println("El nombre del cliente no es correcto");
        System.out.println("Favor consultar la lista de clientes a continuacion");
      }
    }
    cm.showClients();

  }

  public void membershipMenu(){
    Scanner sc=new Scanner(System.in);
    ControllerEmployee cm=new ControllerEmployee();
    System.out.println("Seleccione el tipo de membrecia");
    System.out.println("1-Silver, 2-Gold, 3-Platinum");
    String opt=sc.nextLine();
    if(opt.equalsIgnoreCase("1")){
      System.out.println("Escriba el nombre del cliente");
      opt=sc.nextLine();
      cm.requestMembership("Silver",opt);
    } else if (opt.equalsIgnoreCase("2")) {
      System.out.println("Escriba el nombre del cliente");
      opt=sc.nextLine();
      cm.requestMembership("Gold",opt);
    }else if (opt.equalsIgnoreCase("3")){
      System.out.println("Escriba el nombre del cliente");
      opt=sc.nextLine();
      cm.requestMembership("Plantinum",opt);
    }


  }

  public void cancelMenu(){
    Scanner sc=new Scanner(System.in);
    ControllerEmployee cm=new ControllerEmployee();
    System.out.println("Escriba el nombre del cliente");
    String var=sc.nextLine();
    cm.cancelMembership(var);
  }

}
