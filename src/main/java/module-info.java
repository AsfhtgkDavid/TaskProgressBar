module com.david.progresstaskbar {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.david.progresstaskbar to javafx.fxml;
    exports com.david.progresstaskbar;
}
