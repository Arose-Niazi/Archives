package Testing2;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static Testing2.Cards.CARDSPOSSIBLE;
import static Testing2.Cards.DECK;
import static Testing2.CardsData.BACK;
import java.util.Random;

public class Main extends Application {


    private Group root = new Group();

    private Working working;

    private ImageView dealerCards[] = new ImageView[CARDSPOSSIBLE.value];
    private ImageView playerCards[] = new ImageView[CARDSPOSSIBLE.value];

    private Button startButton;
    private Button standButton;

    private Stage s;

    public Stage getS() {
        return s;
    }

    @Override
    public void start(Stage primaryStage) {
        s=primaryStage;
        try {

            Random rand = new Random();


            primaryStage.setTitle("Blackjack");

            ImageView backGround = new ImageView(new Image(new FileInputStream("PNG\\" + "back" + ".jpg"),1920.0,1080.0,false,true));
            backGround.setX(0.0);
            backGround.setX(0.0);

            Text dealerName = new Text();
            dealerName.setFont(Font.font("Ariel", FontWeight.BOLD,15));
            dealerName.setX(20);
            dealerName.setY(40);
            dealerName.setText("Dealer:");
            dealerName.setTextAlignment(TextAlignment.RIGHT);
            //root.setAlignment(dealerName,Pos.BASELINE_RIGHT);
            //text.prefHeight().bind(root.heightProperty());
            //text.prefWidth().bind(root.widthProperty());

            Text playersName = new Text();
            playersName.setFont(Font.font("Ariel", FontWeight.BOLD,15));
            playersName.setX(20);
            playersName.setY(290);
            playersName.setText("Arose Niazi:");
            playersName.setTextAlignment(TextAlignment.RIGHT);

            for (int i = 0; i < CARDSPOSSIBLE.value; i++) {
                dealerCards[i] = new ImageView(new Image(new FileInputStream("PNG\\" + BACK.fileName + ".png"), 140.0 , 180.0,false , true));
                dealerCards[i].setX(20 + (60 * i));
                dealerCards[i].setY(50);
            }
            CardsData c[] = CardsData.values();
            for (int i = 0; i < CARDSPOSSIBLE.value; i++) {

                playerCards[i] = new ImageView(new Image(new FileInputStream("PNG\\" + c[rand.nextInt(DECK.value) + 1].fileName + ".png"), 140.0 , 180.0,false , true));
                playerCards[i].setX(20 + (60 * i));
                playerCards[i].setY(300);
            }

            startButton= new Button("START GAME!");
            startButton.setLayoutX(20);
            startButton.setLayoutY(500);
            startButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if(Working.isGameStarted())
                            {
                                startButton.setDisable(true);
                                working.playerCalledHit();
                            }
                            else
                            {
                                startButton.setText("HIT");
                                startGame();
                            }
                        }
                    });

            standButton= new Button("STAND!");
            standButton.setLayoutX(60);
            standButton.setLayoutY(500);
            standButton.setVisible(false);

            standButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    standButton.setDisable(true);
                    working.playerStands();
                }
            });

            root.getChildren().add(backGround);
            root.getChildren().addAll(dealerCards);
            root.getChildren().addAll(playerCards);
            root.getChildren().add(dealerName);
            root.getChildren().add(playersName);
            root.getChildren().add(startButton);
            root.getChildren().add(standButton);



            Scene scene = new Scene(root, 1280, 560);
            primaryStage.setMaximized(true);

            primaryStage.setFullScreen(true);
            scene.setFill(Color.WHITE);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception  e)
        {
            e.printStackTrace();
        }
    }

    private void startGame()
    {
        working = new Working(this,root);
        working.startGame();
        standButton.setVisible(true);
    }

    public void resetDealersCards()
    {
        for (int i = 0; i < CARDSPOSSIBLE.value; i++) {
           dealerCards[i].setVisible(false);
        }
    }

    public void resetPlayersCards()
    {
        for (int i = 0; i < CARDSPOSSIBLE.value; i++) {
            playerCards[i].setVisible(false);
        }
    }

    public void addDealersCard(CardsData c)
    {
        for (int i = 0; i < CARDSPOSSIBLE.value; i++) {
            try {
                if (!dealerCards[i].isVisible()) {
                    //dealerCards[i].setImage(new Image(new FileInputStream("PNG\\" + c.fileName + ".png"), 140.0, 180.0, false, true));
                    dealerCards[i].setImage(new Image(new FileInputStream("PNG\\" + BACK.fileName + ".png"), 140.0, 180.0, false, true));
                    dealerCards[i].setVisible(true);
                    playRotateAnimation(dealerCards[i]);
                    break;
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Error: Missing Files!");
            }
        }
    }

    public void addPlayersCard(CardsData c){
        for (int i = 0; i < CARDSPOSSIBLE.value; i++) {
            try {
                if (!playerCards[i].isVisible()) {
                    playerCards[i].setImage(new Image(new FileInputStream("PNG\\" + c.fileName + ".png"), 140.0, 180.0, false, true));
                    playerCards[i].setVisible(true);
                    playRotateAnimation(playerCards[i]);
                    break;
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Error: Missing Files!");
            }
        }
    }

    public void flipDealersCards(CardsData c[])
    {
        for (int i = 0; i < CARDSPOSSIBLE.value; i++) {
            try {
                if (dealerCards[i].isVisible()) {
                    dealerCards[i].setImage(new Image(new FileInputStream("PNG\\" + c[i].fileName + ".png"), 140.0, 180.0, false, true));
                    playRotateAnimation(dealerCards[i]);
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Error: Missing Files!");
            }
        }
    }

    public void endGame()
    {
        startButton.setText("START GAME!");
        startButton.setDisable(false);
        standButton.setVisible(false);
        standButton.setDisable(false);
    }

    public void playersTurn()
    {
        startButton.setDisable(false);
    }

    private void playRotateAnimation(Node n)
    {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(n);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
