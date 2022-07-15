package com.controller;

import com.enums.ReservationStatus;
import com.model.simpreserv.*;
import com.entity.ControllerInterface;
import com.entity.EmployeeControllerInterface;

import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControllerEmployee implements EmployeeControllerInterface, ControllerInterface {
  private static final String MSG1="El cliente o no existe o el nombre es incorrecto. Revise la lista porfavor.";
  private static final String MSG2="Si el cliente no esta en la lista porfavor regresar al menu principal para agregarlo";
   
  @Override
  public void processPayment(String name, String dateIn, String dateOut) {
    //Review client List(Paso 1 y paso 2)
    ClientMethods clientM=new ClientMethods();
    EmployeeMethods em=new EmployeeMethods();
    RoomMethods rooms=new RoomMethods();
    ReservationMethods rm=new ReservationMethods();
    Client aux=clientM.findRecordByName(name);
    Reservation res = rm.findRecordByClientName(name);
    /*
    if(aux.getName()==null){
      System.out.println(MSG1);
      System.out.println(MSG2);
      clientM.showClients();
    }else{
      res.setPaidStatus(true);
      LocalDate dIn= LocalDate.parse(dateIn);
      LocalDate dOut = LocalDate.parse(dateOut);
      LocalDate paymentDate=LocalDate.now();
      long numberOFDays = DAYS.between(dIn, dOut);
      double total= numberOFDays*rooms.findRecordById(1).getRoomPrice();
      Payment py=new Payment(total);
      res.setCheckInDate(dIn);
      res.setCheckOutDate(dOut);
      res.setRoom(rooms.findRecordById(1));
      res.setReservationStatus(ReservationStatus.CONFIRM);
      res.setReservationPrice(py.getTotalPayment());
      rm.updateRecordById(aux.getId(),res);
    }
    rm.showReservations();
    
     */
  }

  @Override
  public void cancelPayment() {}

  @Override
  public void viewBalance() {}

  @Override
  public void viewHotelInformation() {

  }

  @Override
  public void viewCard(String name) {
    ClientMethods cm=new ClientMethods();
    Client aux=cm.findRecordByName(name);
    if(aux.getName()==null){
      System.out.println(MSG1);
      System.out.println(MSG2);
      cm.showClients();
    }else if(aux.getName().compareTo(name)==0){
     aux.getCreditCardInfo().cardInfo();
    }

  }

  @Override
  public void removeCard(String cardOwner) {
    ClientMethods cm=new ClientMethods();
    Client aux=cm.findRecordByName(cardOwner);
    if(aux.getName()==null){
      System.out.println(MSG1);
      System.out.println(MSG2);
      cm.showClients();
    }else if(aux.getName().compareTo(cardOwner)==0){
      aux.setCreditCardInfo(null);
      cm.updateRecordById(aux.getId(),aux);
      System.out.println("La tarjeta de credito ha sido eliminada exitosamente");
      cm.showClients();
    }
  }

  @Override
  public void addCard(String cardOwner, String cardName, String expDate) {
    ClientMethods cm=new ClientMethods();
    CreditCard cc=new CreditCard(cardOwner,cardName,expDate);
    Client aux=cm.findRecordByName(cardOwner);
    if(aux.getName()==null){
      System.out.println(MSG1);
      System.out.println(MSG2);
      cm.showClients();
    }else if(aux.getName().compareTo(cardOwner)==0){
      aux.setCreditCardInfo(cc);
      cm.updateRecordById(aux.getId(),aux);
      System.out.println("La tarjeta de credito ha sido agregada exitosamente");
      cm.showClients();
    }

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
    Client aux=cm.findRecordByName(name);

    if(aux.getName()==null){
      System.out.println(MSG1);
      System.out.println(MSG2);
      cm.showClients();
    }else if(aux.getName().compareTo(name)==0){
      aux.setMembership(mn);
      cm.updateRecordById(aux.getId(),aux);
      System.out.println("La membrecia ha sido agregada exitosamente");
      cm.showClients();
    }
  }

  @Override //Metodo cancelar la membresia
  public void cancelMembership(String name) {
    ClientMethods cm=new ClientMethods();
    Client aux=cm.findRecordByName(name);

    if(aux.getName()==null){
      System.out.println(MSG1);
      System.out.println(MSG2);
      cm.showClients();
    }else if(aux.getName().compareTo(name)==0){
      aux.setMembership(null);
      cm.updateRecordById(aux.getId(),aux);
      System.out.println("La membrecia ha sido cancelada exitosamente");
      cm.showClients();
    }



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


  }
  public static void main(String[] args) {
   ControllerEmployee ce=new ControllerEmployee();
   ce.requestMembership("Gold","Jhon Doe");
   ce.processPayment("Jhon Doe","2022-07-16","2022-07-21");
  }

}
