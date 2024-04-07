package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class friendProfileController implements Initializable {


    private Parent root;
    private Stage stage;
    private Scene scene;
    private UserInfo userInfo;
    @FXML
    private Label fAboutMe;

    @FXML
    private Label fInstitue;

    @FXML
    private Label fName;
    private String fmail;

    @FXML
    private ImageView fPic;

    @FXML
    private Label fPosition;

    @FXML
    private Label fSolved;

    @FXML
    private VBox solvedList;
    private ResultSet resultSet;

    @FXML
    void homebtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        dashboardcontroller home = loader.getController();
        home.setUserInfo(userInfo);
        home.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loadProblems(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("problems.fxml"));
        root = loader.load();
        problemController problemHome = loader.getController();
        problemHome.setUserInfo(userInfo);

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
        profileHome.initialize(null, null);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setFriendEmail(String friendEmail) throws SQLException {
        this.fmail = friendEmail;
        this.resultSet = dbOperation.detailsQuery(friendEmail);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (fmail != null){
            try {
                fName.setText(resultSet.getString("name"));
                fInstitue.setText("Institute : "+resultSet.getString("institution"));
                fPosition.setText("Position : "+resultSet.getString("position"));
                fAboutMe.setText("Bio : "+resultSet.getString("about_me"));
                Image profilePic = new Image(getClass().getResourceAsStream(resultSet.getString("pic")));
                fPic.setImage(profilePic);
                double diameter = Math.min(fPic.getFitWidth(), fPic.getFitHeight()); // Determine diameter based on smaller dimension
                Circle clip = new Circle(diameter / 2, diameter / 2, diameter / 2);
                fPic.setClip(clip);

                fPic.setFitWidth(133); // Set your desired width
                fPic.setFitHeight(171); // Set your desired height
                ResultSet rs = dbOperation.solved(fmail);
                fSolved.setText("Solved : "+rs.getString("total"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
