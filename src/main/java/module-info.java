module org.example.datapirates {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;
    requires mysql.connector.j;
    requires javafx.media;


    opens org.example.datapirates.game to javafx.fxml;

    opens org.example.datapirates to javafx.fxml;
    exports org.example.datapirates;
    exports org.example.datapirates.game;

}