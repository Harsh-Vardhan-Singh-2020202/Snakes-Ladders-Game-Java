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

    static int count=0;

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
    boolean gameOver = false;

    private boolean ifPlayer1Turn(){
        return count%2==0;
    }
    private boolean ifPlayer2Turn(){
        return (count%2==1);
    }

    public void rollButtonClicked() {
        if (!gameOver) {
            if (ifPlayer1Turn()) {
                player1.glowPlayerToken();
                player2.dimPlayerToken();
                player1.rollDie(die);
            } else if (ifPlayer2Turn()) {
                player2.glowPlayerToken();
                player1.dimPlayerToken();
                player2.rollDie(die);
            }

            int diceFaceValue = die.getFaceValue();
            if (diceFaceValue == 1) {
                Image dice_1 = dice_image1.getImage();
                no_image.setImage(dice_1);
            } else if (diceFaceValue == 2) {
                Image dice_2 = dice_image2.getImage();
                no_image.setImage(dice_2);
            } else if (diceFaceValue == 3) {
                Image dice_3 = dice_image3.getImage();
                no_image.setImage(dice_3);
            } else if (diceFaceValue == 4) {
                Image dice_4 = dice_image4.getImage();
                no_image.setImage(dice_4);
            } else if (diceFaceValue == 5) {
                Image dice_5 = dice_image5.getImage();
                no_image.setImage(dice_5);
            } else if (diceFaceValue == 6) {
                Image dice_6 = dice_image6.getImage();
                no_image.setImage(dice_6);
            }

            if (ifPlayer1Turn()) {
                if (player1.isPlayerGameStarted()) {
                    player1.movePLayer(diceFaceValue, ladder, snake);
                    player1.dimPlayerToken();
                    player2.glowPlayerToken();
                }
            } else if (ifPlayer2Turn()) {
                if (player2.isPlayerGameStarted()) {
                    player2.movePLayer(diceFaceValue, ladder, snake);
                    player2.dimPlayerToken();
                    player1.glowPlayerToken();
                }
            }
            if ((ifPlayer1Turn()) && (!player1.isPlayerGameStarted()) && (diceFaceValue == 1)) {
                player1.setPlayerGameStarted(true);
                player1.setPlayerXLocation(55);
                player1.translateLocationOfPlayer();
                player1.dimPlayerToken();
                player2.glowPlayerToken();
            }
            else if ((ifPlayer2Turn()) && (!player2.isPlayerGameStarted()) && (diceFaceValue == 1)) {
                player2.setPlayerGameStarted(true);
                player2.setPlayerXLocation(55);
                player2.translateLocationOfPlayer();
                player2.dimPlayerToken();
                player1.glowPlayerToken();
            }

            gameOver = player1.isPlayerWon()||player2.isPlayerWon();
            if (gameOver){
                // Add code for Pop-up Window Here!
            }
            count++;
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
        player2.getPlayerText().setText(Controller.getPlayerNames()[1]);
//        player1.glowPlayerToken();
//        player2.dimPlayerToken();
//        rollButtonClicked();
    }

}