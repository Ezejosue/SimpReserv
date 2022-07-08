package com.simpreserv.exe;

import com.controller.ClientMethods;
import com.controller.ControllerEmployee;
import com.model.simpreserv.Menu;

import java.text.ParseException;

public class SimpReserv {

  public static void main(String[] args) throws ParseException {

    /*CreateFile createFile = new CreateFile();
    createFile.setCreateFile();

    SendEmail sendEmail = new SendEmail();
    sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Reserva del hotel Hilton", "En el archivo adjunto esta toda la informacion de su reserva");*/

    Menu login = new Menu();
    login.initialize();


  }
}
