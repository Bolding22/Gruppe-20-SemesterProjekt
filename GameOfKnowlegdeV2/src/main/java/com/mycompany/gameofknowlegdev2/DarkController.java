/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import worldofzuul.Game;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class DarkController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private ImageView switchPic;
    
    private boolean light;
    
    @FXML
    private Button GoOutsideBtn;
    
    private Game game = new Game();

    @FXML
    private void switchToExpo() throws IOException {
        App.setRoot("Expo");
        game.goRoom(new Command(CommandWord.GO, "out"));
        
    }
    @FXML
    private void turnOffLight() throws IOException {
        if(light == true){
        System.out.println("Light turned Off.");
        light = false;
        App.setRoot("Dark");
        } else if(light == false) {
            System.out.println("Light turned On.");
            light = true;
            App.setRoot("Home");
        }
    }
}
