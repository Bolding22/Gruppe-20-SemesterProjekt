package com.mycompany.gameofknowlegdev2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import worldofzuul.Game;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class ExpoOutController{

    Game game = Game.Instance();
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView posterOne;
    @FXML
    private ImageView posterTwo;
    @FXML
    private ImageView posterThree;
    @FXML
    private Button enterBtn;
    @FXML
    private Button Inventory;
    @FXML
    private ProgressBar credBar;


    @FXML
    private void showRoomText(KeyEvent event) {
    }

    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        App.setRoot("Home");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }

    @FXML
    private void switchToExpoMain(ActionEvent event) throws IOException {
        App.setRoot("Expo");
        game.goRoom(new Command(CommandWord.GO, "inside"));
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

