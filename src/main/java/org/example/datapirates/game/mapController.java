package org.example.datapirates.game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class mapController implements Initializable {


    @FXML
    private Label lv1;

    @FXML
    private Label lv2;

    @FXML
    private Label lv3;

    @FXML
    private Label lv4;

    @FXML
    private Label lv5;

    @FXML
    private Label lv6;





    @FXML
    private ImageView ship1;

    @FXML
    private ImageView ship2;

    @FXML
    private ImageView ship3;

    @FXML
    private ImageView ship4;

    @FXML
    private ImageView ship5;

    @FXML
    private ImageView ship6;

    @FXML
    private AnchorPane root;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transition.fadeInTransition(root);

        ship1.setOnMouseClicked(e -> {
            BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/lvmusic.mp3");
            transition.handleShipClick(100,100, root, "/org/example/datapirates/game/level1Arrays.fxml");
        });


        transition.addHoverAnimation(ship1);
        transition.addHoverAnimation(ship2);
        transition.addHoverAnimation(ship3);
        transition.addHoverAnimation(ship4);
        transition.addHoverAnimation(ship5);
        transition.addHoverAnimation(ship6);



        transition.fadeInFadeOut(lv1);
        transition.fadeInFadeOut(lv2);
        transition.fadeInFadeOut(lv3);
        transition.fadeInFadeOut(lv4);
        transition.fadeInFadeOut(lv5);
        transition.fadeInFadeOut(lv6);

    }

    @FXML
    void back(ActionEvent event) {
        transition.backButtonClick(event, "/org/example/datapirates/game/Menu.fxml");
    }


}
