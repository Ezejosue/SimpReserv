package com.hotelreservation.simpreserv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

  public static void main(String[] args) {

    try {
      File myFile = new File("SimpReserv.txt");
      if (myFile.createNewFile()) {
        System.out.println("Archivo creado: " + myFile.getName());
      } else {
        System.out.println("Archivo ya existe.");
      }

    } catch (IOException e) {
      System.out.println("Ocurrio un error al crear el archivo");
      e.printStackTrace();
    }

    try {
      FileWriter fileWriter = new FileWriter("SimpReserv.txt");
      fileWriter.write("Creando un archivo para nuestra aplicacion SimpReserv");
      fileWriter.close();
      System.out.println("Se agrego texto al archivo");

    } catch (IOException e) {
      System.out.println("Error al agregarle contenido al archivo");
      e.printStackTrace();
    }
  }
}
