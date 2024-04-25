package org.example.datapirates;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.Data;
import org.example.datapirates.ServerBackend.NetworkConnection;
import org.example.datapirates.ServerBackend.Reader;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class friendListController implements Initializable {
    @FXML
    private ImageView homebtn;
    private UserInfo userInfo;
    @FXML
    private VBox onlineList;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private Data data = new Data();
    private NetworkConnection nc;
    private ResultSet resultSet;
    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void activeList() throws SQLException {
//        onlineList.getChildren().clear();
        String[] friends = dbOperation.friends(userInfo.getMail());
//        String query;
//        String serverMessage;
//        query = userInfo.getMail() + "$" + userInfo.getMail() + "$" + "list";
//        data.message = query;
//        try {
//            nc.write(data.clone());
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }


//       serverMessage = (String) nc.read();
//       String finalServerMessage = serverMessage;
        for (String friend : friends) {
            if (friend != null)
            {
//              if(finalServerMessage.contains(friend)){
                Platform.runLater(() -> {
                    try {
                        resultSet = dbOperation.detailsQuery(friend);
                        String friendName = resultSet.getString("name");
                        String friendPic = resultSet.getString("pic");
                        Label friendNameLabel = new Label("  "+friendName);
                        friendNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

                        friendNameLabel.setCursor(Cursor.HAND); // Change cursor to hand
                        friendNameLabel.setOnMouseClicked(e -> {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("chatbox.fxml"));
                            try {
                                root = loader.load();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            chatboxController chatboxController = loader.getController();
                            chatboxController.setReceiver(friend);
                            chatboxController.setNc(nc);
                            chatboxController.setUserInfo(userInfo);
                            chatboxController.initialize(null, null);
                            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);

                            stage.show();


                        });
                        Image userImage = new Image(getClass().getResourceAsStream(friendPic));
                        ImageView userImageView = new ImageView(userImage);
                        userImageView.setFitWidth(40);
                        userImageView.setFitHeight(40);
                        HBox id = new HBox(5);
                        id.getChildren().addAll(userImageView,friendNameLabel);
                        onlineList.getChildren().add(id);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

               });
       //    }
            }

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if( nc != null) {
            try {
                activeList();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }




        homebtn.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dashboardcontroller home = loader.getController();
            home.setUserInfo(userInfo);
            home.setNc(nc);
            home.initialize(null, null);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
    }
}
