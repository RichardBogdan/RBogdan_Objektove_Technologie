module com.example.seminar_3_zadanie_2_du {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seminar_3_zadanie_2_du to javafx.fxml;
    exports com.example.seminar_3_zadanie_2_du;
}