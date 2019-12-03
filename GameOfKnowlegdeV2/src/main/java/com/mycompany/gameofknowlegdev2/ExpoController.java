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
public class ExpoController {

    Game game = Game.Instance();
    @FXML
    private Button backBtn;
    @FXML
    private Button goBtnUN;
    @FXML
    private Button goBtnScience;
    @FXML
    private Button goBtnQuiz;
    @FXML
    private ImageView posterOne;
    @FXML
    private ImageView posterTwo;
    @FXML
    private ImageView posterThree;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    
    @FXML
    private void goBackBtn() throws IOException{
        App.setRoot("ExpoOut");
        game.goRoom(new Command(CommandWord.GO, "back"));
    }

    @FXML
   private void switchToScience(ActionEvent event) throws IOException{
       App.setRoot("Science");
       game.goRoom(new Command(CommandWord.GO, "area2"));
   }

    @FXML
    private void switchToQuiz(ActionEvent event) throws IOException {
        App.setRoot("Quiz");
        game.goRoom(new Command(CommandWord.GO, "area3"));
         
    }

    @FXML
    private void switchToUN(ActionEvent event) throws IOException {
        App.setRoot("UN");
        game.goRoom(new Command(CommandWord.GO, "area1"));
    }

}
