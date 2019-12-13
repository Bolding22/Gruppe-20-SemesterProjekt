package com.mycompany.gameofknowlegdev2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import worldofzuul.*;

/**
 * FXML Controller class
 *
 * @author wbold
 */
public class MeetingController {

    @FXML
    private TextArea roomTextArea;
    @FXML
    private TextArea dialogTextArea;
    @FXML
    private Button endBtn;
    @FXML
    private ProgressBar credBar;

    Game game = Game.Instance();
    @FXML
    private Button inventoryBtn;
    @FXML
    private Button answerAbtn;
    @FXML
    private Button answerBbtn;
    @FXML
    private Button answerCbtn;
    @FXML
    private ImageView nationRep1;
    @FXML
    private ImageView nationRep2;
    @FXML
    private ImageView nationRep3;
    @FXML
    private TextArea dialogTextArea1;
    @FXML
    private Button closeBtn;

    @FXML
    private void switchToEnd(ActionEvent event) throws IOException {
        App.setRoot("End");
    }

    @FXML
    private void talkNR1(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "NR1")));
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B") + "\n" + "C: " + game.answerNPC("C"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        answerCbtn.setVisible(true);
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        answerCbtn.setDisable(false);
        nationRep1.setDisable(true);
    }

    @FXML
    private void talkNR2(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "NR2")));
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B") + "\n" + "C: " + game.answerNPC("C"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        answerCbtn.setVisible(true);
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        answerCbtn.setDisable(false);
        nationRep2.setDisable(true);
    }

    @FXML
    private void talkNR3(MouseEvent event) {
        dialogTextArea.setText(game.talkNpc(new Command(CommandWord.TALK, "NR3")));
        roomTextArea.setText("A: " + game.answerNPC("A") + "\n" + "B: " + game.answerNPC("B") + "\n" + "C: " + game.answerNPC("C"));
        answerAbtn.setVisible(true);
        answerBbtn.setVisible(true);
        answerCbtn.setVisible(true);
        answerAbtn.setDisable(false);
        answerBbtn.setDisable(false);
        answerCbtn.setDisable(false);
        nationRep3.setDisable(true);
    }

    @FXML
    private void printInventory(ActionEvent event) {
        roomTextArea.setText(game.printInventory());
    }

    @FXML
    private void printAnswerA(ActionEvent event) {
        dialogTextArea1.setVisible(true);
        closeBtn.setVisible(true);
        dialogTextArea1.setText(
                "To solve your problem, we would offer you the Photovoltaic panels.\n"
                + "These are small and can upgrade some of your existing technology\n"
                + "as well as i.e. provide enough energy to create a water heating\n"
                + "system , for every home among many other quality of life changes.\n"
                + "How it works practically is that the panels will be installed in\n"
                + "every home, into walls and windows, so that every home has their\n"
                + "own power supply. Which will be able to power their entire home.\n"
                + "The catch with these is that they are quite cheap compared to other\n"
                + "modern energy source, but of course the UN will also help financially.");
        if (dialogTextArea.getText().equals(game.talkNpc(new Command(CommandWord.TALK, "NR1")))) {
            game.getScore().setPoint(game.getScore().getPoint() + 1000);
        }
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        answerCbtn.setDisable(true);
    }

    @FXML
    private void printAnswerB(ActionEvent event) {
        dialogTextArea1.setVisible(true);
        closeBtn.setVisible(true);
        dialogTextArea1.setText(
                "I have one possible solution for both your problems. We will be\n"
                + "able to create both more jobs and the energy your village needs,\n"
                + "by building a solar panel farm. Those need maintenance, which is\n"
                + "a perfect opportunity to create jobs. Besides will the solar panel\n"
                + "farm generate power proportional with the area it covers and cur-\n"
                + "rently the average in the sub-Saharan region is 5-6 kWh/m2. Which means\n"
                + "that there is a lot of energy just ready to be harvested. This increase\n"
                + "in energy for your city will also make plenty more openings for\n"
                + "different kinds of jobs, that usually has a high energy requirement.");
        if (dialogTextArea.getText().equals(game.talkNpc(new Command(CommandWord.TALK, "NR2")))) {
            game.getScore().setPoint(game.getScore().getPoint() + 1000);
        }
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        answerCbtn.setDisable(true);
    }

    @FXML
    private void printAnswerC(ActionEvent event) {
        dialogTextArea1.setVisible(true);
        closeBtn.setVisible(true);
        dialogTextArea1.setText(
                "*You show him the solarpanelmodel*\n"
                + "“Green energy” means energy that is sustainable for the environ-\n"
                + "ment. An example of something that isn’t is the fossil energy that you\n"
                + "mentioned yourself. These are polluting our atmosphere with toxic\n"
                + "gasses, that induce climate changes in the world, which leads to\n"
                + "severe problems all around the globe . Therefore, it is important\n"
                + "that we deploy the green energy, which doesn’t pollute the atmos-\n"
                + "phere. Besides that, it is also a lot more efficient than the kerosene,\n"
                + "that you are currently using. So, what we can provide for you is\n"
                + "a future proof solution, that helps the overall condition for everyone\n"
                + "in your village, by either deploying small PV panels into homes or\n"
                + "larger silicon panel farms. Depending on your needs.");
        if (dialogTextArea.getText().equals(game.talkNpc(new Command(CommandWord.TALK, "NR3")))) {
            game.getScore().setPoint(game.getScore().getPoint() + 1000);
        }
        answerAbtn.setDisable(true);
        answerBbtn.setDisable(true);
        answerCbtn.setDisable(true);
    }

    @FXML
    private void getCredScore(MouseEvent event) {
        credBar.setProgress(game.getCredScore().getCredScore());
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        dialogTextArea1.setVisible(false);
        closeBtn.setVisible(false);
    }
}
