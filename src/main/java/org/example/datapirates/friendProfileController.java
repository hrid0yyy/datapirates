package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    private VBox posts;

    @FXML
    private VBox solvedList;

    @FXML
    private Label fName;
    private String fmail;

    @FXML
    private ImageView fPic;

    @FXML
    private Label fPosition;

    @FXML
    private Label fSolved;


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
    public void loadPosts() throws SQLException{
        resultSet = dbOperation.posts(fmail);
        VBox postContainer = new VBox();

        while (resultSet.next()){
            String content = resultSet.getString("content");
            Timestamp timestamp = resultSet.getTimestamp("time");




            SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a, d MMMM, yyyy");
            String formattedTime = dateFormat.format(timestamp);

            Label contentLabel = new Label(content);
            Label timeLabel = new Label(formattedTime);






            contentLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
            timeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");


            postContainer.getChildren().addAll(timeLabel, contentLabel,new Label("\n"));
        }
        posts.getChildren().add(postContainer);
    }
    public void solvedProblem() throws SQLException {
        resultSet = dbOperation.solvedProbelms(fmail);
        VBox box = new VBox(5);

        while (resultSet.next()){
            Label L = new Label(resultSet.getString("problemName"));
            L.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");
            box.getChildren().add(L);
        }
        solvedList.getChildren().add(box);
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
                loadPosts();
                solvedProblem();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
