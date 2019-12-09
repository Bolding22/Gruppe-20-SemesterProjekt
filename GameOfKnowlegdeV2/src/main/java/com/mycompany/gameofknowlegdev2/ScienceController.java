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
import javafx.scene.shape.Rectangle;
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class ScienceController {

    @FXML
    private Button goBackScience;

    Game game = Game.Instance();

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ImageView rick;
    @FXML
    private ProgressBar credBar;
    @FXML
    private Rectangle Solarpanel;
    @FXML
    private Button inventoryBtn;
    @FXML
    private Button answerAbtn;
    @FXML
    private Button answerBbtn;
    @FXML
    private ImageView jeff;

    @FXML
    private void switchToExpo(ActionEvent event) throws IOException {
        App.setRoot("Expo");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }

    @FXML
    private void pickUpItem(MouseEvent event) throws IOException {
        game.pickUpItem(new Command(CommandWord.GET, "Solarpanel"));
        roomTextArea.setText("You've picked up a Solarpanelmodel!");
        Solarpanel.setDisable(true);
    }

    @FXML
    private void talkRick(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "Rick")));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        rick.setDisable(true);

    }

    @FXML
    private void talkJeff(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "Jeff")));
        jeff.setDisable(true);

    }

    @FXML
    private void showRoomText(KeyEvent event) {
        roomTextArea.setText("Test");
    }

    @FXML
    private void printInventory(ActionEvent event) {
        roomTextArea.setText(game.printInventory());
    }

    @FXML
    private void printAnswerA(ActionEvent event) {
        roomTextArea.setText(game.answerNPC("A"));
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        game.getCredScore().giveFiveCred();
    }

    @FXML
    private void printAnswerB(ActionEvent event) {
        roomTextArea.setText(game.answerNPC("B"));
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
    }

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }
}
