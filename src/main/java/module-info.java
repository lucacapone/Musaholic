module logic {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires java.sql;
    requires mysql.connector.java;



    opens logic.graphic_controller to javafx.fxml;
    exports logic.graphic_controller;

}