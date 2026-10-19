module com.example.elevator_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.elevator_2 to javafx.fxml;
    exports com.example.elevator_2;
}