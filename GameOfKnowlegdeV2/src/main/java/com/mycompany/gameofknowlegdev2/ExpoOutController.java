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

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class ExpoOutController implements Initializable {

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView posterOne;
    @FXML
    private ImageView posterTwo;
    @FXML
    private ImageView posterThree;
    @FXML
    private Button enterBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showRoomText(KeyEvent event) {
    }

    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        App.setRoot("Home");
    }

    @FXML
    private void switchToExpoMain(ActionEvent event) throws IOException {
        App.setRoot("Expo");
    }
    
}
