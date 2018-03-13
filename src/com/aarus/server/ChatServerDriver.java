package com.aarus.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ChatServerDriver {

    public static void main(String[] args) {
        try {
            Naming.rebind("RMIChatServer", new ChatServer());
        }
        catch (RemoteException remoteException)
        {
            System.out.println(remoteException);
        }
        catch (MalformedURLException malformed)
        {
            System.out.println("malformed URL"+ malformed);
        }
    }
}
