package entity;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Membership;
import com.hotelreservation.simpreserv.Room;

public interface ClientControllerInterface {

  public boolean requestReservation(Client client, String name);

  public boolean cancelReservation(Client client, String name);

  public boolean requestMembership(Client client);

  public void updateMembership(Membership membership);

  public boolean cancelMembership(Client client);

  public void requestDataUpdate(Client client);

  public Room requestRoomCatalog();
}