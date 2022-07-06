package com.simpreserv.exe;

import com.hotelreservation.simpreserv.*;

public class SimpReserv {

  public static void main(String[] args) {

    CreateFile createFile = new CreateFile();
    createFile.setCreateFile();

    Menu login = new Menu();
    login.initialize();

  }
}
