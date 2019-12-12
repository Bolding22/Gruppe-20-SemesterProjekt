/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import worldofzuul.Game;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class EndController {
    
    Game game = Game.Instance();
    
    @FXML
    private Button scoreBtn;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button quitBtn;
    
    @FXML
    private void showScore(ActionEvent event) {
        game.getScore().getPoint();
        game.getScore().calcScore(game.getCredScore().getCredScore());
        scoreLabel.setText(String.valueOf((int) game.getScore().getScore()) + "/3100");
    }
    
    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
        
    }
    
}
