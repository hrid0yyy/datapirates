package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class ContestHome implements Initializable {
    private NetworkConnection nc;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }
    @FXML
    private DatePicker date;
    private String contestDate;

    @FXML
    private ChoiceBox<String> length;
    private Integer contestLength;
    private final String[] len = {"1","2","3","4"};

    @FXML
    private TextField maxContestant;

    @FXML
    private TextField maxRat;

    @FXML
    private TextField minRat;

    @FXML
    private TextField nameField;

    @FXML
    private VBox contestBox;

    @FXML
    private ChoiceBox<String> startTime;
    private Integer contestTime;
    private final String[] sTime = new String[]{
            "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16"
    };


    @FXML
    void createContest(ActionEvent event) throws SQLException {
        String contestName = nameField.getText();
        int contestants = Integer.parseInt(String.valueOf(maxContestant.getText()));
        int minRatting = Integer.parseInt(String.valueOf(minRat.getText()));
        int maxRatting = Integer.parseInt(String.valueOf(maxRat.getText()));

       try{
           dbOperation.addContest(contestName,contestDate,contestTime,contestants,maxRatting,minRatting,contestLength);
           System.out.println("Contest added successfully");
       }
       catch (Exception e){
           e.printStackTrace();
       }
        maxContestant.clear();
        minRat.clear();
        maxRat.clear();
        nameField.clear();
    }

    @FXML
    void loadProblems(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("problems.fxml"));
        root = loader.load();
        problemController problemHome = loader.getController();
        problemHome.setUserInfo(userInfo);
        problemHome.setNc(nc);
        problemHome.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void profileBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        root = loader.load();
        profileController profileHome = loader.getController();
        profileHome.setUserInfo(userInfo);
        profileHome.setNc(nc);
        profileHome.initialize(null, null);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void homeBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        dashboardcontroller home = loader.getController();
        home.setUserInfo(userInfo);
        home.setNc(nc);
        home.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void loadContest() throws SQLException {
        ResultSet resultSet;


        resultSet = dbOperation.upcomingContest();
        Label upcoming = new Label("Upcoming Contest");
        upcoming.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-font-size: 20px;" +
                "-fx-padding: 5px; -fx-background-radius: 6px");
        contestBox.getChildren().addAll(upcoming,new Label("\n\n"));
        while (resultSet.next()){
            HBox hBox = new HBox(10);
            Label contestName = new Label(resultSet.getString("name"));
            ImageView joinImageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/join.png"))));
            joinImageView.setFitWidth(25);
            joinImageView.setFitHeight(25);
            joinImageView.setCursor(Cursor.HAND);
            int contestID = resultSet.getInt("contestID"); // Store contestID locally


            joinImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("contestDetails.fxml"));
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    contestDetails home = loader.getController();
                    home.setUserInfo(userInfo);
                    home.setNc(nc);
                    home.setContestID(contestID);
                    home.initialize(null, null);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            });
            contestName.setStyle("-fx-text-fill: white; -fx-font-size: 16px");

            hBox.getChildren().addAll(contestName,joinImageView);
            contestBox.getChildren().add(hBox);
        }



        resultSet = dbOperation.ongoingContest();
        Label ongoing = new Label("Ongoing Contest!!");
        ongoing.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-font-size: 20px;"+
                "-fx-padding: 5px; -fx-background-radius: 6px");
        contestBox.getChildren().addAll(ongoing,new Label("\n\n"));
        while (resultSet.next()) {
            HBox hBox = new HBox();
            Label contestName = new Label(resultSet.getString("name"));
            contestName.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
            ImageView enterImageview = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/enter.png"))));
            enterImageview.setFitWidth(25);
            enterImageview.setFitHeight(25);
            enterImageview.setCursor(Cursor.HAND);
            int contestID = resultSet.getInt("contestID"); // Store contestID locally
            enterImageview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        if(dbOperation.isRegistered(userInfo.getMail(), contestID)){
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("contestPage.fxml"));
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            contestPageController home = loader.getController();
                            home.setUserInfo(userInfo);
                            home.setNc(nc);
                            try {
                                home.setProblems(contestID);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            home.initialize(null, null);
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }
                        else {
                            System.out.println("You didnt register for this contest");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            hBox.getChildren().addAll(contestName, enterImageview);
            contestBox.getChildren().add(hBox);
        }




        resultSet = dbOperation.closedContest();
        Label previous = new Label("Previous Contest");
        previous.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-font-size: 20px;"+
                "-fx-padding: 5px; -fx-background-radius: 6px");
        contestBox.getChildren().addAll(previous,new Label("\n\n"));
        while (resultSet.next()){
            HBox hBox = new HBox();
            Label contestName = new Label(resultSet.getString("name"));
            contestName.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
            ImageView detailsImageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/details.png"))));
            detailsImageView.setFitWidth(25);
            detailsImageView.setFitHeight(25);
            detailsImageView.setCursor(Cursor.HAND);
            int contestID = resultSet.getInt("contestID"); // Store contestID locally
            detailsImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // load contest which details which is already closed
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("prevContest.fxml"));
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    prevContestController home = loader.getController();
                    home.setContestID(contestID);
                    home.initialize(null, null);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            });
            hBox.getChildren().addAll(contestName,detailsImageView);
            contestBox.getChildren().add(hBox);
        }

    }
   public void getLen(ActionEvent event){
        contestLength =  Integer.valueOf(String.valueOf(length.getValue()));
   }
   private void getTime(ActionEvent event){
        contestTime =     Integer.valueOf(String.valueOf(startTime.getValue()));
   }
    @FXML
    void getDate(ActionEvent event) {
         LocalDate localDate = date.getValue();
         contestDate = localDate.toString();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadContest();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        length.getItems().addAll(len);
      startTime.getItems().addAll(sTime);
      length.setOnAction(this::getLen);
      startTime.setOnAction(this::getTime);
    }
}
