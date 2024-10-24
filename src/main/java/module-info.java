module ch.iet_gibb.heatcalculatorfx.application {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.iet_gibb.heatcalculatorfx.application to javafx.fxml;
    exports ch.iet_gibb.heatcalculatorfx.application;
}