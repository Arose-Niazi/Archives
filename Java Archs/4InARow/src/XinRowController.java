import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class XinRowController implements Initializable {
    @FXML
    private ChoiceBox<Integer> playerCbox;

    @FXML
    private ChoiceBox<Integer> winsCbox;

    @FXML
    private Button selectPlayersButton;

    public Button getSelectPlayersButton() {
        return selectPlayersButton;
    }

    public ChoiceBox<Integer> getPlayerCbox() {
        return playerCbox;
    }

    public ChoiceBox<Integer> getWinsCbox() {
        return winsCbox;
    }

    public void initialize(URL u, ResourceBundle rs) {
        playerCbox.getItems().removeAll(playerCbox.getItems());
        playerCbox.getItems().addAll(2,3,4,5,6,7,8,9,10);
        playerCbox.getSelectionModel().select(0);

        winsCbox.getItems().removeAll(winsCbox.getItems());
        winsCbox.getItems().addAll(2,3,4,5,6,7);
        winsCbox.getSelectionModel().select(2);
    }


}
