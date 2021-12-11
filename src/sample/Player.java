package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Player {
    @FXML
    private ImageView playerToken;
    @FXML
    private ImageView playerPicture;
    @FXML
    private Text playerText;

    private String name;
    private double playerXLocation = 0;
    private double playerYLocation = 0;
    private boolean playerGameStarted = false;
    private boolean playerWon = false;

    public Player(ImageView playerToken, ImageView playerPicture, Text playerText) {
        this.playerToken = playerToken;
        this.playerPicture = playerPicture;
        this.playerText = playerText;
    }

    @FXML
    public void movePLayer(int byAmount, Ladder ladder, Snake snake){
        double initialXPosition = playerXLocation;

        for (int i=1; i<=byAmount; i++){

            if ((playerYLocation==0) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerXLocation==550) && (playerYLocation==0)){
                    playerYLocation = -55;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation+=55;
                    translateLocationOfPlayer();
                }
                if ((playerXLocation==220) && (playerYLocation==0) && (i==byAmount)){
                    ladder.movePlayerUp(this, 275,-110);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-55) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-55) && (playerXLocation==55)){
                    playerYLocation = -110;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation -= 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-55) && (playerXLocation==440) && (i==byAmount)){
                    ladder.movePlayerUp(this,330,-220);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-110) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-110) && (playerXLocation==550)){
                    playerYLocation = -165;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation += 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-110) && (playerXLocation==385) && (i==byAmount)){
                    snake.bitePlayer(this,275,0);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-165) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-165) && (playerXLocation==55) && (i==byAmount) && (((initialXPosition-55)/55)==byAmount)){
                    snake.bitePlayer(this,165,0);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-165) && (playerXLocation==55)){
                    playerYLocation = -220;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation -= 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-165) && (playerXLocation==440) && (i==byAmount)){
                    ladder.movePlayerUp(this,495,-220);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-165) && (playerXLocation==55) && (i==byAmount) && (((initialXPosition-55)/55)==byAmount)){
                    snake.bitePlayer(this,165,0);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-220) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-220) && (playerXLocation==550) && (i==byAmount) && (((550-initialXPosition)/55)==byAmount)){
                    ladder.movePlayerUp(this,495,-330);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-220) && (playerXLocation==550)){
                    playerYLocation = -275;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation += 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-220) && (playerXLocation==110) && (i==byAmount)){
                    ladder.movePlayerUp(this,165,-330);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-220) && (playerXLocation==550) && (i==byAmount) && (((550-initialXPosition)/55)==byAmount)){
                    ladder.movePlayerUp(this,495,-330);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-220) && (playerXLocation==165) && (i==byAmount)){
                    snake.bitePlayer(this,165,-55);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-275) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-275) && (playerXLocation==55)){
                    playerYLocation = -330;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation -= 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-275) && (playerXLocation==385) && (i==byAmount)){
                    snake.bitePlayer(this,550,-165);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-330) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-330) && (playerXLocation==550)){
                    playerYLocation = -385;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation += 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-330) && (playerXLocation==330) && (i==byAmount)){
                    snake.bitePlayer(this,275,-220);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-330) && (playerXLocation==110) && (i==byAmount)){
                    ladder.movePlayerUp(this,55,-440);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-385) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-385) && (playerXLocation==55)){
                    playerYLocation = -440;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation -= 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-385) && (playerXLocation==275) && (i==byAmount)){
                    snake.bitePlayer(this,165,-275);
                    translateLocationOfPlayer();
                }
                else if ((playerYLocation==-385) && (playerXLocation==385) && (i==byAmount)){
                    ladder.movePlayerUp(this,495,-495);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation==-440) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-440) && (playerXLocation==550)){
                    playerYLocation = -495;
                    translateLocationOfPlayer();
                }
                else {
                    playerXLocation += 55;
                    translateLocationOfPlayer();
                }
                if ((playerYLocation==-440) && (playerXLocation==495) && (i==byAmount)){
                    snake.bitePlayer(this,440,-275);
                    translateLocationOfPlayer();
                }
            }

            else if ((playerYLocation == -495) && (playerXLocation >= 385 && playerXLocation <= 550)) {
                playerXLocation -= 55;
                translateLocationOfPlayer();
            }
            else if ((playerYLocation == -495) && (playerXLocation >= 55 && playerXLocation <= 385) && ((byAmount*55)<=(initialXPosition-55))) {
                playerXLocation -= 55;
                translateLocationOfPlayer();
                if ((playerYLocation == -495) && (playerXLocation == 55) && (i == byAmount) && (((initialXPosition-55)/55)==byAmount)) {
                    playerWon = true;
                    System.out.println("Won...");
                    translateLocationOfPlayer();
                }
                if ((playerYLocation == -495) && (playerXLocation == 110) && (i == byAmount)) {
                    snake.bitePlayer(this, 55, -220);
                    translateLocationOfPlayer();
                }
            }
        }

    }

    @FXML
    void translateLocationOfPlayer(){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1500), playerToken);
        animate.setToX(playerXLocation);
        animate.setToY(playerYLocation);
        animate.setAutoReverse(false);
        animate.play();
    }

    public void rollDie(Die die){
        die.roll();
    }

    public void glowPlayerToken(){
        Effect glow = new Glow(1.0);
        playerText.setFill(Color.YELLOW);
        playerText.setEffect(glow);
        playerText.setUnderline(true);
        playerText.setOpacity(1);
        playerPicture.setEffect(glow);
        glow = new Glow(0.8);
        playerToken.setEffect(glow);
    }

    public void dimPlayerToken(){
        Effect glow = new Glow(0);
        playerText.setFill(Color.BLACK);
        playerText.setEffect(glow);
        playerText.setUnderline(false);
        playerText.setOpacity(1);
        playerPicture.setEffect(glow);
        playerToken.setEffect(glow);
    }

    public void setName(String name) {
        this.name = name;
        this.playerText.setText(name);
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerXLocation(double playerXLocation) {
        this.playerXLocation = playerXLocation;
    }

    public void setPlayerYLocation(double playerYLocation) {
        this.playerYLocation = playerYLocation;
    }

    public boolean isPlayerGameStarted() {
        return playerGameStarted;
    }

    public void setPlayerGameStarted(boolean playerGameStarted) {
        this.playerGameStarted = playerGameStarted;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerToken=" + playerToken +
                ", playerPicture=" + playerPicture +
                ", playerText=" + playerText +
                ", playerXLocation=" + playerXLocation +
                ", playerYLocation=" + playerYLocation +
                ", playerGameStarted=" + playerGameStarted +
                '}';
    }
}
