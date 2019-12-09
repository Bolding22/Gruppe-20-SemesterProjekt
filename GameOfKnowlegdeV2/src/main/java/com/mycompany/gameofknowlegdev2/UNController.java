/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class UNController implements Pickupable {

    Game game = Game.Instance();
    @FXML
    private Button backBtnUN;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ImageView talkUN;
    @FXML
    private ProgressBar credBar;
    @FXML
    private Button inventoryBtn;
    @FXML
    private Button answerAbtn;
    @FXML
    private Button answerBbtn;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private void switchToExpo(ActionEvent event) throws IOException {
        App.setRoot("Expo");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }

    @FXML
    private void talk(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "Villy")));
        roomTextArea.setText("A: " + game.answerNPC("A")+ "\n" + "B: " + game.answerNPC("B"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        talkUN.setDisable(true);
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
