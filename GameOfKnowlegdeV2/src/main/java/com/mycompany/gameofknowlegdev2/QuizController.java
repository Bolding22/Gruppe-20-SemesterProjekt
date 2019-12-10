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
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class QuizController {

    Game game = Game.Instance();
    @FXML
    private Button goBackBtn;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ProgressBar credBar;
    @FXML
    private Button inventoryBtn;
    @FXML
    private Button answerAbtn;
    @FXML
    private Button answerBbtn;
    @FXML
    private ImageView talkQuiz;
    @FXML
    private Button nextQbtn;
    
    private int i = 0;
    
    @FXML
    private ImageView portalMeeting;

    @FXML
    private void switchToExpo(ActionEvent event) throws IOException {
        App.setRoot("Expo");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }
    
    @FXML
    private void switchToMeeting(MouseEvent event) throws IOException {
        App.setRoot("Meeting");
        game.goRoom(new Command(CommandWord.GO, "next"));
    }

    @FXML
    private void talk(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "Quizmaster")));
        roomTextArea.setText("A: " + game.answerNPC("A")+ "\n" + "B: " + game.answerNPC("B"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        nextQbtn.setVisible(true);
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
        if (i == 0 | i == 2){
            game.getCredScore().giveTwentyCred();
        }
        if (game.getCredScore().getCredScore() >= 0.75){
        roomTextArea.setText(game.answerNPC("A") 
                + "\n______________________________________"
                + "\nCongrats. You've exceeded 75% Credability."
                + "\nYou're now eligable to use the portal.");
        portalMeeting.setDisable(false);
        }
    }

    @FXML
    private void printAnswerB(ActionEvent event) {
        roomTextArea.setText(game.answerNPC("B"));
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        if (i == 1){
            game.getCredScore().giveTwentyCred();
        }
        if (game.getCredScore().getCredScore() >= 0.75){
        portalMeeting.setDisable(false);
        }
    }

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
        i += 1;
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "Quizmaster" + i)));
        roomTextArea.clear();
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B"));
        if (i == 2){
            nextQbtn.setDisable(true);
        }
    }
}
    