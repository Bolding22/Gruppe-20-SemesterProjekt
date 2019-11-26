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
import javafx.scene.control.TextArea;
import worldofzuul.*;
/**
 * FXML Controller class
 *
 * @author wbold
 */
public class MeetingController implements Initializable {

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button endBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToEnd(ActionEvent event) {
    }
    
}
