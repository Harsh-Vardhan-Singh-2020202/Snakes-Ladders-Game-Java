package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Player {
    @FXML
    private ImageView playerToken;
    @FXML
    private ImageView playerPicture;
    @FXML
    private Text playerText;

    private double playerXLocation = 0;
    private double playerYLocation = 0;
    private int playerScore = 0;
    private boolean playerGameStarted = false;

    public Player(ImageView playerToken, ImageView playerPicture, Text playerText) {
        this.playerToken = playerToken;
        this.playerPicture = playerPicture;
        this.playerText = playerText;
    }

    @FXML
    public void movePLayer(int byAmount){
        for (int i=1; i<=byAmount; i++){
            if ((playerYLocation==0) && (playerXLocation>=55 && playerXLocation<=550)){
                playerXLocation+=55;
                translateLocationOfPlayer(1000);
                if ((playerXLocation==220) && (playerYLocation==0)){
                    playerXLocation = 220 + 55;
                    playerYLocation = -110;
                    translateLocationOfPlayer(1500);
                }
                else if ((playerXLocation==550) && (playerYLocation==0)){
                    playerYLocation = -55;
                    translateLocationOfPlayer(1500);
                }
            }

            else if ((playerYLocation==-55) && (playerXLocation>=55 && playerXLocation<=550)){
                playerXLocation-=55;
                translateLocationOfPlayer(1000);
                if ((playerYLocation==-55) && (playerXLocation==440)){
                    playerXLocation = 440 - 110;
                    playerYLocation = -220;
                    translateLocationOfPlayer(1500);
                }
                else if ((playerYLocation==-55) && (playerXLocation==55)){
                    playerYLocation = -110;
                    translateLocationOfPlayer(1500);
                }
            }
        }
    }

    @FXML
    void translateLocationOfPlayer(int seconds){
        TranslateTransition animate = new TranslateTransition(Duration.millis(seconds), playerToken);
        animate.setToX(playerXLocation);
        animate.setToY(playerYLocation);
        animate.setAutoReverse(false);
        animate.play();
    }

    public ImageView getPlayerToken() {
        return playerToken;
    }

    public double getPlayerXLocation() {
        return playerXLocation;
    }

    public void setPlayerXLocation(double playerXLocation) {
        this.playerXLocation = playerXLocation;
    }

    public double getPlayerYLocation() {
        return playerYLocation;
    }

    public void setPlayerYLocation(double playerYLocation) {
        this.playerYLocation = playerYLocation;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public boolean isPlayerGameStarted() {
        return playerGameStarted;
    }

    public void setPlayerGameStarted(boolean playerGameStarted) {
        this.playerGameStarted = playerGameStarted;
    }

    public void setPlayerToken(ImageView playerToken) {
        this.playerToken = playerToken;
    }

    public ImageView getPlayerPicture() {
        return playerPicture;
    }

    public void setPlayerPicture(ImageView playerPicture) {
        this.playerPicture = playerPicture;
    }

    public Text getPlayerText() {
        return playerText;
    }

    public void setPlayerText(Text playerText) {
        this.playerText = playerText;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerToken=" + playerToken +
                ", playerPicture=" + playerPicture +
                ", playerText=" + playerText +
                ", playerXLocation=" + playerXLocation +
                ", playerYLocation=" + playerYLocation +
                ", playerScore=" + playerScore +
                ", playerGameStarted=" + playerGameStarted +
                '}';
    }
}
