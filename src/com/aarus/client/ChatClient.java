package com.aarus.client;

import com.aarus.server.ChatServerIF;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable{

    private ChatServerIF chatServer;
    String name;
    protected ChatClient(String name, ChatServerIF chatServer) throws RemoteException {
        super();
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerChatClient(this);
    }

    @Override
    public void retrieveMessage(String message) throws RemoteException {
        System.out.println(this.name+":"+message);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message;
        while(true)
        {
         message = scanner.nextLine();
         try{
             chatServer.broadcastMessage(message);
         }
         catch (RemoteException e)
         {
             e.printStackTrace();
         }
        }
    }
}
