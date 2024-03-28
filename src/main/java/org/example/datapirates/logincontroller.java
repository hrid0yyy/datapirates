package org.example.datapirates;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.datapirates.dataBaseConnection.dbHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class logincontroller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;


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
    @FXML
    void loginbtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
              String user_email = email.getText();
              String password  = pass.getText();
            ResultSet resultSet =  dbOperation.loginquery(user_email,password);
           if(!resultSet.next())
           {
               System.out.println("wrong credentials");
           }
           else {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
               root = loader.load();
               dashboardcontroller home =loader.getController();
               home.userinfo(user_email,password);

               stage = (Stage)((Node)event.getSource()).getScene().getWindow();
               scene = new Scene(root);
               stage.setScene(scene);
               stage.show();
           }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         showpassword.setVisible(false);






    }
}
