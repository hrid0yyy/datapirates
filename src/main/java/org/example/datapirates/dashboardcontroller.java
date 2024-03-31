package org.example.datapirates;
import org.example.datapirates.dataBaseConnection.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class dashboardcontroller implements Initializable {
    @FXML
    private ScrollPane timeline;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private UserInfo userInfo;
    @FXML
    private TextArea postbox;
    @FXML
    private Label welcomeLabel;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        welcomeLabel.setText(userInfo.getMail());

    }

    public UserInfo getUserInfo() {
        return userInfo;
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


    private void loadPosts() {
        try {
            // Establish database connection
            Connection connection = dbHandler.getDbConnection();

            // Prepare SQL statement
            String sql = "SELECT content, time, fmail FROM users " +
                    "JOIN friends ON users.email = friends.umail " +
                    "JOIN posts ON friends.fmail = posts.mail " +
                    "WHERE users.email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail());

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Clear previous posts
            VBox postContainer = new VBox(); // Create a VBox to contain posts

            // Process results
            while (resultSet.next()) {
                // Retrieve post data
                String content = resultSet.getString("content");
                Timestamp timestamp = resultSet.getTimestamp("time");
                String friendMail = resultSet.getString("fmail");

                // Format timestamp to display time like "7:30 PM, 31 March, 2024"
                SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a, d MMMM, yyyy");
                String formattedTime = dateFormat.format(timestamp);

                // Create labels for content, time, and friend's email
                Label contentLabel = new Label(content);
                Label timeLabel = new Label(formattedTime);
                Label friendMailLabel = new Label(friendMail);

                // Apply CSS styling to labels
                contentLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                timeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #808080;");
                friendMailLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #808080;");

                // Add labels to the post container
                postContainer.getChildren().addAll(friendMailLabel, timeLabel, contentLabel);

                // Add some spacing between posts
                postContainer.getChildren().add(new Label("")); // Spacer
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            // Set the content of the ScrollPane to the post container
            timeline.setContent(postContainer);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void postbtn(ActionEvent event) {
        String postContent = postbox.getText(); // Get post content from TextArea
        if (!postContent.isEmpty()) { // Check if the post content is not empty
            // Perform actions to save the post to the database
            savePostToDatabase(postContent);
            // Reload posts after posting
            loadPosts();
            // Clear the postbox TextArea after posting
            postbox.clear();
        }
    }

    private void savePostToDatabase(String postContent) {
        try {
            // Establish database connection
            Connection connection = dbHandler.getDbConnection();
            LocalDateTime currentDateTime = LocalDateTime.now();
            // Prepare SQL statement to insert the post
            String sql = "INSERT INTO posts (mail, content,time) VALUES (?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail()); // Assuming userInfo is properly set
            statement.setString(2, postContent);
            statement.setTimestamp(3, Timestamp.valueOf(currentDateTime));


            // Execute the insert statement
            statement.executeUpdate();

            // Close resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
           if(userInfo != null)
           {
               loadPosts();
           }
    }

}


