module com.huwng05.quizzapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires java.desktop;

    opens com.huwng05.quizzapp to javafx.fxml;
    exports com.huwng05.quizzapp;
}