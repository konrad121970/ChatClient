package org.example;

import org.example.model.ChatImpl;
import org.example.model.ChatInt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {

        System.setProperty("java.security.policy", "security.policy");
        System.setSecurityManager(new SecurityManager());

        try {

            Scanner s = new Scanner(System.in);
            System.out.println("Enter Your name and press Enter:");
            String name = s.nextLine().trim();
            ChatInt client = new ChatImpl(name);

            ChatInt server = (ChatInt)(Naming.lookup("//82.139.136.125/ABC"));
            String msg = "[" + client.getName() + "]" + " connected!";
            server.send(msg);
            System.out.println("[System] Chat Remote Object is ready:");
            server.setClient(client);

            while(true){
                String message = s.nextLine().trim();
                message = "[" + client.getName() + "]: " + message;
                server.send(message);
            }

        } catch(RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
    }
