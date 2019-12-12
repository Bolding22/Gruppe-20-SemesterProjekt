/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private void showScore(ActionEvent event) {
        game.getScore().getPoint();
        game.getScore().calcScore(game.getCredScore().getCredScore());
        scoreLabel.setText(String.valueOf(game.getScore().getScore()));
    }
    
}
