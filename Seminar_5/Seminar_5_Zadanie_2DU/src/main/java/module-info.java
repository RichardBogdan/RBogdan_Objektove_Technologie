module com.example.seminar_5_zadanie_2du {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar_5_zadanie_2du to javafx.fxml;
    exports com.example.seminar_5_zadanie_2du;
}