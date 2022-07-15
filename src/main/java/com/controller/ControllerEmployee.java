package com.controller;

import com.enums.ReservationStatus;
import com.model.simpreserv.*;
import com.entity.ControllerInterface;
import com.entity.EmployeeControllerInterface;

import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControllerEmployee implements EmployeeControllerInterface, ControllerInterface {

   
  @Override
  public void processPayment(String name, String dateIn, String dateOut) {//This method process the payment
    //Step 1: calling all the object
    ClientMethods clientM=new ClientMethods();
    EmployeeMethods em=new EmployeeMethods();
    RoomMethods rooms=new RoomMethods();
    ReservationMethods rm=new ReservationMethods();
    Client aux=clientM.findRecordByName(name);
    Reservation res = rm.findRecordByClientName(name);

    if(aux.getName()==null) {//review if the called object is null
      System.out.println(MSG1);
      System.out.println(MSG2);
      clientM.showClients();
    } else{//Process the payment itself
      res.setPaidStatus(true);
      LocalDate dIn= LocalDate.parse(dateIn);
      LocalDate dOut = LocalDate.parse(dateOut);
      LocalDate paymentDate=LocalDate.now();
      res.setReservationDate(paymentDate);
      res.setCheckInDate(dIn);
      res.setCheckOutDate(dOut);
      res.setReservationStatus(ReservationStatus.CONFIRM);
      res.setReservationPrice(this.daysCalculator(name,dateIn,dateOut));
      res.setReservationDate(paymentDate);
      res.setClient(aux);
      rm.updateRecordById(aux.getId(),res);
      System.out.println("------El-Pago-Se-Ha-Completado-Exitosamente------");
    }
    System.out.println("____________________");
    System.out.println("");

    rm.showReservations();
  }
  public double daysCalculator(String name, String dateIn, String dateOut){
      ReservationMethods rm=new ReservationMethods();
      Reservation res = rm.findRecordByClientName(name);
      LocalDate dIn= LocalDate.parse(dateIn);
      LocalDate dOut = LocalDate.parse(dateOut);
      long numberOFDays = DAYS.between(dIn, dOut);
      double total= numberOFDays*res.getRoom().getRoomPrice();
      Payment py=new Payment(total);
      return py.getTotalPayment();
  }

  @Override
  public void cancelPayment(String nombre) {
    //Review client List(Paso 1 y paso 2)
    ClientMethods clientM=new ClientMethods();
    ReservationMethods rm=new ReservationMethods();
    Client aux=clientM.findRecordByName(nombre);
    Reservation res = rm.findRecordByClientName(nombre);

    if(aux.getName()==null) {
      System.out.println(MSG1);
      System.out.println(MSG2);
      clientM.showClients();
    } else{
      res.setPaidStatus(false);
      res.setReservationStatus(ReservationStatus.CANCELLED);
      res.setReservationPrice(0.0);
      res.setClient(aux);
      rm.updateRecordById(aux.getId(),res);
      System.out.println("------La cancelacion ha sido completad-------");
    }
    System.out.println("");
    System.out.println("____________________");
    System.out.println("");


  }

  @Override
  public void viewHotelInformation() {
   HotelMethods hotelMethods=new HotelMethods();

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

  @Override//Request Membership
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
//These methods are related with the menu options
  public void membershipMenu(){
    Scanner sc=new Scanner(System.in);
    ControllerEmployee cm=new ControllerEmployee();
    System.out.println("Seleccione el tipo de membrecia");
    System.out.println("1-Silver, 2-Gold, 3-Platinum");
    String opt=sc.nextLine();
    if(opt.equalsIgnoreCase("1")){
      System.out.println(MSG3);
      opt=sc.nextLine();
      cm.requestMembership("Silver",opt);
    } else if (opt.equalsIgnoreCase("2")) {
      System.out.println(MSG3);
      opt=sc.nextLine();
      cm.requestMembership("Gold",opt);
    }else if (opt.equalsIgnoreCase("3")){
      System.out.println(MSG3);
      opt=sc.nextLine();
      cm.requestMembership("Plantinum",opt);
    }

  }

  public void cancelMenu(){
    Scanner sc=new Scanner(System.in);
    ControllerEmployee cm=new ControllerEmployee();
      System.out.println(MSG3);
      String opt=sc.nextLine();
      cm.cancelMembership(opt);
  }

    public void addCardMenu(){
        Scanner sc=new Scanner(System.in);
        ControllerEmployee cm=new ControllerEmployee();
        System.out.println(MSG3);
        String opt=sc.nextLine();
        System.out.println("Seleccione el tipo de tarjeta");
        System.out.println("1-Visa, 2-Mastercard, 3-Discovery");
        String opt2=sc.nextLine();
        System.out.println("Escriba la fecha de expiracion: YYYY-MM-DD");
        String opt3=sc.nextLine();
        if(opt2.equalsIgnoreCase("1")){
            cm.addCard(opt,"Visa",opt3);
        } else if (opt2.equalsIgnoreCase("2")) {
            cm.addCard(opt,"Mastercard",opt3);
        }else if (opt2.equalsIgnoreCase("3")){
            cm.addCard(opt,"Discovery",opt3);
        }
    }

    public void removeCardMenu(){
        Scanner sc=new Scanner(System.in);
        ControllerEmployee cm=new ControllerEmployee();
        System.out.println(MSG3);
        String opt=sc.nextLine();
        cm.removeCard(opt);
    }

    public void cardInfoMenu(){
        Scanner sc=new Scanner(System.in);
        ControllerEmployee cm=new ControllerEmployee();
        System.out.println(MSG3);
        String opt=sc.nextLine();
        cm.viewCard(opt);
    }

    public void processPaymentMenu(){
        Scanner sc=new Scanner(System.in);
        ControllerEmployee cm=new ControllerEmployee();
        System.out.println(MSG3);
        String opt=sc.nextLine();
        System.out.println("Fecha de entrada: YYYY-MM-DD");
        String opt2=sc.nextLine();
        System.out.println("Fecha de salida: YYYY-MM-DD");
        String opt3=sc.nextLine();
        cm.processPayment(opt,opt2,opt3);

    }

    public void cancelPaymentMenu(){
        Scanner sc=new Scanner(System.in);
        ControllerEmployee cm=new ControllerEmployee();
        System.out.println(MSG3);
        String opt=sc.nextLine();
        cm.cancelPayment(opt);
    }

}
