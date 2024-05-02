package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class contestProfileController {
    @FXML
    private Label name;

    @FXML
    private ImageView userImageView;


    private String userMail;

    public void setInfo(String name, String image, String mail){
        this.name.setText(name);
        userImageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(image))));
        this.userMail = mail;

    }
    @FXML
    void goProfile(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("friendProfile.fxml"));
        Parent root = loader.load();
        friendProfileController controller = loader.getController();
        controller.setFriendEmail(userMail);
        controller.setNc(userSession.getNc());
        controller.setUserInfo(userSession.getUserInfo());
        controller.initialize(null, null);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
