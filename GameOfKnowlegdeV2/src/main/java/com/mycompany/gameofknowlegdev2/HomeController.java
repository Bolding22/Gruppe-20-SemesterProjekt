package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import worldofzuul.*;

public class HomeController {

    @FXML
    private ImageView switchPic;

    private boolean light = true;

    private Game game = new Game();
    @FXML
    private ImageView BackgroundPic;
    @FXML
    private Button GoBtn;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;

    @FXML
    private void switchToExpo() throws IOException {
        App.setRoot("ExpoOut");
    }

    @FXML
    private void turnOffLight() throws IOException {
        if (light == true) {
            light = false;
            App.setRoot("Dark");
            System.out.println("Light turned Off.");
        }
    }

}
