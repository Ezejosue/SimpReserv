package controller;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Membership;
import com.hotelreservation.simpreserv.Room;
import entity.ClientControllerInterface;
import entity.ControllerInterface;

public class ControllerClient implements ClientControllerInterface, ControllerInterface {

  @Override //este metodo revisa el objeto cliente y su el nombre coincide delvuelve verdadero
  public boolean requestReservation(Client client, String name) {
    if(client.getName().equalsIgnoreCase(name)){
      return true;
    }else {
      return false;
    }

  }

  @Override //cancela devuel un booleano
  public boolean  cancelReservation(Client client, String name) {
     boolean cancel=true;
    if(this.requestReservation(client,name)==true){
      cancel=false;
    }

    return cancel;
  }

  @Override //
  public boolean requestMembership(Client client) {
    if(client.getMembership()!=null){
      return false;
    }
    return true;
  }

  @Override //
  public void updateMembership(Membership membership) {}

  @Override //
  public boolean cancelMembership(Client client) {
    if(client.getMembership()!=null){
      return true;
    }
    return false;
  }

  @Override //
  public void requestDataUpdate(Client client) {}

  @Override //
  public Room requestRoomCatalog() {
    return requestRoomCatalog();
  }

  @Override //
  public void processPayment() {}

  @Override //
  public void cancelPayment() {}

  @Override //
  public void viewPoints() {}

  @Override //
  public void changePoints() {}

  @Override //
  public void viewBalance() {}

  @Override //
  public void viewHotelInformation() {}

  @Override
  public void viewCard() {}

  @Override
  public void updateCard() {}

  @Override
  public void removeCard() {}
}
