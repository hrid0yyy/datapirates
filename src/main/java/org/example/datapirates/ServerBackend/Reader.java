package org.example.datapirates.ServerBackend;


public class Reader implements Runnable{
    public NetworkConnection netConnection;
    String msg="";
    public static boolean check = false;
    public Reader(NetworkConnection nc){
        netConnection=nc;
    }
    public void setMessage(String msg){
        this.msg=msg;
    }
    public String getMessage() {
        if(msg!=null)
            return msg;
        else return "";
    }


    @Override
    public void run() {
        while(true){
            String msg;
            Object obj=netConnection.read();
            msg = (String) obj;
            if(!getMessage().equals(msg));
            {
                setMessage(msg);
                check = false;
            }

        }
    }

}