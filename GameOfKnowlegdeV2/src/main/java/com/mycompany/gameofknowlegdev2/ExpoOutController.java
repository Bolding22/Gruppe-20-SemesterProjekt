package com.mycompany.gameofknowlegdev2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class ExpoOutController implements Initializable {

    Game game = Game.Instance();
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ImageView backBtn;
    @FXML
    private Button goBtnScience;
    @FXML
    private ImageView posterOne;
    @FXML
    private ImageView posterTwo;
    @FXML
    private ImageView posterThree;
    @FXML
    private ImageView enterExpo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showRoomText(KeyEvent event) {
    }

    @FXML
    private void switchToHome(MouseEvent event) throws IOException {
        App.setRoot("Home");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }

    @FXML
    private void switchToExpoMain(MouseEvent event) throws IOException {
        App.setRoot("Expo");
        game.goRoom(new Command(CommandWord.GO, "inside"));
    }
    
    @FXML
    private void printInventory(MouseEvent event) throws IOException{
       game.printInventory();
    
}
}

