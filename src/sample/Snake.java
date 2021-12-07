package sample;

public class Snake {

    public void bitePlayer(Player player, double toXPosition, double toYPosition){
        player.setPlayerXLocation(toXPosition);
        player.setPlayerYLocation(toYPosition);
    }
}
