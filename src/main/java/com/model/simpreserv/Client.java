package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;

import com.controller.ClientMethods;
import lombok.Getter;
import lombok.Setter;

public class Client extends Person implements Serializable {
  @Serial private static final long serialVersionUID = -7397263021828385531L;
  @Setter @Getter private int id;
  @Setter @Getter private Membership membership;
  @Setter @Getter private CreditCard creditCardInfo;

  public Client() {
    super();
  }

  public Client(Membership membership, CreditCard creditCardInfo, int idClient, String completeName, String birthDay, String gender, String numberOfDocument, String email) {
    super(completeName, birthDay, gender, numberOfDocument, email);
    this.id = idClient;
    this.membership = membership;
    this.creditCardInfo = creditCardInfo;
  }

  public void addClient(Client newClient){
      ClientMethods cltData = new ClientMethods();
      cltData.addNewRecord(newClient);
  }

  public Client searchClientById(int id) {
    ClientMethods cltData = new ClientMethods();
    return cltData.findRecordById(id);
  }

  public Client searchClientByDocNumber(String docNumber) {
    ClientMethods cltData = new ClientMethods();
    return cltData.findRecordByDocNumber(docNumber);
  }

  public Client searchClientByName(String name){
    ClientMethods cltData = new ClientMethods();
    return cltData.findRecordByName(name);
  }

  public void updateClientById(int id, Client clt) {
    ClientMethods cltData = new ClientMethods();
    cltData.updateRecordById(id, clt);
  }

  public void deleteClientById(int id) {
    ClientMethods cltData = new ClientMethods();
    cltData.deleteRecordById(id);
  }

  @Override
  public String toString() {
    return "Client "
        + "id "
        + id
        + " - "
        + super.toString()
        + " | Membership: "
        + membership
        + " | CreditCardInfo: "
        + creditCardInfo;
  }
}
