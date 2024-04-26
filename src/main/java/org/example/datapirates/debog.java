package org.example.datapirates;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class debog {
    // Variable to store the last processed row ID or timestamp
    private static long lastProcessedRowId = 0; // Assuming row ID is a numeric column

    // Example usage
    public static void main(String[] args) throws SQLException, InterruptedException {
        Thread chatload = new Thread(()->{
            while (true) {
                // Fetch only the new rows since the last processed row
                try{
                    ResultSet resultSet = dbOperation.LoadChatSince("hridoy@gmail.com", "mehrin@gmail.com", lastProcessedRowId);
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("message"));
                        // Update lastProcessedRowId to the ID of the current row
                        lastProcessedRowId = resultSet.getLong("id");
                    }

                    // Close the ResultSet after processing
                    resultSet.close();

                    // Wait for a certain amount of time before checking again
                    TimeUnit.SECONDS.sleep(10); // Adjust the delay time as needed
                }
                catch (Exception e){
                    System.out.println("ERROR");
                }
            }

        });
        chatload.start();



    }
}
