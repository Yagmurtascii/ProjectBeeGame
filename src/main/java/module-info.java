module com.example.projectbeegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectbeegame to javafx.fxml;
    exports com.example.projectbeegame;
}