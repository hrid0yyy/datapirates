package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class contestDetails implements Initializable {
    @FXML
    private Text contestLen;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Text contestants;
    private NetworkConnection nc;

    @FXML
    private Label popUp;
    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @FXML
    private Text date;

    @FXML
    private Text maxRat;

    @FXML
    private Text minRat;

    @FXML
    private Text name;
    private String contestID;

    public void setContestID(int contestID) {
        this.contestID = String.valueOf(contestID);
    }

    @FXML
    private Text startTime;

    @FXML
    void contestBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contestHome.fxml"));
        root = loader.load();

        ContestHome contestHome = loader.getController();
        contestHome.setNc(nc);
        contestHome.setUserInfo(userInfo);


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

    @FXML
    void joinContest(ActionEvent event) throws SQLException {
        if(dbOperation.checkContestants(userInfo.getMail(),Integer.parseInt(contestID))){
            popUp.setStyle("-fx-text-fill: red");
            popUp.setText("Already Registered");
        }
        else {
            dbOperation.joinContest(userInfo.getMail(), Integer.parseInt(contestID));
            popUp.setStyle("-fx-text-fill: green");
            popUp.setText("REGISTERED!!");

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         ResultSet resultSet;

         if(contestID != null){
             try {
                 int id = Integer.parseInt(contestID);
                 resultSet = dbOperation.contestDetails(id);
                 name.setText(resultSet.getString("name"));
                 Date Date = resultSet.getDate("day");
                 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                 date.setText(dateFormat.format(Date));
                 startTime.setText(String.valueOf(resultSet.getInt("start_time")));
                 contestants.setText(String.valueOf(resultSet.getInt("contestants")));
                 maxRat.setText(String.valueOf(resultSet.getInt("maxRat")));
                 minRat.setText(String.valueOf(resultSet.getInt("minRat")));
                 contestLen.setText(String.valueOf(resultSet.getInt("length")));

             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }

         }



    }
}
