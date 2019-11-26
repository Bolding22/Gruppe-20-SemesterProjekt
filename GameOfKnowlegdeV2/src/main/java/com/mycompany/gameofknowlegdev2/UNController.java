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
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class UNController implements Pickupable {

    @FXML
    private Button backBtnUN;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private ImageView talkUN;
    @FXML
    private Tooltip tooltipTest;


    @FXML
    private void switchToExpo(ActionEvent event) throws IOException {
        App.setRoot("Expo");
    }

    @FXML
    private void talk(MouseEvent event) {
        dialogTextArea.setText("Hello there!\n"
                + "My name is Villy and I’m here to represent The UN and tell you a bit about our global goals for sustainable development.\n"
                + "There are 17 global goals which covers everything from ending poverty to making sure everyone has sustainable energy.\n"
                + "And you might be surprised to hear this.\n"
                + "But all 193 members of The UN has agreed to work towards making these goals before 2030.\n"
                + "Today I would like to give you some extra knowledge on the 7th goal.\n"
                + "Goal number 7 is all about affordable and clean energy and making sure that everyone has ascess to it.\n"
                + "The overall goal is to get rid of the energy produced by fossil fuels and replace them with renewable energy like solar power!\n"
                + "I even heard that there is a guy here today that can tell you everything about solar energy! You should go see him!\n"
                + "Have a nice day!");
    }

    @FXML
    private void backTooltip(WindowEvent event) {
    }
    
}
