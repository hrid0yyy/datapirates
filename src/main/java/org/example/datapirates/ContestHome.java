package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
    private ChoiceBox<String> startTime;
    private Integer contestTime;
    private final String[] sTime = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23"
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
           System.out.println("Failed to add the contest");
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
    private void loadContest()
    {

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
      loadContest();
      length.getItems().addAll(len);
      startTime.getItems().addAll(sTime);
      length.setOnAction(this::getLen);
      startTime.setOnAction(this::getTime);
    }
}
