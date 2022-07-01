package controller;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Membership;
import com.hotelreservation.simpreserv.Payment;
import com.hotelreservation.simpreserv.Room;
import entity.ClientControllerInterface;
import entity.ControllerInterface;
import entity.EmployeeControllerInterface;

public class ControllerClient  implements ClientControllerInterface, ControllerInterface {

    @Override//
    public void requestReservation() {

    }

    @Override//
    public void cancelReservation() {

    }

    @Override//
    public void requestMembership() {

    }

    @Override//
    public void updateMembership(Membership membership) {

    }

    @Override//
    public void cancelMembership() {

    }

    @Override//
    public void requestDataUpdate(Client client) {

    }

    @Override//
    public Room requestRoomCatalog() {
        return null;
    }

    @Override//
    public void processPayment() {

    }

    @Override//
    public void cancelPayment() {

    }

    @Override//
    public void viewPoints() {

    }

    @Override//
    public void changePoints() {

    }

    @Override//
    public void viewBalance() {

    }

    @Override//
    public void viewHotelInformation() {

    }

    @Override
    public void viewCard() {

    }

    @Override
    public void updateCard() {

    }

    @Override
    public void removeCard() {

    }
}
