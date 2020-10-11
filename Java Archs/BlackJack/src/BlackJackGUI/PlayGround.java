import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PlayGround {

    @FXML
    private Group DealerCards;

    @FXML
    private ImageView dCard_1;

    @FXML
    private ImageView dCard_2;

    @FXML
    private ImageView dCard_3;

    @FXML
    private ImageView dCard_4;

    @FXML
    private ImageView dCard_5;

    @FXML
    private ImageView dCard_6;

    @FXML
    private Group PlayerCards;

    @FXML
    private ImageView pCard_1;

    @FXML
    private ImageView pCard_2;

    @FXML
    private ImageView pCard_3;

    @FXML
    private ImageView pCard_4;

    @FXML
    private ImageView pCard_5;

    @FXML
    private ImageView pCard_6;

    @FXML
    private Label PlayerName;

    @FXML
    private Button StartEndButton;

    @FXML
    void OnButtonPress(MouseEvent event) {
        if(StartEndButton.getText().equals("Start"))
        {
            System.out.println("Ready to start!");
        }
    }

}
