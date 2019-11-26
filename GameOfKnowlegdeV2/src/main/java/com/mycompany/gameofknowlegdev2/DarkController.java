/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import worldofzuul.Game;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class DarkController implements Initializable {

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean light;

    @FXML
    private Button GoOutsideBtn;

    private Game game = new Game();

    @FXML
    private void switchToExpo() throws IOException {
        App.setRoot("ExpoOut");
        game.goRoom(new Command(CommandWord.GO, "out"));

    }

    @FXML
    private void turnOffLight() throws IOException {
        if (light == false) {
            light = true;
            App.setRoot("Home");
            System.out.println("Light turned On.");
        }
    }

    @FXML
    public void setRoomTextArea(String s) {
        this.roomTextArea.setText(s);
    }
}
