package com.hotelreservation.simpreserv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void main(String[] args) {

    try {
      File myFile = new File("SimpReserv.txt");
      Scanner myReader = new Scanner(myFile);

      if (myFile.exists()) {
        System.out.println("Nombre del archivo: " + myFile.getName());
        System.out.println("Ruta absoluta: " + myFile.getAbsolutePath());
        System.out.println("Writeable: " + myFile.canWrite());
        System.out.println("Readable: " + myFile.canRead());
        System.out.println("Tamaño en bytes " + myFile.length());
      } else {
        System.out.println("El archivo no exixte");
      }

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("Ocurrio un error al leer el archivo");
      e.printStackTrace();
    }
  }
}
