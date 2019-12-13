package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import worldofzuul.Game;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class DarkController {

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button Inventory;
    @FXML
    private ProgressBar credBar;
    @FXML
    private ImageView Dark;

    private boolean light;

    @FXML
    private ImageView GoOutsideBtn;

    Game game = Game.Instance();

    @FXML
    private void switchToExpo(MouseEvent event) throws IOException {
        App.setRoot("ExpoOut");
        game.goRoom(new Command(CommandWord.GO, "out"));

    }

    @FXML
    private void turnOffLight() throws IOException {
        if (light == false) {
            light = true;
            App.setRoot("Home");
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
