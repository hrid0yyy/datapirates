package org.example.datapirates;


import org.example.datapirates.ServerBackend.CreateConnection;
import org.example.datapirates.ServerBackend.Information;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        HashMap<String, Information> clientList = new HashMap<String, Information>();

        while (true)
        {
            Socket socket = serverSocket.accept();
            NetworkConnection nc = new NetworkConnection(socket);
            new Thread(new CreateConnection(clientList, nc)).start();

        }
    }
}


