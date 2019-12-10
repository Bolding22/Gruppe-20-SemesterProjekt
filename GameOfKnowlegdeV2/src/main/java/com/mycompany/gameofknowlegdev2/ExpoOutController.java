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
import javafx.scene.layout.StackPane;
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
    private ImageView backBtn;
    @FXML
    private Button Inventory;
    @FXML
    private ProgressBar credBar;
    @FXML
    private ImageView posterUN;
    @FXML
    private ImageView enterExpo;
    @FXML
    private ImageView posterQuiz;
    @FXML
    private ImageView posterSolar;
    @FXML
    private ImageView posterUNBig;
    @FXML
    private ImageView posterQuizBig;
    @FXML
    private ImageView posterSolarBig;
    @FXML
    private Button closePoster;
    @FXML
    private StackPane posterPane;
    @FXML
    private ImageView expoOut;


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

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }

    @FXML
    private void showUNPoster(MouseEvent event) {
        posterPane.setVisible(true);
        posterUNBig.setVisible(true);
        closePoster.setVisible(true);
    }

    @FXML
    private void showQuizPoster(MouseEvent event) {
        posterPane.setVisible(true);
        posterQuizBig.setVisible(true);
        closePoster.setVisible(true);
    }

    @FXML
    private void showSolarPoster(MouseEvent event) {
        posterPane.setVisible(true);
        posterSolarBig.setVisible(true);
        closePoster.setVisible(true);
    }

    @FXML
    private void closePoster(ActionEvent event) {
        posterQuizBig.setVisible(false);
        posterSolarBig.setVisible(false);
        posterUNBig.setVisible(false);
        closePoster.setVisible(false);
        posterPane.setVisible(false);
    }
}

