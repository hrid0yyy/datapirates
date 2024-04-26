package org.example.datapirates;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label warn;

    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    @FXML
    private Text showpassword;
    @FXML
    private RadioButton showbtn;
    @FXML
    void passwordkeyevent(KeyEvent event) {
        showpassword.textProperty().bind(Bindings.concat(pass.getText()));

    }
    public static boolean validMail(String userEmail){

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(userEmail);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isLengthEight(String str) {
        return str.length() >= 4;
    }
    @FXML
    void loginbtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String user_email = email.getText();
        String password = pass.getText();

        if (validMail(user_email) && isLengthEight(password) ) {
            if(dbOperation.isOldAccount(user_email)){
                warn.setText("Account Already exists");
                return;
            }
            String[] parts = user_email.split("@");
           dbOperation.addAccount(user_email,password);
            dbOperation.addDefaultPic(user_email,parts[0]);
            UserInfo userInfo = new UserInfo(user_email);


            ClientController clientController = new ClientController(userInfo.getMail());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            root = loader.load();
            dashboardcontroller home = loader.getController();
            home.setUserInfo(userInfo);
            home.setNc(clientController.getNc());
            home.initialize(null, null);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        } else {
            warn.setText("Enter a valid mail and the minimum size of password is 4");
            System.out.println("Enter a valid mail and the minimum size of the password should be 4");
        }
    }
    @FXML
    void loginpage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = loader.load();
  ;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleRadioButtonAction() {
        if (showbtn.isSelected()) {
            // Show the actual password when the radio button is selected
            showpassword.setVisible(true);
            showpassword.textProperty().bind(Bindings.concat(pass.getText()));
        } else {
            // Mask the password when the radio button is deselected
            showpassword.setVisible(false);

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showpassword.setVisible(false);
    }
}
