module com.david.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.david.progresstaskbar;

    opens com.david.test to javafx.fxml;
    exports com.david.test;
}