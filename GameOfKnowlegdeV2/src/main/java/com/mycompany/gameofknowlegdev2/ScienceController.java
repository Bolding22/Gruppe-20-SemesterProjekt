package com.mycompany.gameofknowlegdev2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import worldofzuul.*;
/**
 * FXML Controller class
 *
 * @author wbold
 */
public class ScienceController implements Pickupable{

    @FXML
    private Button goBackScience;
    
    Game game = new Game();
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ImageView rickClick;

    @FXML
    private void switchToExpo(ActionEvent event) throws IOException {
        App.setRoot("Expo");
    }

    @FXML
    private void talk(MouseEvent event) {
        this.dialogTextArea.setText("Hi! My name is Rick\n"
                + "I have some amazing things to tell you about solar power!\n"
                + "First off all I would like to say that I believe that solar power is the future for all of us\n"
                + "BUT... That is why I am here today! To give you all the knowledge you need to understand the basics of solar power.\n"
                + "There are two types of solar panels that i want to tell you about today\n"
                + "The first one is photovoltaic solar panels or PV-panels for us nerds. These panels are small, thin and lightweight.\n"
                + "These cells turn light into electricity and even works in low light.\n"
                + "The downside to these panels is that they can only power smaller devices or be used for slower charging\n"
                + "Then there are the bigger and bulkier silicon solar panels that can power cities or even whole countries\n"
                + "But of course, these have a downside as well. They are way more expensive and they are very large and non-flexible\n"
                + "In the ideal world we would make the smaller PV-panels better and more powerful or make the silicon panels smaller and more flexible\n"
                + "I really hope you learned something and want to participate in the quiz! Have a great day!");
    }

    private void pickUpItem(MouseEvent event) {
        Command command = new Command(CommandWord.GET, "SolarPanel");
        game.getItem(command);
    }

    @FXML
    private void showRoomText(KeyEvent event) {
        roomTextArea.setText("Test");
    }
   
    }    
    
