package org.example.datapirates.ContestBackend;

import org.example.datapirates.dbOperation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class contest implements Runnable{
    public contest(){
      new Thread(this).start();
    }
    @Override
    public void run() {
        try {
            ResultSet resultSet = dbOperation.loadContest();
            while (resultSet.next()){
                int contestID = resultSet.getInt("contestID");
                String date = resultSet.getString("day");
                int hour = resultSet.getInt("start_time");
                int len = resultSet.getInt("length");

                // start a thread for that contest
                new contestHandler(contestID,date,hour,len);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
