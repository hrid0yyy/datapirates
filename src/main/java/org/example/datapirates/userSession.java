package org.example.datapirates;

import org.example.datapirates.ServerBackend.NetworkConnection;

public class userSession {
    public static String userMail;
    public static NetworkConnection nc;

    public static void setNc(NetworkConnection nc) {
        userSession.nc = nc;
    }

    public static void setUserMail(String usermMail) {
        userSession.userMail = usermMail;
    }

    public static NetworkConnection getNc() {
        return nc;
    }

    public static String getUserMail() {
        return userMail;
    }
}
