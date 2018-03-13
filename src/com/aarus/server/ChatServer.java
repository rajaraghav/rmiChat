package com.aarus.server;

import com.aarus.client.ChatClientIF;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
    private static final long serialVersionUID = 1L;
    private ArrayList<ChatClientIF> chatClients;

    protected ChatServer() throws RemoteException {
        chatClients = new ArrayList<ChatClientIF>();
    }

    @Override
    public synchronized void registerChatClient(ChatClientIF chatClientIF) throws RemoteException {
        this.chatClients.add(chatClientIF);
    }

    @Override
    public synchronized void broadcastMessage(String message) throws RemoteException {
        for(ChatClientIF client:chatClients)
        {
            client.retrieveMessage(message);
        }
    }
}
