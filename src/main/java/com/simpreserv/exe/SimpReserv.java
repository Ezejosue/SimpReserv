package com.simpreserv.exe;

import com.hotelreservation.simpreserv.*;

public class SimpReserv {

  public static void main(String[] args) {

    CreateFile createFile = new CreateFile();
    createFile.setCreateFile();

    SendEmail sendEmail = new SendEmail();
    sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Correo de prueba", "Este es un correo de prueba para nuestra aplicacion SimpReserv");

    Menu login = new Menu();
    login.initialize();

  }
}
