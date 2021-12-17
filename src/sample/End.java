package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class End
{

    @FXML
    Text winner;

    @FXML
    Text looser;

    @FXML
    public void initialize()
    {
        String[] names;
        names=SnakeAndLadderGame.return_names();
        winner.setText(names[0]);
        looser.setText(names[1]);
    }
}

