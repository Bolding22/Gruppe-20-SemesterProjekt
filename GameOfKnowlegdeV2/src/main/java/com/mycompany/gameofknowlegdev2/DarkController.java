/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Button Inventory;
    @FXML
    private ProgressBar credBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

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
            System.out.println("Light turned On.");
        }
    }

    public void setRoomTextArea(String s) {
        this.roomTextArea.setText(s);
    }
    
    @FXML
    private void printInventory(MouseEvent event) throws IOException{
       game.printInventory();
}

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }
}
