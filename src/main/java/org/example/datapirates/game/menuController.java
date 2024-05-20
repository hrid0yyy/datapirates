package org.example.datapirates.game;


import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.datapirates.dashboardcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.datapirates.userSession.nc;
import static org.example.datapirates.userSession.userInfo;

public class menuController implements Initializable {
    @FXML
    private ImageView account_image;

    @FXML
    private Label account_label;

    @FXML
    private ImageView exit_image;

    @FXML
    private Label exit_label;

    @FXML
    private ImageView multiplayer_image;

    @FXML
    private Label multiplayer_label ;

    @FXML
    private ImageView single_player_image;

    @FXML
    private Label single_player_label;
    @FXML
    private ImageView c;

    @FXML
    private ImageView cplus;
    @FXML
    private ImageView python;

    @FXML
    private ImageView java;
    @FXML
    private AnchorPane root;


    private Stage stage;
    private Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transition.fadeInTransition(root);
        single_player_image.setStyle("-fx-opacity: 0.0;");
        //multiplayer_image.setStyle("-fx-opacity: 0.0;");
        //account_image.setStyle("-fx-opacity: 0.0;");
        exit_image.setStyle("-fx-opacity: 0.0;");

        FadeTransition fade = new FadeTransition(Duration.millis(1000),python);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        FadeTransition fade2 = new FadeTransition(Duration.millis(1000),cplus);
        fade2.setFromValue(1.0);
        fade2.setToValue(0.0);
        fade2.setCycleCount(TranslateTransition.INDEFINITE);
        fade2.setAutoReverse(true);
        fade2.play();

        FadeTransition fade3 = new FadeTransition(Duration.millis(1000),java);
        fade3.setFromValue(1.0);
        fade3.setToValue(0.0);
        fade3.setCycleCount(TranslateTransition.INDEFINITE);
        fade3.setAutoReverse(true);
        fade3.play();

        FadeTransition fade4 = new FadeTransition(Duration.millis(1000),c);
        fade4.setFromValue(1.0);
        fade4.setToValue(0.0);
        fade4.setCycleCount(TranslateTransition.INDEFINITE);
        fade4.setAutoReverse(true);
        fade4.play();




        single_player_label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                single_player_label.setStyle("-fx-font-size: 15px;");
                single_player_image.setStyle("-fx-opacity: 1.0;");

            }
        });
        single_player_label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                single_player_label.setStyle("-fx-font-weight: normal;");
                single_player_image.setStyle("-fx-opacity: 0.0;");
            }
        });
//        multiplayer_label.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                multiplayer_label.setStyle("-fx-font-size: 15px;");
//                multiplayer_image.setStyle("-fx-opacity: 1.0;");
//
//            }
//        });
//        multiplayer_label.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                multiplayer_label.setStyle("-fx-font-weight: normal;");
//                multiplayer_image.setStyle("-fx-opacity: 0.0;");
//
//            }
//        });
//       account_label.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                account_label.setStyle("-fx-font-size: 15px;");
//                account_image.setStyle("-fx-opacity: 1.0;");
//
//            }
//        });
//        account_label.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                account_label.setStyle("-fx-font-weight: normal;");
//                account_image.setStyle("-fx-opacity: 0.0;");
//
//            }
//        });
        exit_label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                exit_label.setStyle("-fx-font-size: 15px;");
                exit_image.setStyle("-fx-opacity: 1.0;");

            }
        });
        exit_label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                exit_label.setStyle("-fx-font-weight: normal;");
                exit_image.setStyle("-fx-opacity: 0.0;");

            }
        });

        exit_label.setOnMouseClicked(event -> {
            try {
                BackgroundMusicPlayer.getInstance().stopMusic();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/dashboard.fxml"));
                Parent root = loader.load();

                dashboardcontroller home = loader.getController();
                home.setUserInfo(userInfo);
                home.setNc(nc);
                home.initialize(null, null);

                Stage stage = (Stage) exit_label.getScene().getWindow();

                Scene scene = new Scene(root);

                stage.setScene(scene);

                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//        exit_label.setOnMouseClicked(event -> {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
//            try {
//                root = loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            dashboardcontroller home = loader.getController();
//            home.setUserInfo(userInfo);
//            home.setNc(nc);
//            home.initialize(null, null);
//            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//
//
////            try {
////                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/dashboard.fxml"));
////                Parent root = loader.load();
////
////                Stage stage = (Stage) single_player_label.getScene().getWindow();
////
////                Scene scene = new Scene(root);
////
////                stage.setScene(scene);
////
////                stage.show();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//        });


        single_player_label.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/intro.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) single_player_label.getScene().getWindow();

                Scene scene = new Scene(root);

                stage.setScene(scene);

                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
