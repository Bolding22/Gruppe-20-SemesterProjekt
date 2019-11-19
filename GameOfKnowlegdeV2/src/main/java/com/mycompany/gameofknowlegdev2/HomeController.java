package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import worldofzuul.*;


public class HomeController {
    @FXML
    private ImageView switchPic;
    
    private boolean light = true;
    
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
