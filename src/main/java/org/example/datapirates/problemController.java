package org.example.datapirates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.datapirates.ServerBackend.NetworkConnection;
import org.example.datapirates.dataBaseConnection.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class problemController implements Initializable {
    @FXML
    private Label solved;
    @FXML
    private Label attempted;
    @FXML
    private TableColumn<Problems, Void> actionCol;
    @FXML
    private TextField searchBar;
    @FXML
    private HBox navBar;


    public UserInfo userInfo;

    @FXML
    private TableColumn<Problems, Integer> pIDcol;

    @FXML
    private TableColumn<Problems, String> pNameCol;

    @FXML
    private TableView<Problems> problemTable;

    @FXML
    private TableColumn<Problems, String> typeCol;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private NetworkConnection nc;

    public void setNc(NetworkConnection nc) {
        this.nc = nc;
    }

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Problems problems = null;
    ObservableList<Problems> problemsList = FXCollections.observableArrayList();

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;

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
            solved.setStyle("-fx-text-fill: white;");

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
            attempted.setStyle("-fx-text-fill: white;");

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(userInfo != null) {
            setSolved();
            setSubmission();
        }
        try {

                loadDate();
                setupSearchBarListener();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    private void setupSearchBarListener() {
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                filterTable(newValue);
            } else {
                try {
                    refreshTable();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void filterTable(String searchTerm) {
        ObservableList<Problems> filteredList = FXCollections.observableArrayList();

        for (Problems problem : problemsList) {
            if (String.valueOf(problem.getProblemID()).contains(searchTerm) || problem.getProblemName().contains(searchTerm)) {
                filteredList.add(problem);
            }
        }
        problemTable.setItems(filteredList);
    }


    private  void refreshTable() throws SQLException {
        problemsList.clear();

        query = "Select * FROM problems";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
             problemsList.add(new Problems(resultSet.getInt("problemID"),resultSet.getString("problemName"),resultSet.getString("problemType"),resultSet.getString("description")
             ,resultSet.getString("driverCode"),resultSet.getString("output"),resultSet.getString("codeFormat")));
             problemTable.setItems(problemsList);
        }

    }
    private void loadDate () throws SQLException, ClassNotFoundException {
        connection = dbHandler.getDbConnection();
        refreshTable();
        pIDcol.setCellValueFactory(new PropertyValueFactory<>("problemID"));
        pNameCol.setCellValueFactory(new PropertyValueFactory<>("problemName"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("problemType"));
        addButtonToTable();
      
    }

    @FXML
    void homeBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        dashboardcontroller home = loader.getController();
        home.setUserInfo(userInfo);
        home.setNc(nc);
        home.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void addButtonToTable() {
        TableColumn<Problems, Void> colBtn = new TableColumn<>("Action");

        Callback<TableColumn<Problems, Void>, TableCell<Problems, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Problems, Void> call(final TableColumn<Problems, Void> param) {
                final TableCell<Problems, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Attempt");

                    {
                        btn.setOnAction(event -> {
                            Problems problem = getTableView().getItems().get(getIndex());
                            // Implement your action here, such as navigating to another page
                            // For example, you can call a method to handle navigation
                            try {
                                handleNavigation(problem,event);
                            } catch (IOException | SQLException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        actionCol.setCellFactory(param -> colBtn.getCellFactory().call(param));
    }


    private void handleNavigation(Problems problem, ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        // Implement navigation logic here
        // For example, switch scenes or load another FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("compiler.fxml"));
        root = loader.load();
        compilerController compilerHome = loader.getController();
        compilerHome.setUserInfo(getUserInfo());
        compilerHome.setProblems(problem);
        compilerHome.setNc(nc);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
