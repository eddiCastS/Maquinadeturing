module com.mscfceddisiytem.maquinadeturing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mscfceddisiytem.maquinadeturing to javafx.fxml;
    exports com.mscfceddisiytem.maquinadeturing;
}