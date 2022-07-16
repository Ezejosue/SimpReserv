package com.entity;

import com.model.simpreserv.Client;

import java.util.Map;

public interface IClientController {
    Map<Integer, Client> loadClientsList();
    void saveClientsList(Map<Integer, Client> clientsList);
    void addNewClient(Client newClient);
    Client findClientById(int clientId);
    Client findClientByDocNumber(String docNumber);
    Client findClientByName(String name);
    void updateClientById(int clientId, Client newClient);
    void deleteClientById(int clientId);
    void printClientsList();
}
