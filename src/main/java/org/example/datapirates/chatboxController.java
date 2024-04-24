package org.example.datapirates;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.example.datapirates.ServerBackend.Data;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.net.URL;
import java.util.ResourceBundle;

public class chatboxController implements Initializable {
    @FXML
    private VBox chatbox;

    @FXML
    private TextField msgBox;
     private Data data = new Data();
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private NetworkConnection nc;

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }
    private String receiver;

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @FXML
    void send(ActionEvent event) {
        String message = msgBox.getText();
        if(message.isEmpty()){
            System.out.println("dukse");
            return;
        }
            String req = userInfo.getMail() + "$" + receiver + "$send$" + message;
            data.message = req;
            chatbox.getChildren().add(new Label(message));
            try {
                nc.write(data.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            msgBox.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread serverListener = new Thread(() -> {
            String serverMessage;
            while (true) {
                serverMessage = (String) nc.read();
                String finalServerMessage = serverMessage;
               if(serverMessage != null)
               {
                   Platform.runLater(() -> {
                       chatbox.getChildren().add(new Label(receiver+" : "+finalServerMessage));
                   });
               }

            }
        });

        serverListener.start();
    }
}
