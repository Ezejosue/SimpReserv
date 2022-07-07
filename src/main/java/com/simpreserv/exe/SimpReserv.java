package com.simpreserv.exe;

import com.hotelreservation.simpreserv.*;
import controller.ControllerEmployee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpReserv {

  public static void main(String[] args) {

    CreateFile createFile = new CreateFile();
    createFile.setCreateFile();

    SendEmail sendEmail = new SendEmail();
    sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Reserva del hotel Hilton", "En el archivo adjunto esta toda la informacion de su reserva");

    Menu login = new Menu();
    login.initialize();

  }
}
