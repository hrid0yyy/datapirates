package org.example.datapirates;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class dashboardcontroller  {

    @FXML
    private Label welcomeLabel;

    public void userinfo(String mail, String pass)
    {
        welcomeLabel.setText("Welcome "+mail);

    }

}
