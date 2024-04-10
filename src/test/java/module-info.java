module com.david.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.david.test to javafx.fxml;
    exports com.david.test;
}