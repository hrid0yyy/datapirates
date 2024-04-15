package org.example.datapirates;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.example.datapirates.dataBaseConnection.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private VBox friendReqBox;
    @FXML
    private VBox searchBox;
    @FXML
    private TextField searchBar;
    @FXML
    private Label attempted;
    @FXML
    private Label solved;


    @FXML
    void searchFriend(ActionEvent event) {
        String searchTerm = searchBar.getText().trim();
        if (!searchTerm.isEmpty()) {
            try {

                Connection connection = dbHandler.getDbConnection();

                String sql = "SELECT email,name,pic FROM users JOIN user_profile on users.email = user_profile.umail WHERE email LIKE ? AND email != ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + searchTerm + "%");
                statement.setString(2, userInfo.getMail());


                ResultSet resultSet = statement.executeQuery();


                searchBox.getChildren().clear();


                while (resultSet.next()) {
                    String userEmail = resultSet.getString("email");
                    String userName = resultSet.getString("name");
                    String userPic = resultSet.getString("pic");

                    if (isFriend(userEmail)) {
                        Image userImage = new Image(getClass().getResourceAsStream(userPic));
                        ImageView userImageView = new ImageView(userImage);
                        userImageView.setFitWidth(40);
                        userImageView.setFitHeight(40);

                        Label userLabel = new Label(userName +"\n"+ "Friend");
                        userLabel.setCursor(Cursor.HAND); // Change cursor to hand
                        userLabel.setOnMouseClicked(e -> {
                            try {
                                goToFriendProfile(userEmail);
                            } catch (IOException | SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }); // Go to friend's profile on click

                        VBox userInfoBox = new VBox(10);
                        userInfoBox.getChildren().addAll(userImageView,userLabel);
                        searchBox.getChildren().addAll(userInfoBox);
                    } else {
                        Image userImage = new Image(getClass().getResourceAsStream(userPic));
                        ImageView userImageView = new ImageView(userImage);
                        userImageView.setFitWidth(40);
                        userImageView.setFitHeight(40);

                        Label userLabel = new Label(" " + userName);
                        userLabel.setCursor(Cursor.HAND); // Change cursor to hand
                        userLabel.setOnMouseClicked(e -> {
                            try {
                                goToFriendProfile(userEmail);
                            } catch (IOException | SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }); // Go to friend's profile on click

                        Button sendRequestButton = new Button();
                        Image addFriendIcon = new Image(getClass().getResourceAsStream("images/add-user.png"));
                        ImageView addFriendImageView = new ImageView(addFriendIcon);
                        addFriendImageView.setFitWidth(20);
                        addFriendImageView.setFitHeight(20);
                        sendRequestButton.setGraphic(addFriendImageView);
                        sendRequestButton.setOnAction(Event -> sendFriendRequest(userEmail));

                        VBox userInfoBox = new VBox(10);
                        userInfoBox.getChildren().addAll(userImageView,userLabel, sendRequestButton);

                        searchBox.getChildren().add(userInfoBox);
                    }
                }


                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {

            searchBox.getChildren().clear();
        }
    }

    // Method to navigate to friend's profile
    private void goToFriendProfile(String friendEmail) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("friendProfile.fxml"));
        root = loader.load();

       friendProfileController controller = loader.getController();
        controller.setFriendEmail(friendEmail);
        controller.setUserInfo(userInfo);
        controller.initialize(null, null);
        scene = new Scene(root);

        stage = (Stage) searchBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }




    private boolean isFriend(String userEmail) throws SQLException, ClassNotFoundException {
        Connection connection = dbHandler.getDbConnection();


        String sql = "SELECT * FROM friends WHERE (fmail = ? AND umail = ?) OR (fmail = ? AND umail = ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userInfo.getMail());
        statement.setString(2, userEmail);
        statement.setString(3, userEmail);
        statement.setString(4, userInfo.getMail());


        ResultSet resultSet = statement.executeQuery();


        boolean isFriend = resultSet.next();


        resultSet.close();
        statement.close();
        connection.close();

        return isFriend;
    }




    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;


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

            Connection connection = dbHandler.getDbConnection();


            String sql = "SELECT content, time,pic,name, fmail FROM users " +
                    "JOIN friends ON users.email = friends.umail " +
                    "JOIN posts ON friends.fmail = posts.mail " +
                    "JOIN user_profile ON friends.fmail = user_profile.umail " +
                    "WHERE users.email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail());


            ResultSet resultSet = statement.executeQuery();


            VBox postContainer = new VBox();


            while (resultSet.next()) {
                String content = resultSet.getString("content");
                Timestamp timestamp = resultSet.getTimestamp("time");
                String friendName = resultSet.getString("name");
                String friendPic = resultSet.getString("pic");
                String friendMail = resultSet.getString("fmail");

                Image userImage = new Image(getClass().getResourceAsStream(friendPic));
                ImageView userImageView = new ImageView(userImage);
                userImageView.setFitWidth(40);
                userImageView.setFitHeight(40);

                SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a, d MMMM, yyyy");
                String formattedTime = dateFormat.format(timestamp);

                Label contentLabel = new Label(content);
                Label timeLabel = new Label(formattedTime);
                Label friendMailLabel = new Label("  "+friendName);
                friendMailLabel.setCursor(Cursor.HAND); // Change cursor to hand
                friendMailLabel.setOnMouseClicked(e -> {
                    try {
                        goToFriendProfile(friendMail);
                    } catch (IOException | SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }); 


                HBox nameNpic = new HBox();
                nameNpic.getChildren().addAll(userImageView,friendMailLabel);
                HBox.setMargin(friendMailLabel, new Insets(20, 0, 0, 0));


                contentLabel.setStyle("-fx-font-size: 14px;");
                timeLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #808080;");
                friendMailLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #808080;");


                postContainer.getChildren().addAll(nameNpic, timeLabel, contentLabel);


                postContainer.getChildren().add(new Label(""));
            }


            resultSet.close();
            statement.close();
            connection.close();


            timeline.setContent(postContainer);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void postbtn(ActionEvent event) {
        String postContent = postbox.getText();
        if (!postContent.isEmpty()) {
            savePostToDatabase(postContent);

            loadPosts();

            postbox.clear();
        }
    }

    private void savePostToDatabase(String postContent) {
        try {

            Connection connection = dbHandler.getDbConnection();
            LocalDateTime currentDateTime = LocalDateTime.now();

            String sql = "INSERT INTO posts (mail, content,time) VALUES (?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail());
            statement.setString(2, postContent);
            statement.setTimestamp(3, Timestamp.valueOf(currentDateTime));



            statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(userInfo != null) {
            loadPosts();
            loadFriendRequests();
            setSolved();
            setSubmission();
        }
    }
    private  void setSolved()
    {
        try {
            // Establish database connection
            Connection connection = dbHandler.getDbConnection();

            // Prepare SQL statement to count rows
            String sql = "SELECT COUNT(*) AS total FROM solved WHERE userMail = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail()); // Replace with the actual user email

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the row count
            int rowCount = 0;
            if (resultSet.next()) {
                rowCount = resultSet.getInt("total");
            }

            // Set the value of the 'solved' label
            solved.setText(String.valueOf(rowCount));

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private  void setSubmission()
    {
        try {
            // Establish database connection
            Connection connection = dbHandler.getDbConnection();

            // Prepare SQL statement to count rows
            String sql = "SELECT COUNT(*) AS total FROM attempted WHERE userMail = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail()); // Replace with the actual user email

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the row count
            int rowCount = 0;
            if (resultSet.next()) {
                rowCount = resultSet.getInt("total");
            }

            // Set the value of the 'solved' label
            attempted.setText(String.valueOf(rowCount));

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void loadFriendRequests() {
        try {

            Connection connection = dbHandler.getDbConnection();

            String sql = "SELECT sender_email,name,pic FROM friend_requests join user_profile on friend_requests.sender_email = user_profile.umail WHERE receiver_email = ? AND status = 'pending'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail());

            ResultSet resultSet = statement.executeQuery();

            friendReqBox.getChildren().clear();


            while (resultSet.next()) {

                String senderEmail = resultSet.getString("sender_email");
                String senderName = resultSet.getString("name");
               String userPic = resultSet.getString("pic");
                Image userImage = new Image(getClass().getResourceAsStream(userPic));
                ImageView userImageView = new ImageView(userImage);
                userImageView.setFitWidth(40);
                userImageView.setFitHeight(40);


                Label senderLabel = new Label(senderName);
                Image addFriendIcon = new Image(getClass().getResourceAsStream("images/friend-request.png"));
                ImageView addFriendImageView = new ImageView(addFriendIcon);
                senderLabel.setCursor(Cursor.HAND); // Change cursor to hand
                senderLabel.setOnMouseClicked(e -> {
                    try {
                        goToFriendProfile(senderEmail);
                    } catch (IOException | SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }); // Go to friend's profile on click
                addFriendImageView.setFitWidth(20);
                addFriendImageView.setFitHeight(20);
                Button acceptButton = new Button();
                acceptButton.setGraphic(addFriendImageView);
                acceptButton.setOnAction(event -> acceptFriendRequest(senderEmail));


                VBox friendRequestVBox = new VBox(5);
                friendRequestVBox.getChildren().addAll(userImageView,senderLabel,acceptButton);


                friendReqBox.getChildren().add(friendRequestVBox);
            }


            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private void sendFriendRequest(String receiverEmail) {
        try {

            Connection connection = dbHandler.getDbConnection();


            String sql = "INSERT INTO friend_requests (sender_email, receiver_email, status) VALUES (?, ?, 'pending')";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getMail());
            statement.setString(2, receiverEmail);


            statement.executeUpdate();


            statement.close();
            connection.close();

            System.out.println("Friend request sent to " + receiverEmail);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void profileBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        root = loader.load();
        profileController profileHome = loader.getController();
        profileHome.setUserInfo(getUserInfo());
        profileHome.initialize(null, null);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void acceptFriendRequest(String senderEmail) {
        try {

            Connection connection = dbHandler.getDbConnection();


            String updateSql = "UPDATE friend_requests SET status = 'accepted' WHERE sender_email = ? AND receiver_email = ? AND status = 'pending'";
            PreparedStatement updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setString(1, senderEmail);
            updateStatement.setString(2, userInfo.getMail());


            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Friend request accepted successfully.");

                String insertSql = "INSERT INTO friends (fmail, umail) VALUES (?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setString(1, senderEmail);
                insertStatement.setString(2, userInfo.getMail());


                insertStatement.executeUpdate();
                insertStatement.close();


                loadFriendRequests();
            } else {
                System.out.println("Failed to accept friend request.");
            }


            updateStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




}


