package org.example.datapirates;

import org.example.datapirates.dataBaseConnection.dbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class debug {
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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String user_email = "hridoy@gmai.com";
        String password = "1234";
        ResultSet resultSet =  dbOperation.loginquery(user_email,password);
        if(!resultSet.next())
        {
            System.out.println("faka");
        }
        else {
            System.out.println(resultSet.getString("email"));
        }
    }
}
