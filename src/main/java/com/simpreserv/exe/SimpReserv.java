package com.simpreserv.exe;

import com.hotelreservation.simpreserv.SendEmail;
import com.model.simpreserv.Menu;
import com.model.simpreserv.Voucher;

public class SimpReserv {

  public static void main(String[] args) {

    Voucher voucher = new Voucher(200.5);
    voucher.printVoucher();

   // SendEmail sendEmail = new SendEmail();
  //  sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Reserva del hotel Hilton", "En el archivo adjunto esta toda la informacion de su reserva");

   // Menu login = new Menu();
   // login.initialize();

  }
}
