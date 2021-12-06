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

    @FXML
    private boolean ifPlayer1Turn(){
        return count%2==0;
    }

    public void btnROLLclicked(ActionEvent event) throws IOException
    {
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
            glow = new Glow(0.7);
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
            glow = new Glow(0.7);
            player2.getPlayerPicture().setEffect(glow);
            glow = new Glow(0);
            player1.getPlayerText().setEffect(glow);
            player1.getPlayerText().setUnderline(false);
            player1.getPlayerText().setFill(Color.BLACK);
            player1.getPlayerPicture().setEffect(glow);
        }

        Random rand = new Random();
        int rand_int1 = rand.nextInt(6);
        if(rand_int1==0)
        {
            Image dice_1 =dice_image1.getImage();
            no_image.setImage(dice_1);
        }
        else if(rand_int1==1)
        {
            Image dice_2 =dice_image2.getImage();
            no_image.setImage(dice_2);
        }
        else if(rand_int1==2)
        {
            Image dice_3 =dice_image3.getImage();
            no_image.setImage(dice_3);
        }
        else if(rand_int1==3)
        {
            Image dice_4 =dice_image4.getImage();
            no_image.setImage(dice_4);
        }
        else if(rand_int1==4)
        {
            Image dice_5 =dice_image5.getImage();
            no_image.setImage(dice_5);
        }
        else if(rand_int1==5)
        {
            Image dice_6 =dice_image6.getImage();
            no_image.setImage(dice_6);
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
    public void initialize()
    {
        String name_1 = Controller.getPlayerNames()[0];
        String name_2 = Controller.getPlayerNames()[1];

        // Instantiate Player 1 and 2;
        player1 = new Player(player1Token, player1Picture, player1Text);
        player2 = new Player(player2Token, player2Picture, player2Text);

        player1.getPlayerText().setText(name_1);
        player1.getPlayerText().setOpacity(1);
        player2.getPlayerText().setText(name_2);
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

        // remove this line below later
        player1.setPlayerXLocation(55);
    }




    // used as helper
    @FXML
    private Label labelLocationXandY;
    private double targetX, targetY;
    private double player1X = 0;
    private double player1Y = 0;
    private double player2X = 0;
    private double player2Y = 0;


    @FXML
    void translateLocationOfPlayer(double amountByX, double amountByY, ImageView player){
        TranslateTransition animate = new TranslateTransition(Duration.millis(800), player);
        animate.setToX(amountByX);
        animate.setToY(amountByY);
        animate.setAutoReverse(false);
        animate.play();
    }

    @FXML
    void getLocationAndSetLocationOfButton(MouseEvent event) {
        targetX = event.getSceneX();
        targetY = event.getSceneY();
        System.out.println("Target : "+targetX+",  "+targetY);

//        labelLocationXandY.setOpacity(1);
//        labelLocationXandY.setText("X="+targetX+", Y="+targetY);

        //player1X += 55;
        //player1.setPlayerXLocation(player1.getPlayerXLocation()+55);
        player1.movePLayer(1);
        //player1.translateLocationOfPlayer();
        //translateLocationOfPlayer(player1X,player1Y,player1Token);


    }
}