package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class contestPageController implements Initializable {
    private ResultSet problems;

    private ResultSet contestInfo;
    private UserInfo userInfo;
    private NetworkConnection nc;

    public void setProblems(int contestID) throws SQLException {
        contestInfo = dbOperation.contestInfo(contestID);
        problems = dbOperation.loadContestProblems(contestID);

    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }

    @FXML
    private Label contestName;

    @FXML
    private VBox problemBox;
   private Parent root;
   private Stage stage;
   private Scene scene;
    @FXML
    void goBack(ActionEvent event) throws IOException {
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
   private void loadProblems() throws SQLException {
        contestName.setText(contestInfo.getString("name"));
        int  submitted = 0; // number of people completed that problem
        while (problems.next()){
            HBox hBox = new HBox(10);
            Label name = new Label(problems.getString("problemName"));
            name.setStyle("-fx-text-fill: #DF3079; -fx-font-size: 18 px;");
            hBox.setAlignment(Pos.CENTER);

            Button attempt = new Button("Attempt");
            int problemID = problems.getInt("problemID");
            attempt.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("contestCompiler.fxml"));
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    contestCompilerController compilerController = loader.getController();
                    try {
                        compilerController.setContestID(contestInfo.getInt("contestID"));
                        compilerController.setNc(nc);
                        compilerController.setUserInfo(userInfo);
                        compilerController.setProblemInfo(problemID);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }


                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            });
            attempt.setStyle("-fx-background-color:  #DF3079; -fx-text-fill: white; -fx-font-size: 12px");
            Label submits = new Label(String.valueOf(submitted));
            submits.setStyle("-fx-text-fill: #DF3079; -fx-font-size: 18px");

            hBox.getChildren().addAll(name,attempt,submits);
            problemBox.getChildren().addAll(hBox);
        }
   }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

if(contestInfo != null) {
    try {
        loadProblems();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    }
}
