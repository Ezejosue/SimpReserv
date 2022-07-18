package com.controller;

import com.entity.IClientController;
import com.model.simpreserv.Client;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CtrlClient implements IClientController {

    private final static String FILEPATH = "src\\main\\resources\\clients.dat";

    @Override
    public TreeMap<Integer, Client> loadClientsList() {
        try (FileInputStream fis = new FileInputStream(FILEPATH)) {
            ReadObject ro = new ReadObject(FILEPATH);
            return (TreeMap<Integer, Client>) ro.loadInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveClientsList(Map<Integer, Client> clientsList) {
        WriteObject wo = new WriteObject(FILEPATH, clientsList);
        wo.writeToFile();
    }

    @Override
    public void addNewClient(Client newClient) {
        int lastId;
        TreeMap<Integer, Client> list = this.loadClientsList();
        if (list.size() != 0) {
            lastId = list.get(list.lastKey()).getId();
        } else {
            lastId = 0;
        }
        lastId++;
        newClient.setId(lastId);
        list.put(lastId, newClient);
        this.saveClientsList(list);
    }

    @Override
    public Client findClientById(int clientId) {
        Map<Integer, Client> list = this.loadClientsList();
        return list.get(clientId);
    }

    @Override
    public Client findClientByDocNumber(String docNumber) {
        Map<Integer, Client> list = this.loadClientsList();
        Client client = new Client();
        for (Map.Entry<Integer, Client> item : list.entrySet()) {
            if (item.getValue().getNumberOfDocument().equals(docNumber)) {
                client = item.getValue();
                break;
            }
        }
        return client;
    }

    @Override
    public Client findClientByName(String name) {
        Map<Integer, Client> list = this.loadClientsList();
        Client client = new Client();
        for (Map.Entry<Integer, Client> item : list.entrySet()) {
            if (item.getValue().getName().equals(name)) {
                client = item.getValue();
                break;
            }
        }
        return client;
    }

    @Override
    public void updateClientById(int clientId, Client newClient) {
        Map<Integer, Client> list = this.loadClientsList();
        list.replace(clientId, newClient);
        this.saveClientsList(list);
    }

    @Override
    public void deleteClientById(int clientId) {
        Map<Integer, Client> list = this.loadClientsList();
        list.remove(clientId);
        this.saveClientsList(list);
    }

    @Override
    public void printClientsList() {
        Map<Integer, Client> list = this.loadClientsList();
        for (Map.Entry<Integer, Client> item : list.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }

}
