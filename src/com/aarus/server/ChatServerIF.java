package com.aarus.server;

import com.aarus.client.ChatClientIF;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerIF extends Remote {
    void registerChatClient(ChatClientIF chatClientIF) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
}
