package com.entity;

import com.model.simpreserv.Client;

public interface EmployeeControllerInterface {
  static final String MSG1="El cliente o no existe o el nombre es incorrecto. Revise la lista porfavor.";
  static final String MSG2="Si el cliente no esta en la lista porfavor regresar al menu principal para agregarlo";

  public Client createUser();

  public Client updateUser();

  public Client removeUser();

  public void requestMembership(String membership, String name);

   public void cancelMembership(String name);

}
