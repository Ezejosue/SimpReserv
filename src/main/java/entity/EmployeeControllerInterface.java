package entity;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Payment;

public interface EmployeeControllerInterface {

  public void cancelPayments();
  public void processRefund();
  public void sendEmail();
  public void updateNights();
  public Client createUser();
  public Client updateUser();
  public Client removeUser();

}
