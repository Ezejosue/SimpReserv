package com.entity;

import com.model.simpreserv.Client;
import com.model.simpreserv.Membership;
import com.model.simpreserv.Room;

public interface ClientControllerInterface {

  public boolean requestReservation(Client client, String name);

  public boolean cancelReservation(Client client, String name);

  public boolean requestMembership(Client client);

  public void updateMembership(Membership membership);

  public boolean cancelMembership(Client client);

  public void requestDataUpdate(Client client);

  public Room requestRoomCatalog();
}
