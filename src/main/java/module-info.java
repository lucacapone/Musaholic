module logic {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires java.sql;
    requires mysql.connector.java;



    opens logic.graphic_controller to javafx.fxml;
    exports logic.graphic_controller;
    exports logic.bean;
    exports logic.controller;
    exports logic.exception;
    exports logic.dao;
    exports logic.model;
    exports logic.boundary;






}