import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Main {

    static final Group root = new Group();
    static boolean canSelectNext;
    static Player currentPlayer;
    static Working onGoingGame;
    static boolean gameStarted;
    static Rectangle2D screenBounds;
    static Main cMain;

    private BackGroundGrid grid;
    private Button startButton;
    private int playersMax;
    private int toWin;
    private Stage primaryStage;
    private int cpCounter=0;

    static {
        canSelectNext=false;
        gameStarted=false;
    }

    public Main(int playersMax, int toWin)
    {
        cMain=this;
        this.playersMax=playersMax;
        this.toWin=toWin;
        start();
    }

    public void start(){

        primaryStage = new Stage();
        screenBounds = Screen.getPrimary().getBounds();
        System.out.println(screenBounds);


        grid = new BackGroundGrid();

        root.getChildren().add(grid);
        root.getChildren().addAll(grid.spaces);
        root.getChildren().addAll(grid.clickableCricles);

        startButton= new Button("PLAY!");
        startButton.setLayoutX(screenBounds.getWidth() - 800);
        startButton.setLayoutY(screenBounds.getHeight() - 50);
        startButton.setOnAction(e -> {
            startGame();
        });

        root.getChildren().add(startButton);


        Scene scene = new Scene(root, 1000, 600);

        primaryStage.setFullScreen(true);
        scene.setFill(Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.maximizedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if( t1.booleanValue()) primaryStage.setFullScreen(true);
            }
        });
    }

    public void startGame()
    {
        root.getChildren().removeAll(BackGroundGrid.allPlacedCircles);
        BackGroundGrid.resetGrid();
        gameStarted=canSelectNext=true;
        startButton.setDisable(true);
        onGoingGame = new Working(this,playersMax,toWin);
    }

    public void endGame()
    {
        gameStarted=canSelectNext=false;
        startButton.setDisable(false);
    }

    public void addPlayersData(String name, Color col)
    {
        Label l = new Label(name);
        l.setLayoutX(5);
        l.setLayoutY(10 + 80*cpCounter);
        l.setFont(Font.font("Ariel", FontWeight.EXTRA_BOLD,10.0));
        Circle c = new Circle(20 ,20 + 80*cpCounter,40);
        c.setFill(col);
        root.getChildren().addAll(c,l);
        cpCounter++;
    }

    public Stage getStage() {
        return primaryStage;
    }
}
