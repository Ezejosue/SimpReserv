package com.simpreserv.exe;

import com.hotelreservation.simpreserv.*;

public class SimpReserv {

  public static void main(String[] args) {

    CreateFile createFile = new CreateFile();
    createFile.setCreateFile();

    SendEmail sendEmail = new SendEmail();
    sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Reserva del hotel Hilton2", "En el archivo adjunto esta toda la informacion de su reserva2");

    Menu login = new Menu();
    login.initialize();

  }
}
