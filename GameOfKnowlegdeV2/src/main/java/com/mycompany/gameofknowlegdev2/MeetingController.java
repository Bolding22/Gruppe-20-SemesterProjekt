/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class MeetingController {

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button endBtn;
    @FXML
    private ProgressBar credBar;

    Game game = Game.Instance();
    @FXML
    private Button inventoryBtn;
    @FXML
    private Button answerAbtn;
    @FXML
    private Button answerBbtn;
    @FXML
    private Button answerCbtn;
    @FXML
    private ImageView nationRep1;
    @FXML
    private ImageView nationRep2;
    @FXML
    private ImageView nationRep3;

    @FXML
    private void switchToEnd(ActionEvent event) {
        game.getScore().getPoint();
        game.getScore().calcScore(game.getCredScore().getCredScore());
        roomTextArea.setText(String.valueOf(game.getScore().getScore()));
    }

    @FXML
    private void talkNR1(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "NR1")));
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B") + "\n" + "C: " + game.answerNPC("C"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        answerCbtn.setVisible(true);
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        answerCbtn.setDisable(false);
        nationRep1.setDisable(true);
    }

    @FXML
    private void talkNR2(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "NR2")));
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B") + "\n" + "C: " + game.answerNPC("C"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        answerCbtn.setVisible(true);
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        answerCbtn.setDisable(false);
        nationRep2.setDisable(true);
    }

    @FXML
    private void talkNR3(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "NR3")));
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B") + "\n" + "C: " + game.answerNPC("C"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        answerCbtn.setVisible(true);
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        answerCbtn.setDisable(false);
        nationRep3.setDisable(true);
    }

    @FXML
    private void printInventory(ActionEvent event) {
        roomTextArea.setText(game.printInventory());
    }

    @FXML
    private void printAnswerA(ActionEvent event) {
        roomTextArea.setText(game.answerNPC("A"));
        if (dialogTextArea.getText().equals(game.talkNpc(new Command(CommandWord.TALK, "NR1")))) {
            game.getScore().setPoint(game.getScore().getPoint() + 1000);
        }
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        answerCbtn.setDisable(true);
    }

    @FXML
    private void printAnswerB(ActionEvent event) {
        roomTextArea.setText(game.answerNPC("B"));
        if (dialogTextArea.getText().equals(game.talkNpc(new Command(CommandWord.TALK, "NR2")))) {
            game.getScore().setPoint(game.getScore().getPoint() + 1000);
        }
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        answerCbtn.setDisable(true);
    }

    @FXML
    private void printAnswerC(ActionEvent event) {
        roomTextArea.setText(game.answerNPC("C"));
        if (dialogTextArea.getText().equals(game.talkNpc(new Command(CommandWord.TALK, "NR3")))) {
            game.getScore().setPoint(game.getScore().getPoint() + 1000);
        }
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        answerCbtn.setDisable(true);
    }

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }
}
