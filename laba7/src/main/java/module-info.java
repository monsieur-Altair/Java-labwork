module com.example.demo1 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;

    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    //requires mysql.connector.java;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;

}