module org.example.datapirates {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;


    opens org.example.datapirates to javafx.fxml;
    exports org.example.datapirates;
}