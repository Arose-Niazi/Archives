import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class XinRowSelectScreen extends Application {

    private Parent root;
    private  XinRowController c;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            root= loader.load();
            c = loader.getController();
        }
        catch (IOException e)
        {

        }

        c.getSelectPlayersButton().setOnMouseClicked(e ->
        {
            primaryStage.hide();
            new Main(c.getPlayerCbox().getValue(),c.getWinsCbox().getValue());
        });
        primaryStage.setTitle("X in row");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }
}
