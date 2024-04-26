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
    public static ResultSet solvedProbelms(String email) throws SQLException {
        query = "Select * from solved join problems on solved.problemID = problems.problemID where userMail = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }

    public static void addAccount(String email , String pass) throws SQLException {
        query = "INSERT INTO users (pass, email) VALUES (?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,pass);
        preparedStatement.setString(2,email);
        preparedStatement.execute();

    }
    public static void addDefaultPic(String mail,String name) throws SQLException {
        query = "INSERT INTO user_profile (umail, pic, name) VALUES (?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,mail);
        preparedStatement.setString(2,"images/user.png");
        preparedStatement.setString(3,name);
        preparedStatement.execute();
    }
    public static String[] friends(String mail) throws SQLException {
        String[] friends = new String[1000];
        query = "Select * from friends where umail = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,mail);
        resultSet = preparedStatement.executeQuery();
        int itr = 0;
        while (resultSet.next()){
            friends[itr] = resultSet.getString("fmail");
            itr++;
        }
        return friends;
    }
    public static ResultSet posts(String mail) throws SQLException {
        query = "Select * from posts where mail = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, mail);
        resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }
    public static boolean isOldAccount(String mail) throws SQLException {
        query = "Select * from users where email = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, mail);
        resultSet = preparedStatement.executeQuery();
       if(resultSet.next())
       {
           return true;
       }
       else
       {
           return false;
       }

    }
    public static  ResultSet solved(String mail) throws SQLException {
        query = "SELECT COUNT(*) AS total FROM solved WHERE userMail = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mail);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;


    }
    public static void SaveChat(String Sender, String Receiver, String Msg) throws SQLException {
        query = "INSERT INTO chat (sender, receiver, message) VALUES (?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,Sender);
        preparedStatement.setString(2,Receiver);
        preparedStatement.setString(3,Msg);
        preparedStatement.execute();
    }
    public static ResultSet LoadChat(String sender, String receiver) throws SQLException {
        query = "SELECT sender,receiver,message,id FROM `chat` WHERE (sender = ? and receiver = ?) or (sender = ? and receiver = ? )";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,sender);
        preparedStatement.setString(2,receiver);
        preparedStatement.setString(3,receiver);
        preparedStatement.setString(4,sender);
        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
    public static ResultSet LoadChatSince(String sender, String receiver, long lastProcessedRowId) throws SQLException {
        query = "SELECT id, sender, receiver, message FROM `chat` " +
                "WHERE ((sender = ? AND receiver = ?) OR (sender = ? AND receiver = ?)) " +
                "AND id > ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, sender);
        preparedStatement.setString(2, receiver);
        preparedStatement.setString(3, receiver);
        preparedStatement.setString(4, sender);
        preparedStatement.setLong(5, lastProcessedRowId); // Set the last processed row ID

        resultSet = preparedStatement.executeQuery();

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
