package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class SnakeAndLadderGame {

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
    ImageView diceFaceImage;

    static int count=2;

    // Player's Information in the SnakeAndLadderGame
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
                player1.rollDie(die);
                die.setDiceFaceImage(die.getFaceValue());
                if (ifPlayer1Turn() && player1.isPlayerGameStarted()) {
                    player1.movePLayer(die.getFaceValue(), ladder, snake);

                }
                if ((ifPlayer1Turn()) && (!player1.isPlayerGameStarted()) && (die.getFaceValue() == 1)) {
                    player1.setPlayerGameStarted(true);
                    player1.setPlayerXLocation(55);
                    player1.translateLocationOfPlayer();
                }
                player1.dimPlayerToken();
                player2.glowPlayerToken();
            }

            else if (ifPlayer2Turn()) {
                player2.rollDie(die);
                die.setDiceFaceImage(die.getFaceValue());
                if (ifPlayer2Turn() && player2.isPlayerGameStarted()) {
                    player2.movePLayer(die.getFaceValue(), ladder, snake);
                }
                if ((ifPlayer2Turn()) && (!player2.isPlayerGameStarted()) && (die.getFaceValue() == 1)) {
                    player2.setPlayerGameStarted(true);
                    player2.setPlayerXLocation(55);
                    player2.translateLocationOfPlayer();
                }
                player2.dimPlayerToken();
                player1.glowPlayerToken();
            }

            gameOver = player1.isPlayerWon()||player2.isPlayerWon();
            if (gameOver){
                if (player1.isPlayerWon())
                    System.out.println("Player 1 Won");
                else
                    System.out.println("Player 2 Won");

                // ADD CODE FOR POP-UP WINDOW FOR THE WINNER HERE !!!
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
        die = new Die(6,diceFaceImage,dice_image1,dice_image2,dice_image3,dice_image4,dice_image5,dice_image6);

        player1.getPlayerText().setText(MainWindow.getPlayerNames()[0]);
        player2.getPlayerText().setText(MainWindow.getPlayerNames()[1]);
        count = 0;
        player1.glowPlayerToken();
        player2.dimPlayerToken();
    }

}