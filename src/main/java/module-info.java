module com.david.progresstaskbar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.david.progresstaskbar to javafx.fxml;
    exports com.david.progresstaskbar;
}