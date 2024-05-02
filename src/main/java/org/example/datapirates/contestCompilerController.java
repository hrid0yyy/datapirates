package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;
import org.example.datapirates.compiler.CompileCode;
import org.example.datapirates.compiler.output;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class contestCompilerController implements Initializable {
    @FXML
    private VBox codeBox;

    @FXML
    private TextArea codeTextArea;

    @FXML
    private ChoiceBox<String> langChoiceBox;
    private final String[] language = {"python3","c","java","cpp17"};
    private ResultSet problemInfo;

    private int contestID;
    private NetworkConnection nc;
    private UserInfo userInfo;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Label result;

    public void setProblemInfo(int problemID) throws SQLException {
        problemInfo = dbOperation.problemInfo(problemID);
        StringBuilder info = new StringBuilder();
        info.append("Problem Name : "+problemInfo.getString("problemName")+"\n\n");
        info.append("Description : "+problemInfo.getString("description")+"\n\n");
        Label label = new Label(info.toString());
        label.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
        codeTextArea.setText(problemInfo.getString("codeFormat"));
        codeBox.getChildren().add(label);
    }

    public void setContestID(int contestID) {
        this.contestID = contestID;
    }

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @FXML
    void goBack(ActionEvent event) {
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

    @FXML
    void submit(ActionEvent event) throws IOException, URISyntaxException, InterruptedException, SQLException {
        output res = CompileCode.compile(codeTextArea.getText()+"\n"+problemInfo.getString("driverCode"),getLang());
        System.out.println(codeTextArea.getText());
        System.out.println(getLang());

        if(dbOperation.isClosed(contestID)){
            result.setStyle("-fx-text-fill: red");
            result.setText("CONTEST CLOSED");
        }
        else {
            if(res.getOutput().equals(problemInfo.getString("output"))){
                result.setStyle("-fx-text-fill: green");
                result.setText("ACCEPTED");
                dbOperation.contestSubmission(contestID,problemInfo.getInt("problemID"), userInfo.getMail(),codeTextArea.getText(),1 );
            }
            else {
                result.setStyle("-fx-text-fill: red");
                result.setText("NOT ACCEPTED");
                dbOperation.contestSubmission(contestID,problemInfo.getInt("problemID"), userInfo.getMail(),codeTextArea.getText(),0 );
            }
        }



    }
    private String Lang;
    private void setLang(ActionEvent event) {
        this.Lang = langChoiceBox.getValue();
    }
    public String getLang() {
        return Lang;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        langChoiceBox.getItems().addAll(language);
        langChoiceBox.setOnAction(this::setLang);
    }
}
