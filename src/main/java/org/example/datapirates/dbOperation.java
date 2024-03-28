package org.example.datapirates;
import org.example.datapirates.dataBaseConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbOperation {
    static public Connection connection;

    static {
        try {
            connection = dbHandler.getDbConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static public PreparedStatement preparedStatement;

    public static ResultSet loginquery(String  email, String pass) throws SQLException, ClassNotFoundException {

        String query = "Select * from users where email = ? and pass = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, email);
        preparedStatement.setString(2, pass);
        ResultSet resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }


}
