package com.simpreserv.exe;

import com.controller.ClientMethods;
import com.controller.HotelMethods;
import com.controller.RoomMethods;
import com.hotelreservation.simpreserv.SendEmail;
import com.model.simpreserv.*;

import java.text.ParseException;

public class SimpReserv {

  public static void main(String[] args) throws ParseException {

    Voucher voucher = new Voucher(400.5);

    HotelMethods hotelMethods = new HotelMethods();
    Hotel hotel = hotelMethods.loadRecord();

    ClientMethods clientMethods = new ClientMethods();
    Client client = clientMethods.findRecordById(1);

    RoomMethods roomMethods = new RoomMethods();
    Room room = roomMethods.findRecordById(1);

    CreateFile createFile = new CreateFile();
    createFile.setCreateFile(hotel, client, room);

    SendEmail sendEmail = new SendEmail();
    sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Reserva del hotel Sea Sand",
            "En el archivo adjunto esta toda la informacion de su reserva" + "\n" + "\n" + "Saludos cordiales");

   // Menu login = new Menu();
   // login.initialize();

    Menu login = new Menu();
    login.initialize();


  }
}
