package com.aarus.client;

import com.aarus.server.ChatServer;
import com.aarus.server.ChatServerIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ChatDriver {
    public static void main(String[] args) {
        String url = "rmi://localhost/RMIChatServer";
        try {
            ChatServerIF chatServer =  (ChatServerIF) Naming.lookup(url);
            new Thread(new ChatClient(args[0],chatServer)).start();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
