package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    public static String[] getPlayerNames() {
        return playerNames;
    }

    static String[] playerNames = new String[2];

    @FXML
    private ImageView image;

    @FXML private Button startButton;

    @FXML
    private TextField tfTitle1;

    @FXML
    private TextField tfTitle2;

    Stage snakeAndLadderGame;

    @FXML
    void btnOKclicked(ActionEvent event) throws IOException
    {
        Stage mainWindow = (Stage) tfTitle1.getScene().getWindow();
        String title1 = tfTitle1.getText();
        String title2 = tfTitle2.getText();
        if (title1.equals(""))
            title1 = "Player1";
        if (title2.equals(""))
            title2 = "Player2";
        mainWindow.setTitle(title1+" vs "+title2);
        mainWindow.close();

        playerNames[0] = title1;
        playerNames[1] = title2;
        snakeAndLadderGame= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        Image image = new Image(getClass().getResource("assets/snake.png").toExternalForm());
        snakeAndLadderGame.getIcons().add(image);
        snakeAndLadderGame.setTitle(title1+" vs "+title2);
        playerNames[0] = title1;
        playerNames[1] = title2;
        snakeAndLadderGame.setScene(new Scene(root));
        snakeAndLadderGame.show();
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.9);
        startButton.setEffect(glow);
    }

    public void removeButtonSkin()
    {
        Glow glow = new Glow();
        glow.setLevel(0);
        startButton.setEffect(glow);
    }
}