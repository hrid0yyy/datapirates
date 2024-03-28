module org.example.datapirates {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.datapirates to javafx.fxml;
    exports org.example.datapirates;
}