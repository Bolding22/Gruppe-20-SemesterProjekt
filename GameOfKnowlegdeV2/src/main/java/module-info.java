module com.mycompany.gameofknowlegdev2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gameofknowlegdev2 to javafx.fxml;
    exports com.mycompany.gameofknowlegdev2;
}