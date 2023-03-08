package org.example.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatImpl extends UnicastRemoteObject implements ChatInt {
    String name;
    ChatInt client = null;


    public ChatImpl(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void send(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public void setClient(ChatInt client) throws RemoteException {
        this.client = client;
    }

    @Override
    public ChatInt getClient() throws RemoteException {
        return client;
    }
}