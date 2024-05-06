package org.example.datapirates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class prevContestController implements Initializable {

    @FXML
    private Label contestName;

    private int contestID;

    public void setContestID(int contestID) {
        this.contestID = contestID;
    }

    @FXML
    private Label date;

    @FXML
    private Label problemRattingRange;

    @FXML
    private VBox profileBox;

    @FXML
    private VBox rankingBox;

    @FXML
    private Label time;

    @FXML
    private Label totalContestants;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contestHome.fxml"));
        root = loader.load();

        ContestHome contestHome = loader.getController();
        contestHome.setNc(userSession.getNc());
        contestHome.setUserInfo(userSession.getUserInfo());


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       if(contestID != 0){
           try {
               loadcontestInfo();
               loadContestantInfo();
           } catch (SQLException | IOException e) {
               throw new RuntimeException(e);
           }
       }

    }

    private void loadContestantInfo() throws SQLException, IOException {
        ResultSet resultSet = dbOperation.contestants(contestID);
        while (resultSet.next()){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("contestProfile.fxml"));
            AnchorPane root = fxmlLoader.load();
            contestProfileController controller = fxmlLoader.getController();
            String name = resultSet.getString("name");
            String mail = resultSet.getString("contestantMail");
            String image = resultSet.getString("pic");
            controller.setInfo(name,image,mail);
            profileBox.getChildren().add(root);

        }
    }

    private void loadcontestInfo() throws SQLException {
        ResultSet resultSet = dbOperation.contestDetails(contestID);
        contestName.setText(resultSet.getString("name"));
        date.setText(resultSet.getString("day"));
        int startTime = resultSet.getInt("start_time");
        int endTime = resultSet.getInt("start_time")+resultSet.getInt("length");
        time.setText(startTime+" - "+endTime);
        String minRat = resultSet.getString("minRat");
        String maxRat = resultSet.getString("maxRat");
        problemRattingRange.setText(minRat+" - "+maxRat);
        totalContestants.setText(String.valueOf(dbOperation.numOfContestants(contestID)));
        resultSet = dbOperation.contestants(contestID);
        Label name = new Label("Name");
        Label Ratting = new Label("Ratting");
        name.setStyle("-fx-text-fill: #df3079; -fx-font-size: 18px; -fx-underline: true;");
        Ratting.setStyle("-fx-text-fill: #df3079; -fx-font-size: 18px; -fx-underline: true;");
        HBox box = new HBox(80); // 20 spacing fixed
        box.getChildren().addAll(name,Ratting);
        rankingBox.getChildren().addAll(box);
        int itr = 1;
        while (resultSet.next()){
            String contestantName = resultSet.getString("name");
            String[] words = contestantName.split(" ");
            String contestantMail = resultSet.getString("contestantMail");
            Label label = new Label(itr+". "+words[0]);
            label.setStyle("-fx-text-fill: #df3079; -fx-font-size: 18px;");
            int points = dbOperation.totalPoints(contestID, contestantMail);
            Label label1 = new Label(String.valueOf(points));
            label1.setStyle("-fx-text-fill: #df3079; -fx-font-size: 18px;");
            HBox hBox = new HBox(80);
            hBox.getChildren().addAll(label,label1);
            rankingBox.getChildren().add(hBox);
            itr++;
        }
    }
}
