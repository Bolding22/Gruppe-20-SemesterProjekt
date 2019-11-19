package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;

public class ExpoController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Home");
    }
}