package org.example.datapirates.game;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class intro2Controller implements Initializable {
    @FXML
    private ImageView dialouge;

    @FXML
    private ImageView luffy;
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Text dialougetext = new Text();

    int count = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialougetext.setFocusTraversable(true);
        transition.showMessage(luffy,300,300,dialouge,dialougetext,"In this immersive journey, you will uncover the secrets of data structures and become a legendary coder");

        dialougetext.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.X)
                {
                    count++;
                    if(count == 1)
                    {
                        transition.showMessage(luffy,300,300,dialouge,dialougetext,"Are you ready to set sail and unravel the secrets of the Data Seas? Your adventure begins now");
                    }
                    if(count == 2)
                    {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/org/example/datapirates/game/map.fxml"));
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
            }
        });

    }
}
