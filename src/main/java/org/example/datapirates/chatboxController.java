package org.example.datapirates;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.datapirates.ServerBackend.Data;
import org.example.datapirates.ServerBackend.NetworkConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class chatboxController implements Initializable {
    @FXML
    private VBox chatbox;

    @FXML
    private TextField msgBox;
    private Data data = new Data();
    private UserInfo userInfo;
    @FXML
    private Label fName;

    @FXML
    private ImageView fPic;



    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private NetworkConnection nc;

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }
    private String receiver;
    private static long lastProcessedRowId = 0; // Assuming row ID is a numeric column
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @FXML
    void send(ActionEvent event) {
        String message = msgBox.getText();
        if(message.isEmpty()){
            return;
        }
        String req = userInfo.getMail() + "$" + receiver + "$send$" + message;
        data.message = req;

        addLabel(message);
        try {
            nc.write(data.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        msgBox.clear();

    }
    private String Rname;
    public void design() throws SQLException {
        ResultSet resultSet;
        resultSet = dbOperation.detailsQuery(receiver);
        Rname = resultSet.getString("name");
        fName.setText(Rname);
        fPic.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(resultSet.getString("pic")))));
        double diameter = Math.min(fPic.getFitWidth(), fPic.getFitHeight()); // Determine diameter based on smaller dimension
        Circle clip = new Circle(diameter / 2, diameter / 2, diameter / 2);
        fPic.setClip(clip);

    }
    private void LoadChat() {
        ResultSet chat;
        try {
            chat = dbOperation.LoadChat(userInfo.getMail(), receiver);
            while (chat.next()) {
                if(chat.getString("receiver").equals(receiver)) {
                    addLabel(chat.getString("message"));
                }
                else
                {
                    addLabel2(chat.getString("message"));
                }
                lastProcessedRowId = chat.getInt("id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private ScrollPane sp_main;
   private Thread newChat;
    @FXML
    void goBack(ActionEvent event) throws IOException {
        if (newChat != null && newChat.isAlive()) {
            newChat.interrupt();
            try {
                newChat.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("friendlist.fxml"));
        Parent root = loader.load();
        friendListController listController = loader.getController();
        listController.setUserInfo(userInfo);
        listController.setNc(nc);

        listController.initialize(null,null);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //Friends text message style
    public void addLabel2(String message){
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(5,5,5,10));
        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(233,233,235); -fx-background-radius: 20px;");
        textFlow.setPadding(new Insets(5,10,5,10));
        hbox.getChildren().addAll(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatbox.getChildren().add(hbox);
            }
        });
    }


    //users text message style
public void addLabel(String message){
    HBox hbox = new HBox();
    hbox.setAlignment(Pos.CENTER_RIGHT);

    hbox.setPadding(new Insets(5,5,5,10));
    Label text = new Label(message);
    text.setStyle("-fx-text-fill: white;");
    TextFlow textFlow = new TextFlow(text);
    textFlow.setStyle("-fx-background-color: rgb(15,125,242); -fx-background-radius: 20px;");
    textFlow.setPadding(new Insets(5,10,5,10));
    hbox.getChildren().add(textFlow);
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
          chatbox.getChildren().add(hbox);
        }
    });
}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(userInfo != null && nc != null)
        {
            try {
                design();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
                LoadChat();
            System.out.println(lastProcessedRowId);
            newChat = new Thread(()->{
                try {
                   while (true){
                       ResultSet resultSet = dbOperation.LoadChatSince(userInfo.getMail(),receiver,lastProcessedRowId);
                       while (resultSet.next()){
                           if(!resultSet.getString("receiver").equals(receiver)) {
                               addLabel2(resultSet.getString("message"));
                           }
                           lastProcessedRowId = resultSet.getInt("id");
                       }

                       resultSet.close();
                       Thread.sleep(500);

                   }

                } catch (SQLException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
            newChat.start();

        }

        chatbox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
               sp_main.setVvalue((Double) t1);
            }
        });

    }

}
