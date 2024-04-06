package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class profileController implements Initializable {


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
        problemHome.setUserInfo(getUserInfo());

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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
