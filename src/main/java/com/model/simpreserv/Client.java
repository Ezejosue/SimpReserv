package com.model.simpreserv;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

import com.controller.CtrlClient;
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

  public void saveClientsList(Map<Integer, Client> clientsList){
    CtrlClient cltData = new CtrlClient();
    cltData.saveClientsList(clientsList);
  }
  public void addClient(Client newClient){
      CtrlClient cltData = new CtrlClient();
      cltData.addNewClient(newClient);
  }

  public Client searchClientById(int id) {
    CtrlClient cltData = new CtrlClient();
    Client client = cltData.findClientById(id);
    return cltData.findClientById(id);
  }

  public Client searchClientByDocNumber(String docNumber) {
    CtrlClient cltData = new CtrlClient();
    return cltData.findClientByDocNumber(docNumber);
  }

  public Client searchClientByName(String name){
    CtrlClient cltData = new CtrlClient();
    return cltData.findClientByName(name);
  }

  public void updateClientById(int id, Client clt) {
    CtrlClient cltData = new CtrlClient();
    cltData.updateClientById(id, clt);
  }

  public void deleteClientById(int id) {
    CtrlClient cltData = new CtrlClient();
    cltData.deleteClientById(id);
  }

  public void printClients() {
    CtrlClient cltData = new CtrlClient();
    cltData.printClientsList();
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
