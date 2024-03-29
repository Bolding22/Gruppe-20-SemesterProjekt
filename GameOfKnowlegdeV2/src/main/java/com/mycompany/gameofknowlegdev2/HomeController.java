package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import worldofzuul.*;

public class HomeController {

    @FXML
    private ImageView switchPic;

    private boolean light = true;

    Game game = Game.Instance();

    @FXML
    private ImageView BackgroundPic;
    @FXML
    private ImageView GoBtn;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button Inventory;
    @FXML
    private ProgressBar credBar;

    @FXML
    private void switchToExpo(MouseEvent event) throws IOException {
        App.setRoot("ExpoOut");
        game.goRoom(new Command(CommandWord.GO, "out"));
    }

    @FXML
    private void turnOffLight() throws IOException {
        if (light == true) {
            light = false;
            App.setRoot("Dark");
            game.getScore().setPoint(100);
        }

    }

    @FXML
    private void printInventory(MouseEvent event) throws IOException {
        roomTextArea.setText(game.printInventory());

    }

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }
}
