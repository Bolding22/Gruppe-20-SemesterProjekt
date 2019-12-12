/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;
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
public class ExpoController {

    Game game = Game.Instance();
    @FXML
    private ImageView backBtn;
    @FXML
    private ImageView goBtnUN;
    @FXML
    private ImageView goBtnScience;
    @FXML
    private ImageView goBtnQuiz;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ProgressBar credBar;
    @FXML
    private ImageView ticTacToeIV;

    @FXML
    private void goBackBtn(MouseEvent event) throws IOException {
        App.setRoot("ExpoOut");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }

    @FXML
    private void switchToScience(MouseEvent event) throws IOException {
        App.setRoot("Science");
        game.goRoom(new Command(CommandWord.GO, "area2"));
    }

    @FXML
    private void switchToQuiz(MouseEvent event) throws IOException {
        App.setRoot("Quiz");
        game.goRoom(new Command(CommandWord.GO, "area3"));

    }

    @FXML
    private void switchToUN(MouseEvent event) throws IOException {
        App.setRoot("UN");
        game.goRoom(new Command(CommandWord.GO, "area1"));
    }

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }

    @FXML
    private void printInventory(MouseEvent event) throws IOException {
        roomTextArea.setText(game.printInventory());

    }

    @FXML
    private void printTicTacToe(MouseEvent event) throws IOException {
        roomTextArea.setText("Quit playing games already. Let's get on with\n"
                + "the important stuff.");
    }

}
