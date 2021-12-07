package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

public class Game {

    @FXML
    ImageView dice_image1;
    @FXML
    ImageView dice_image2;
    @FXML
    ImageView dice_image3;
    @FXML
    ImageView dice_image4;
    @FXML
    ImageView dice_image5;
    @FXML
    ImageView dice_image6;

    @FXML
    Button roll_button;
    @FXML
    ImageView no_image;

    int count=0;

    // Player's Information in the Game
    @FXML
    ImageView player2Picture;
    @FXML
    ImageView player1Picture;
    @FXML
    Text player1Text;
    @FXML
    Text player2Text;
    @FXML
    private ImageView player1Token;
    @FXML
    private ImageView player2Token;


    // Player Instantiation
    Player player1 ;
    Player player2 ;
    Ladder ladder;
    Snake snake;
    Die die;


    private boolean ifPlayer1Turn(){
        return count%2==1;
    }
    private boolean ifPlayer2Turn(){
        return (count!=0) && (count%2==0);
    }

    public void rollButtonClicked(ActionEvent event) {
        player1.getPlayerText().setText(Controller.getPlayerNames()[0]);
        player1.getPlayerText().setOpacity(1);
        player2.getPlayerText().setText(Controller.getPlayerNames()[1]);
        player2.getPlayerText().setOpacity(1);
        count++;

        if(ifPlayer1Turn()) {
            player1.getPlayerText().setFill(Color.WHITE);
            Effect glow = new Glow(1.0);
            player1.getPlayerText().setEffect(glow);
            player1.getPlayerText().setUnderline(true);
            glow = new Glow(1);
            player1.getPlayerPicture().setEffect(glow);
            glow = new Glow(0);
            player2.getPlayerText().setFill(Color.BLACK);
            player2.getPlayerText().setEffect(glow);
            player2.getPlayerText().setUnderline(false);
            player2.getPlayerPicture().setEffect(glow);
        }
        else {
            player2.getPlayerText().setFill(Color.WHITE);
            Effect glow = new Glow(1.0);
            player2.getPlayerText().setUnderline(true);
            player2.getPlayerText().setEffect(glow);
            glow = new Glow(1);
            player2.getPlayerPicture().setEffect(glow);
            glow = new Glow(0);
            player1.getPlayerText().setEffect(glow);
            player1.getPlayerText().setUnderline(false);
            player1.getPlayerText().setFill(Color.BLACK);
            player1.getPlayerPicture().setEffect(glow);
        }

        die.roll();
        int diceFaceValue = die.getFaceValue();
        if(diceFaceValue==1) {
            Image dice_1 =dice_image1.getImage();
            no_image.setImage(dice_1);
        }
        else if(diceFaceValue==2) {
            Image dice_2 =dice_image2.getImage();
            no_image.setImage(dice_2);
        }
        else if(diceFaceValue==3) {
            Image dice_3 =dice_image3.getImage();
            no_image.setImage(dice_3);
        }
        else if(diceFaceValue==4) {
            Image dice_4 =dice_image4.getImage();
            no_image.setImage(dice_4);
        }
        else if(diceFaceValue==5) {
            Image dice_5 =dice_image5.getImage();
            no_image.setImage(dice_5);
        }
        else if(diceFaceValue==6) {
            Image dice_6 =dice_image6.getImage();
            no_image.setImage(dice_6);
        }

        if (ifPlayer1Turn()){
            if (player1.isPlayerGameStarted()){
                player1.movePLayer(diceFaceValue,ladder,snake);
            }
        }
        else if (ifPlayer2Turn()){
            if (player2.isPlayerGameStarted()){
                player2.movePLayer(diceFaceValue,ladder,snake);
            }
        }
        if ((ifPlayer1Turn()) && (!player1.isPlayerGameStarted()) && (diceFaceValue==1)) {
            player1.setPlayerGameStarted(true);
            player1.setPlayerXLocation(55);
            player1.translateLocationOfPlayer();
        }
        else if ((ifPlayer2Turn()) && (!player2.isPlayerGameStarted()) && (diceFaceValue==1)) {
            player2.setPlayerGameStarted(true);
            player2.setPlayerXLocation(55);
            player2.translateLocationOfPlayer();
        }
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.8);
        roll_button.setEffect(glow);
    }

    public void removeButtonSkin() {
        Glow glow = new Glow();
        glow.setLevel(0);
        roll_button.setEffect(glow);
    }

    @FXML
    public void initialize() {
        // Instantiate Player 1 and 2;
        player1 = new Player(player1Token, player1Picture, player1Text);
        player2 = new Player(player2Token, player2Picture, player2Text);
        ladder = new Ladder();
        snake = new Snake();
        die = new Die();

        player1.getPlayerText().setText(Controller.getPlayerNames()[0]);
        player1.getPlayerText().setOpacity(1);
        player2.getPlayerText().setText(Controller.getPlayerNames()[1]);
        player2.getPlayerText().setOpacity(1);
        player1.getPlayerText().setFill(Color.WHITE);
        Effect glow = new Glow(1.0);
        player1.getPlayerText().setEffect(glow);
        player1.getPlayerText().setUnderline(true);
        glow = new Glow(0.7);
        player1.getPlayerPicture().setEffect(glow);
        glow = new Glow(0);
        player2.getPlayerText().setFill(Color.BLACK);
        player2.getPlayerText().setEffect(glow);
        player2.getPlayerText().setUnderline(false);
        player2.getPlayerPicture().setEffect(glow);
    }




    // used as helper
    @FXML
    private Label labelLocationXandY;
    private double targetX, targetY;
    private double player1X = 0;
    private double player1Y = 0;
    private double player2X = 0;
    private double player2Y = 0;

}