package org.example.datapirates;

import org.example.datapirates.ServerBackend.NetworkConnection;

public class userSession {
    public static UserInfo userInfo;
    public static NetworkConnection nc;


    public static void setUserInfo(UserInfo userInfo) {
        userSession.userInfo = userInfo;
    }

    public static UserInfo getUserInfo() {
        return userInfo;
    }

    public static void setNc(NetworkConnection nc) {
        userSession.nc = nc;
    }



    public static NetworkConnection getNc() {
        return nc;
    }


}
