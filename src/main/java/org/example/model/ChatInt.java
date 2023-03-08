package org.example.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInt extends Remote {
    public String getName() throws RemoteException;
    public void send(String s) throws RemoteException;
    public void setClient(ChatInt client) throws RemoteException;
    public ChatInt getClient() throws RemoteException;
}
