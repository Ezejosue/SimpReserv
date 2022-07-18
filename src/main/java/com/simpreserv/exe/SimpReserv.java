package com.simpreserv.exe;

import com.model.simpreserv.*;

import java.text.ParseException;

public class SimpReserv {

  public static void main(String[] args) throws ParseException {

    Loger test = new Loger();
    test.debug("Mensaje de prueba");


    Menu login = new Menu();
    login.initialize();

  }
}
