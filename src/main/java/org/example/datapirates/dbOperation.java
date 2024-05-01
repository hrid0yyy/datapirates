package org.example.datapirates;
import org.example.datapirates.dataBaseConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class dbOperation {

    static HashMap<Integer, Integer> length = new HashMap<>();
    static public Connection connection;


    static {
        try {
            connection = dbHandler.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
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
    public static void joinContest(String contestantMail, int contestID) throws SQLException {
        query = "Insert into contestants (contestID,contestantMail) values(?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        preparedStatement.setString(2,contestantMail);
        preparedStatement.execute();

    }



    public static void contestSubmission(int contestID, int problemID,String mail, String code,int accept) throws SQLException {
        query = "insert into contestsubmission (contestID,problemID,mail,accept,code) values(?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        preparedStatement.setInt(2,problemID);
        preparedStatement.setString(3,mail);
        preparedStatement.setInt(4,accept);
        preparedStatement.setString(5,code);
        preparedStatement.execute();

    }
    public static boolean checkContestants(String contestantMail, int contestID) throws SQLException {
        query = "select * from contestants where contestantMail = ? and contestID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,contestantMail);
        preparedStatement.setInt(2,contestID);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();

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
    public static int totalContestants(int contestID) throws SQLException {
        query = "SELECT count(*) as total from contestants where contestID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("total");
    }
    public static int totalPoints(int contestID ,String mail) throws SQLException {
        query = "SELECT t1 - t2 as total \n" +
                "FROM \n" +
                "(SELECT COALESCE(SUM(ratting), 0)  as t1, ? as mail from contestproblems join contestsubmission on contestproblems.problemID = contestsubmission.problemID where contestID = ?  and mail = ? and accept = ?) as tab1\n" +
                "JOIN\n" +
                "(SELECT COALESCE(SUM(ratting), 0) as t2,? as mail from contestproblems join contestsubmission on contestproblems.problemID = contestsubmission.problemID where contestID = ?  and mail = ? and accept = ?) as tab2\n" +
                "on tab1.mail = tab2.mail";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,mail);
        preparedStatement.setInt(2,contestID);
        preparedStatement.setString(3,mail);
        preparedStatement.setInt(4,1);
        preparedStatement.setString(5,mail);
        preparedStatement.setInt(6,contestID);
        preparedStatement.setString(7,mail);
        preparedStatement.setInt(8,0);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt("total");
        }
        return 0;

    }
    public static int totalSubmission(int contestID,int problemID) throws SQLException {
        query = " SELECT count(*) as total from contestsubmission where contestID = ? and accept = ? and problemID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        preparedStatement.setInt(2,1);
        preparedStatement.setInt(3,problemID);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("total");
    }

    public static ResultSet posts(String mail) throws SQLException {
        query = "Select * from posts where mail = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, mail);
        resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }
    public static  ResultSet upcomingContest() throws SQLException {
        query = "Select * from contestState join contest on contestState.contestID = contest.contestID where state = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,"Upcoming");
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public static  ResultSet ongoingContest() throws SQLException {
        query = "Select * from contestState join contest on contestState.contestID = contest.contestID where state = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,"Ongoing");
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public static  ResultSet closedContest() throws SQLException {
        query = "Select * from contestState join contest on contestState.contestID = contest.contestID where state = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,"Closed");
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public  static ResultSet contestDetails(int ContestID) throws SQLException {
        query = "select * from contest where contestID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,ContestID);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;
    }
    public static boolean isOldAccount(String mail) throws SQLException {
        query = "Select * from users where email = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, mail);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }
    public static boolean contestSubmit(String mail,int contestID,int problemID,int accept) throws SQLException {
        query = " SELECT * from contestsubmission where contestID = ? and accept = ? and problemID = ? and mail = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        preparedStatement.setInt(2,accept);
        preparedStatement.setInt(3,problemID);
        preparedStatement.setString(4,mail);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
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
    public static void addContest(String name, String date, int time, int contestants, int maxRat, int minRat, int len) throws SQLException {
        query = "INSERT INTO `contest` (`contestID`, `name`, `day`, `start_time`, `contestants`, `maxRat`, `minRat`, `length`)" +
                " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,date);
        preparedStatement.setInt(3,time);
        preparedStatement.setInt(4,contestants);
        preparedStatement.setInt(5,maxRat);
        preparedStatement.setInt(6,minRat);
        preparedStatement.setInt(7,len);
        preparedStatement.execute();


        String selectQuery = "SELECT * FROM `contest` WHERE `name` = ? AND `day` = ? AND `start_time` = ?";
        preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, date);
        preparedStatement.setInt(3, time);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int contestID = resultSet.getInt("contestID");


        query = "INSERT INTO `conteststate` (`contestID`, `state`) VALUES (?, ?);";
        String state = "Upcoming";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        preparedStatement.setString(2,state);
        preparedStatement.execute();

        // adding problems to the contest
        ContestProblems(contestID,minRat,maxRat,len);

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

    public static ResultSet loadContest() throws SQLException {
        query = "select * from contest";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }
    public static List<Integer> getRandomProblems(ArrayList<Integer> problems, int count) {
        // Shuffle the ArrayList to get random order
        Collections.shuffle(problems);

        // Get the first 'count' elements from the shuffled list
        return problems.subList(0, count);
    }
    public static void ContestProblems(int contestID,int minRat, int maxRat,int len) throws SQLException {
        query = "SELECT * FROM `contestproblems` where ratting >= ? and ratting <= ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, minRat);
        preparedStatement.setInt(2, maxRat);
        resultSet = preparedStatement.executeQuery();
        ArrayList<Integer> problems = new ArrayList<>();
        while (resultSet.next()){
            problems.add(resultSet.getInt("problemID"));
        }

        length.put(1,3);
        length.put(2,6);
        length.put(3,8);
        length.put(4,10);

        query = "INSERT into problemSet (contestID, problemID) values(?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        List<Integer> randomProblems = getRandomProblems(problems, length.get(len));
        for(Integer random : randomProblems){
             preparedStatement.setInt(2,random);
             preparedStatement.execute();
        }

    }

    public static ResultSet detailsQuery(String email) throws SQLException {
        query = "Select * from user_profile where umail = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return  resultSet;

    }
    public static boolean isRegistered(String mail,int contestID) throws SQLException {
        query = "select * from contestants where contestID = ? and contestantMail = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        preparedStatement.setString(2,mail);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public static ResultSet loadContestProblems(int contestID) throws SQLException {
        query = "select * from problemset join contestproblems on problemset.problemID = contestproblems.problemID where contestID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contestID);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public static ResultSet problemInfo(int problemID) throws SQLException {
        query = "select * from contestproblems where problemID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,problemID);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;
    }
    public static ResultSet contestInfo(int ContestID) throws SQLException {
        query = "select * from contest where contestID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,ContestID);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;
    }
    public static void updateContest(int contestID, String state) throws SQLException {
        query = "update contestState set state = ? where contestID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,state);
        preparedStatement.setInt(2,contestID);
        preparedStatement.executeUpdate();
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
