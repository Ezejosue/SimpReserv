package com.model.simpreserv;

import java.util.ArrayList;

public class Clear {

  public void clearScreen() {
    try {
      System.out.println("Presione enter para continuar...");
      new java.util.Scanner(System.in).nextLine();

      String operativeSystem = System.getProperty("os.name");
      ArrayList<String> comando = new ArrayList<String>();
      if (operativeSystem.contains("Windows")) {
        comando.add("cmd");
        comando.add("/C");
        comando.add("cls");
      } else {
        comando.add("clear");
      }

      ProcessBuilder pb = new ProcessBuilder(comando);
      Process initialProcess = pb.inheritIO().start();
      initialProcess.waitFor();

    } catch (Exception ex) {
      System.out.println("Error al limpiar la consola " + ex.getMessage());
    }
  }
}
