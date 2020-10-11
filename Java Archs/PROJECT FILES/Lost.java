package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lost extends Application {

    Stage window=new Stage();
    Label label=new Label();

    public Lost(String x) {
        label.setText(x);
        start(window);
    }


    @Override
    public void start(Stage primaryStage) {


        VBox layout= new VBox();
        layout.setAlignment(Pos.CENTER);
        Button button =new Button("OK");
        button.setOnAction(event -> window.close());
        layout.getChildren().addAll(label,button);
        Scene scene=new Scene(layout);
        window.setMinWidth(300);
        window.setMinHeight(100);
        window.setScene(scene);
        window.showAndWait();
    }



}
