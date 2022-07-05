package com.simpreserv.exe;

import com.hotelreservation.simpreserv.*;
import controller.ControllerEmployee;

public class SimpReserv {

  public static void main(String[] args) {
    //Menu login = new Menu();
   // login.initialize();

    ClientData cd=new ClientData();
    ControllerEmployee ce=new ControllerEmployee();
    ce.requestMembership(cd.clientList().get(1),"Miguel","Silver");


  }
}
