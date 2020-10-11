package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class StopWatch extends Application {

    private Group root = new Group();

    private Text timer;
    private Button startButton;
    private Button stopButton;
    private Time2 t;
    @Override
    public void start(Stage primaryStage) throws Exception{

        t = new Time2();

        primaryStage.setTitle("Stop Watch");

        timer = new Text();
        timer.setFont(Font.font("Ariel", FontWeight.NORMAL,40));
        timer.setX(80);
        timer.setY(80);
        timer.setText("00:00:00");
        timer.setTextAlignment(TextAlignment.CENTER);

        startButton = new Button("Start");
        startButton.setLayoutX(80);
        startButton.setLayoutY(100);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if(startButton.getText().equals("Start"))
               {
                   startButton.setText("Tick");
                   timer.setText("00:00:00");
                   t.setHours(0);
                   t.setMinutes(0);
                   t.setSeconds(0);
               }
               else
               {
                   t.tick();
                   timer.setText(String.format("%02d:%02d:%02d",t.getHours(),t.getMinutes(),t.getSeconds()));
               }
            }
        });

        stopButton = new Button("Clear");
        stopButton.setLayoutX(140);
        stopButton.setLayoutY(100);
        stopButton.setOnAction(e -> {
            if(startButton.getText().equals("Tick"))
            {
                startButton.setText("Start");
                timer.setText("00:00:00");
                t.setHours(0);
                t.setMinutes(0);
                t.setSeconds(0);
            }
        });



        root.getChildren().addAll(timer,startButton,stopButton);

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
