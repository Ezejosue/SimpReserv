package com.entity;

import com.model.simpreserv.Client;

public interface EmployeeControllerInterface {
  static final String MSG1="El cliente o no existe o el nombre es incorrecto. Revise la lista porfavor.";
  static final String MSG2="Si el cliente no esta en la lista porfavor regresar al menu principal para agregarlo";
  static final String MSG3="Escriba el nombre del cliente";


  public void requestMembership(String membership, String name);

   public void cancelMembership(String name);

}
