package org.example.datapirates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.datapirates.dataBaseConnection.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<Problems, Void> actionCol;

    @FXML
    private HBox navBar;
    private UserInfo userInfo;

    @FXML
    private TableColumn<Problems, Integer> pIDcol;

    @FXML
    private TableColumn<Problems, String> pNameCol;

    @FXML
    private TableView<Problems> problemTable;

    @FXML
    private TableColumn<Problems, String> typeCol;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadDate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private  void refreshTable() throws SQLException {
        problemsList.clear();

        query = "Select * FROM problems";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
             problemsList.add(new Problems(resultSet.getInt("problemID"),resultSet.getString("problemName"),"lula",resultSet.getString("description")));
             problemTable.setItems(problemsList);
        }

    }
    private void loadDate () throws SQLException, ClassNotFoundException {
        connection = dbHandler.getDbConnection();
        refreshTable();
        pIDcol.setCellValueFactory(new PropertyValueFactory<>("problemID"));
        pNameCol.setCellValueFactory(new PropertyValueFactory<>("problemName"));
    //    actionCol.setCellValueFactory(new PropertyValueFactory<>("button"));
        addButtonToTable();
      
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
                            } catch (IOException e) {
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
    private Stage stage;
    private Scene scene;
    private Parent root;


    private void handleNavigation(Problems problem, ActionEvent event) throws IOException {
        // Implement navigation logic here
        // For example, switch scenes or load another FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("compiler.fxml"));
        root = loader.load();
        compilerController compilerHome = loader.getController();
        compilerHome.setUserInfo(getUserInfo());
        compilerHome.setProblems(problem);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
