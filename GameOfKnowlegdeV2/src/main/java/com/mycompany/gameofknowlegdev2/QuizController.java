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
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class QuizController{

    @FXML
    private Button goBackBtn;
    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;

   

    @FXML
    private void switchToExpo(ActionEvent event) throws IOException {
        App.setRoot("Expo");
    }
    
}
