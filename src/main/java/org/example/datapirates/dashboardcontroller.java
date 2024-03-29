package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardcontroller  {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    @FXML
    private Label welcomeLabel;

    public void userinfo(String mail)
    {
        UserInfo user_info = new UserInfo(mail);
        setUserInfo(user_info);
        welcomeLabel.setText("Welcome "+user_info.getMail());

    }
    @FXML
    void loadProblems(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("problems.fxml"));
        root = loader.load();
        problemController problemHome = loader.getController();
        problemHome.setUserInfo(getUserInfo());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}


