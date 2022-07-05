package entity;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Membership;

import java.util.List;

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
