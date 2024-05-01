package org.example.datapirates;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;
import org.example.datapirates.compiler.*;
import org.example.datapirates.dataBaseConnection.dbHandler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static org.example.datapirates.dbOperation.connection;

public class compilerController implements Initializable {

    @FXML
    private TextArea codebox;
    @FXML
    private VBox sideBox;


    @FXML
    private Label result;

    @FXML
    private ChoiceBox<String> langChoice;
    private final String[] language = {"python3","c","java","cpp17"};

    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Problems getProblems() {
        return problems;
    }

    private NetworkConnection nc;

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }

        private Problems problems;

    private Stage stage;
    private Scene scene;
    private Parent root;
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

    public void setProblems(Problems problems) throws SQLException, ClassNotFoundException {
        this.problems = problems;
        Label label1 = new Label("\n"+"\n"+"\n"+" Problem ID : " + problems.getProblemID() + "\n");
        Label label2 = new Label( " Problem Name : " + problems.getProblemName() + "\n" );
        Label label3 = new Label(" Description : " + problems.getProblemDescription());
        label1.setStyle("-fx-text-fill: white");
        label2.setStyle("-fx-text-fill: white");
        label3.setStyle("-fx-text-fill: white");
        sideBox.getChildren().addAll(new TextFlow(label1),new TextFlow(label2),new TextFlow(label3));

        codebox.setText(problems.getCodeFormat());
    }
    private String Lang;

    public String getLang() {
        return Lang;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        langChoice.getItems().addAll(language);
        langChoice.setOnAction(this::setLang);
    }

    private void setLang(ActionEvent event) {
        this.Lang = langChoice.getValue();
    }
    @FXML
    void homeBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        dashboardcontroller home = loader.getController();
        home.setNc(nc);
        home.setUserInfo(userInfo);
        home.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void compile(ActionEvent event) throws IOException, InterruptedException, URISyntaxException, SQLException {

        output res =  CompileCode.compile(codebox.getText()+"\n"+problems.getDriverCode(),getLang());
        System.out.println(res.getOutput());
        StringBuilder outputBuilder = new StringBuilder();
        if(res.getOutput().equals(problems.getOutput()))
        {
            outputBuilder.append("Accepted"+"\n")
                    .append("Cpu Time : ").append(res.getCpuTime()).append("\n")
                    .append("Memory : ").append(res.getMemory());
            try {
                // Establish database connection
                Connection connection = dbHandler.getDbConnection();

                String insertSql = "DELETE FROM solved WHERE problemID = ? and userMail = ?";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, problems.getProblemID()); // Assuming problems.getProblemID() returns the problem ID
                insertStatement.setString(2, userInfo.getMail()); // Assuming userInfo is properly set

                // Execute the insert statement
                insertStatement.executeUpdate();


                // Prepare SQL statement to insert into the solved table
                insertSql = "INSERT INTO solved (problemID, userMail,code) VALUES (?, ?, ?)";
                insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, problems.getProblemID()); // Assuming problems.getProblemID() returns the problem ID
                insertStatement.setString(2, userInfo.getMail()); // Assuming userInfo is properly set
                insertStatement.setString(3, codebox.getText());
                // Execute the insert statement
                insertStatement.executeUpdate();

                String postContent = "Solved "+problems.getProblemName()+" by "+getLang()+"\n"+"Time Taken : "+res.getCpuTime()+"\n"+
                        "Space Taken : "+res.getMemory();
                LocalDateTime currentDateTime = LocalDateTime.now();
                String sql = "INSERT INTO posts (mail, content,time) VALUES (?, ?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, userInfo.getMail());
                statement.setString(2, postContent);
                statement.setTimestamp(3, Timestamp.valueOf(currentDateTime));

                statement.executeUpdate();


                // Close resources
                insertStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {

            outputBuilder.append("Not Accepted"+"\n")
                    .append("Cpu Time : ").append(res.getCpuTime()).append("\n")
                    .append("Memory : ").append(res.getMemory());
        }



        // Prepare SQL statement to insert into the solved table
        String insertSql = "INSERT INTO attempted (problemID, userMail,code) VALUES (?, ?,?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
        insertStatement.setInt(1, problems.getProblemID()); // Assuming problems.getProblemID() returns the problem ID
        insertStatement.setString(2, userInfo.getMail()); // Assuming userInfo is properly set
        insertStatement.setString(3, codebox.getText());
        // Execute the insert statement
        insertStatement.executeUpdate();
        result.setStyle("-fx-text-fill: white;");
        result.setText(outputBuilder.toString());
    }

}








