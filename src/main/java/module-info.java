module com.hw2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hw2 to javafx.fxml;
    exports com.hw2;
}
