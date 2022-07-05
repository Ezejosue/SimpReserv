package controller;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.ClientData;
import com.hotelreservation.simpreserv.Membership;
import com.hotelreservation.simpreserv.MembershipType;
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

  @Override//Solicitar membrecia
  public void requestMembership(Client client, String name, String membership) {
    ClientData list=new ClientData();
    MembershipType mt=new MembershipType(membership);
    Membership mn=new Membership(mt);
    for(int i=0;i<list.clientList().size();i++){
      if(list.clientList().get(i).getName().compareTo(name)==0){
        client=list.clientList().get(i);
      }
    }

    if (client.getMembership()!=null){
      System.out.println("Este cliente ya pose membresia");
    }else {
      System.out.println("Su membrecia ha sido agregada");
      client.setMembership(mn);
    }

  }

  @Override
  public Membership cancelMembership(Client client, String name) {
    return null;
  }
}
