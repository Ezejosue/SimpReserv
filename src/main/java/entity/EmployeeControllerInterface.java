package entity;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Membership;

public interface EmployeeControllerInterface {

  public void cancelPayments();

  public void processRefund();

  public void sendEmail();

  public void updateNights();

  public Client createUser();

  public Client updateUser();

  public Client removeUser();

  public Membership requestMembership(Client client, String name);
  public Membership cancelMembership(Client client, String name);
}
