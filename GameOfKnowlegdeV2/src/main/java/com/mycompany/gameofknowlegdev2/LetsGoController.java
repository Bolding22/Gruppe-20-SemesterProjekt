package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author wbold
 */
public class LetsGoController {


    @FXML
    private ImageView letGoScrn;
    @FXML
    private ImageView goArrow;
    
    @FXML
    private void showNextScreen(MouseEvent event) throws IOException {
        App.setRoot("Home");
    }

}
