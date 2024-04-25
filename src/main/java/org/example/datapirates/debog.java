package org.example.datapirates;

import java.sql.ResultSet;
import java.sql.SQLException;

public class debog {
    public static void main(String[] args) {
        ResultSet chat;
        try {
            chat = dbOperation.LoadChat("hridoy@gmail.com", "mehrin@gmail.com");
            while (chat.next()) {
                System.out.println(chat.getString("SenderName")+" "+chat.getString("message"));
//                if(chat.getString("receiver").equals("mehrin@gmail.com")) {
//                    System.out.println(chat.getString("SenderName")+" "+chat.getString("message"));
//                }
//                else
//                {
//                    System.out.println(chat.getString("SenderName")+" "+chat.getString("message"));
//
//                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
