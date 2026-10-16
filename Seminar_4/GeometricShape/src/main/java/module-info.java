module com.example.geometricshape {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometricshape to javafx.fxml;
    exports com.example.geometricshape;
}