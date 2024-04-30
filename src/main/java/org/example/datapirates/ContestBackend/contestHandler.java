package org.example.datapirates.ContestBackend;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.example.datapirates.dbOperation;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class contestHandler implements Runnable{

    private final String date;
    private int hour;
    private int len;
    private int contestID;


    private final Calendar contestStart = Calendar.getInstance();

    private final Calendar contestFinish = Calendar.getInstance();

    public void setTimer(String givenDateString){
        String[] parts = givenDateString.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1;
        int day = Integer.parseInt(parts[2]);

        contestStart.set(Calendar.YEAR, year);
        contestStart.set(Calendar.MONTH, month);
        contestStart.set(Calendar.DAY_OF_MONTH, day);
        contestStart.set(Calendar.HOUR,hour);


        contestFinish.set(Calendar.YEAR, year);
        contestFinish.set(Calendar.MONTH, month);
        contestFinish.set(Calendar.DAY_OF_MONTH, day);
        contestFinish.set(Calendar.HOUR,hour+len);

    }
    public contestHandler(int contestID, String date, int hour, int len){
        this.contestID = contestID;
        this.hour = hour;
        this.date = date;
        this.len = len;
        setTimer(date);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        boolean notUpdated = true;
        while(true){
            if (calendar.after(contestFinish)){
                // contestState ongoing to closed
                System.out.println(contestID+" Contest Finished");
                try {
                    dbOperation.updateContest(contestID,"Closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            if(calendar.before(contestStart)){
                 // thread will go on
            }
            else
            {
                if(notUpdated) {
                    notUpdated = false;
                    try {
                        dbOperation.updateContest(contestID, "Ongoing");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }



        }
    }
}
