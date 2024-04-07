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
    static private String query;
    static public PreparedStatement preparedStatement;
    static private ResultSet resultSet;

    public static ResultSet loginquery(String  email, String pass) throws SQLException, ClassNotFoundException {

        query = "Select * from users where email = ? and pass = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, email);
        preparedStatement.setString(2, pass);
        resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }
    public static  ResultSet solved(String mail) throws SQLException {
        query = "SELECT COUNT(*) AS total FROM solved WHERE userMail = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mail);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;


    }
    public static ResultSet detailsQuery(String email) throws SQLException {
        query = "Select * from user_profile where umail = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return  resultSet;

    }
    public static void updateProfile(String name,String about_me,String Institution,String Position,String pic, String email) throws SQLException {
        query = "UPDATE user_profile SET name = ?, about_me = ? , institution = ?, position = ?, pic = ? where umail = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, about_me);
        preparedStatement.setString(3, Institution);
        preparedStatement.setString(4, Position);
        preparedStatement.setString(5, pic);
        preparedStatement.setString(6, email);
        preparedStatement.executeUpdate();
        
    }
    public static void updateProfile(String name,String about_me,String Institution,String Position, String email) throws SQLException {
        query = "UPDATE user_profile SET name = ?, about_me = ? , institution = ?, position = ? where umail = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, about_me);
        preparedStatement.setString(3, Institution);
        preparedStatement.setString(4, Position);
        preparedStatement.setString(5, email);
        preparedStatement.executeUpdate();

    }


}
