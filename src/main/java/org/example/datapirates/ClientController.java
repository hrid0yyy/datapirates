package org.example.datapirates;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.example.datapirates.ServerBackend.Data;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ClientController implements Runnable {

    private NetworkConnection nc;

   private Data data = new Data();

    public NetworkConnection getNc() {
        return nc;
    }

    public void establishConnection(String username){
       try {
           nc = new NetworkConnection("127.0.0.1",8080);

           nc.write(username);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }
   // mehrin@gmail.com$hridoy@gmail.com$send$ohayoo
     private String username;
     private Thread t;
     ClientController(String username){
       this.username = username;
       t = new Thread(this);
       t.start();
     }

    @Override
    public void run() {
        establishConnection(username);
    }
}

