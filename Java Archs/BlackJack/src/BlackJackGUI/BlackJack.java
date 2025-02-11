package BlackJackGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackJack extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root = (Pane) new FXMLLoader().load(BlackJack.class.getResource("PlayGround.fxml"));

        Scene playerGroundScene = new Scene(root);
        primaryStage.setScene(playerGroundScene);
        primaryStage.show();
    }
}
