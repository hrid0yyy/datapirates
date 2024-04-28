package org.example.datapirates.ContestBackend;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class contestHandler extends TimerTask {
    private Timer timer;
    private Calendar calendar = Calendar.getInstance();
    private int contestID;



    contestHandler(int contestID, String date){
        this.contestID = contestID;
        // write function to use String date to populate the calendar instance 

    }

    @Override
    public void run() {

    }
}
