package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    boolean card_back=true;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = /*FXMLLoader.load(getClass().getResource("sample.fxml"))*/ new Group();
        primaryStage.setTitle("Hello World");
        Line line = new Line();
        line.setStartX(100.0);
        line.setStartY(150.0);
        line.setEndX(80.0);
        line.setEndY(100.0);

        Line line2 = new Line();
        line2.setStartX(80.0);
        line2.setStartY(150.0);
        line2.setEndX(200.0);
        line2.setEndY(100.0);

        Line line3 = new Line();
        line3.setStartX(85.0);
        line3.setStartY(175.0);
        line3.setEndX(115.0);
        line3.setEndY(175.0);

        //root.getChildren().add(line);
        //root.getChildren().add(line2);
        //root.getChildren().add(line3);

        Text text = new Text();
        //Setting font to the text
        text.setFont(new Font(45));
        text.setX(50);
        text.setY(150);

        text.setText("Welcome to My first FX program");

        //root.getChildren().add(text);

        FileInputStream inputstream = new FileInputStream("C:\\Users\\Arose\\Desktop\\PNG\\blue_back.png");

        Image image = new Image(inputstream);

        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(100);
        imageView.setY(85);

        //setting the fit height and width of the image view
        imageView.setFitHeight(300);
        imageView.setFitWidth(600);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        //Glow glow = new Glow();
        //glow.setLevel(0.9);
        //imageView.setEffect(glow);

        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

            @Override
           public void handle(MouseEvent event)
           {
               try{
                   if (card_back)imageView.setImage(new Image(new FileInputStream("C:\\Users\\Arose\\Desktop\\PNG\\2C.png")));
                    else imageView.setImage(image);
                    changeCardState();

               }

               catch (Exception e)
               {

               }


           }
        });

        root.getChildren().add(imageView);
        System.out.printf("Image:\nFit Height: %f\nFit Width: %f\nX: %f\nY: %f\nLay X: %f\nLay Y: %f", imageView.getFitHeight(), imageView.getFitWidth(), imageView.getX() , imageView.getY(), imageView.getScaleZ(), imageView.getScaleX());

        Scene scene = new Scene(root, 300, 275);
        primaryStage.setMaximized(true);

        //primaryStage.setFullScreen(true);

        Button button2= new Button("Testing");
        root.getChildren().add(button2);
        button2.setLayoutX(100 + 20);
        button2.setLayoutY(85 + imageView.getFitHeight());
        //button2.cancelButtonProperty(true);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                switch(key)
                {
                    case UP:
                        text.setText("Upper jaa kr marna ha?");
                        button2.setText("Start");
                        break;
                    case DOWN:
                        text.setText("Neecha kiya baap ko daik raha ha");
                        button2.setText("Changed");
                        break;
                    case LEFT:
                        text.setText("Left? srsly?");
                        break;
                    case RIGHT:
                        text.setText("Right? Yes fine");
                        break;
                    case ESCAPE:
                        text.setText("Ham ko na chor ka jaa sanam" );
                        //if(!(primaryStage.isFullScreen())) Platform.exit();
                }


            }
        });
        scene.setFill(Color.GREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeCardState() {
        card_back = !card_back;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
