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
public class InfoScreenController {

    @FXML
    private ImageView infoScrn;

    @FXML
    private void showNextScrn(MouseEvent event) throws IOException {
        App.setRoot("LetsGo");
    }

}