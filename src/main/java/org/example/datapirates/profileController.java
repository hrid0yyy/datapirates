package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;
import org.example.datapirates.dataBaseConnection.dbHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;



public class profileController implements Initializable {

    @FXML
    private VBox solvedVbox;
    private  UserInfo userInfo;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ResultSet resultSet;
    @FXML
    private Label name;

    @FXML
    private Label picName;

    @FXML
    private ImageView pic;
    @FXML
    private TextArea updateAboutyou;

    @FXML
    private TextField updateInstitution;
    @FXML
    private VBox posts;
    @FXML
    private TextField updateName;
    private String profilePic;

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    @FXML
    private TextField updatePosition;
    private File updateProfile;

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
    public void loadSolvedProbles() throws SQLException {
        resultSet = dbOperation.solvedProbelms(userInfo.getMail());
        VBox box = new VBox(5);
        while (resultSet.next()){
            Label L = new Label(resultSet.getString("problemName"));
            L.setStyle("-fx-font-size: 14px;");
            box.getChildren().add(L);
        }
        solvedVbox.getChildren().add(box);
    }
    public void loadPosts() throws SQLException {
        resultSet = dbOperation.posts(userInfo.getMail());
        VBox postContainer = new VBox();


        while (resultSet.next()) {
            String content = resultSet.getString("content");
            Timestamp timestamp = resultSet.getTimestamp("time");




            SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a, d MMMM, yyyy");
            String formattedTime = dateFormat.format(timestamp);

            Label contentLabel = new Label(content);
            Label timeLabel = new Label(formattedTime);






            contentLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
            timeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");


            postContainer.getChildren().addAll(timeLabel, contentLabel);

        }
        posts.getChildren().add(postContainer);


    }
    @FXML
    void selectPic(ActionEvent event) {
        FileChooser fc = new FileChooser();
        updateProfile = fc.showOpenDialog(null);

        if(updateProfile != null)
        {
            setProfilePic("images/"+updateProfile.getName());
            picName.setText("images/"+updateProfile.getName());
        }
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
    private NetworkConnection nc;

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }
    @FXML
    void loadProblems(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("problems.fxml"));
        root = loader.load();
        problemController problemHome = loader.getController();
        problemHome.setUserInfo(getUserInfo());
        problemHome.setNc(nc);
        problemHome.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    void refreshProfile() throws SQLException {

            setResultSet(dbOperation.detailsQuery(userInfo.getMail()));

            if (resultSet.getString("pic") != null ) {
                Image profilePic = new Image(getClass().getResourceAsStream(resultSet.getString("pic")));
                pic.setImage(profilePic);
                setProfilePic(resultSet.getString("pic"));
            }
            if(resultSet.getString("name") != null) {
                name.setText(resultSet.getString("name"));
            }
            if(resultSet.getString("about_me") != null) {
                updateAboutyou.setText(resultSet.getString("about_me"));
            }
            if(resultSet.getString("institution") != null) {
                updateInstitution.setText(resultSet.getString("institution"));
            }
            if(resultSet.getString("position") != null) {
                updatePosition.setText(resultSet.getString("position"));
            }
            if(resultSet.getString("name") != null) {
                updateName.setText(resultSet.getString("name"));
            }

    }

    @FXML
    void updateProfile(ActionEvent event) throws SQLException {
        dbOperation.updateProfile(updateName.getText(),updateAboutyou.getText(),updateInstitution.getText(),
                updatePosition.getText(),getProfilePic(),userInfo.getMail());
        refreshProfile();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (userInfo != null) {
            try {
              refreshProfile();
              loadSolvedProbles();
              loadPosts();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
