package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class Main extends Application {
    Label newGame,signIn,stats,playerN;
    Scene scene;
    Group group;
    Canvas canvas;

    @Override
    public void start(Stage primaryStage){
        playerN=new Label("Muhammad Qasim Hayat");
        newGame=new Label("New Game");
        signIn=new Label("Sign In");
        stats=new Label("Statics");
        newGame.setTextFill(Color.WHITESMOKE);
        signIn.setTextFill(Color.WHITESMOKE);
        stats.setTextFill(Color.WHITESMOKE);
        playerN.setTextFill(Color.WHITESMOKE);
        newGame.setAlignment(Pos.CENTER);
        signIn.setAlignment(Pos.CENTER);
        stats.setAlignment(Pos.CENTER);
        newGame.setLayoutY(200);
        newGame.setLayoutX(250);
        signIn.setLayoutY(300);
        signIn.setLayoutX(250);
        stats.setLayoutY(400);
        stats.setLayoutX(250);
        playerN.setLayoutY(10);
        playerN.setLayoutX(70);



        newGame.setOnMouseEntered(event -> newGame.setTextFill(Color.STEELBLUE));
        newGame.setOnMouseExited(event -> newGame.setTextFill(Color.WHITESMOKE));

        stats.setOnMouseEntered(event -> stats.setTextFill(Color.STEELBLUE));
        stats.setOnMouseExited(event -> stats.setTextFill(Color.WHITESMOKE));

        signIn.setOnMouseEntered(event -> signIn.setTextFill(Color.STEELBLUE));
        signIn.setOnMouseExited(event -> signIn.setTextFill(Color.WHITESMOKE));


        Font font=new Font("Times New Roman",30);


        newGame.setFont(font);
        newGame.setStyle("-fx-font-size: 30");
        signIn.setStyle("-fx-font-size: 30 ");
        stats.setStyle("-fx-font-size: 30");


        group=new Group();
        canvas=new Canvas(600,600);
        group.getChildren().addAll(canvas,newGame,signIn,stats,playerN);
        scene=new Scene(group);

        GraphicsContext gc=canvas.getGraphicsContext2D();
        final long startTime=System.nanoTime();

        Image player=new Image("SilverBall1.JPG",50,50,false,false);
        Image img=new Image("space.jpg",600,600,false,false);
        Image Jupiter=new Image("Jupiter.jpg",50,50,false,false);
        Image mars=new Image("Venus.jpg",50,50,false,false);
        Image venus=new Image("realVenus.jpg",50,50,false,false);
        Image earth=new Image("earth.jpeg",50,50,false,false);
        Image sun=new Image("sun.jpeg",110,110,false,false);

        new AnimationTimer(){

            @Override
            public void handle(long now) {
                gc.drawImage(img,0,0);

                double t=(now-startTime)/1000000000.0;
                double x=200+128*Math.cos(t);
                double y=200+128*Math.sin(t);
                gc.drawImage(earth,x,y)
                ;
                x=275+250*Math.cos(t);
                y=275+250*Math.sin(t);
                gc.drawImage(venus,x,y);

                x=(350+200*Math.cos(t))-50;
                y=(200+200*Math.sin(t));
                gc.drawImage(mars,x,y);

                x=(425+128*Math.cos(t))-200;
                y=(425+128*Math.sin(t))-200;
                //gc.drawImage(Jupiter,x,y);

                gc.drawImage(sun,196,196);
                gc.drawImage(player,10,10);
            }
        }.start();


        primaryStage.setTitle("Games by Qasim and Arose");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
