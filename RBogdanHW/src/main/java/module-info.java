module com.example.rbogdanhw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rbogdanhw to javafx.fxml;
    exports com.example.rbogdanhw;
}