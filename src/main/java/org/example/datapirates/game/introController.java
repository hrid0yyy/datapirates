package org.example.datapirates.game;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class introController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label toplabel;
    @FXML
    private Label Xtext = new Label();
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transition.fadeInTransition(rootPane);

        transition.backNforward(toplabel,600,1200);
        transition.fadeInFadeOut(Xtext);
        Xtext.setFocusTraversable(true);
        Xtext.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.X) {
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/org/example/datapirates/game/intro2.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = new Stage();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    rootPane.getScene().getWindow().hide();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                }
            }
        });
    }
}
