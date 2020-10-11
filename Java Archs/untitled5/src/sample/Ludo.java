
package sample;

import java.awt.Point;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Ludo extends Application {

    private ArrayList<Point> point = new ArrayList<Point>();
    private ArrayList<Circle> player1_bricks = new ArrayList<>();
    private ArrayList<Circle> player2_bricks = new ArrayList<>();
    private ArrayList<Circle> points = new ArrayList<>();
    private ArrayList<Line> connections = new ArrayList<>();
    private Rectangle background = new Rectangle(500, 500);
    private ListView select = new ListView();
    private TranslateTransition transition = new TranslateTransition();
    private int xFrom, yFrom, xTo, yTo, player1_turn=0, player2_turn=-1;
    private boolean game_end=true;
    private Circle src;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        //Points
        int x, y=30, x2, y2=30;
        for(int j = 0; j<5; j++){
            x=30; x2=130;
            for(int i = 0; i<5; i++){
                points.add(new Circle(x,y,10));
                x+=100;
            }
            y+=100; y2+=100;
        }
        for(Circle p: points){
            p.setFill(Color.WHITE);
            point.add(new Point((int) Math.round(p.getCenterX()), (int) Math.round(p.getCenterY())));
        }

        //Background Lines Horizontal
        y = 30; y2 = 30;
        for(int j = 0; j<5; j++){
            x=30;
            x2=130;
            for(int i = 0; i<5; i++){
                connections.add(new Line(x,y,x2,y2));
                x+=100;
            }
            y+=100; y2+=100;
        }

        //Background lines Vertical
        x = 30; x2 = 30;
        for(int j = 0; j<5; j++){
            y=30;
            y2=130;
            for(int i = 0; i<5; i++){
                connections.add(new Line(x,y,x2,y2));
                y+=100;
            }
            x+=100; x2+=100;
        }

        //Background lines diagonal
        connections.add(new Line(30,30,430,430));
        connections.add(new Line(430,30,30,430));
        connections.add(new Line(230,30,430,230));
        connections.add(new Line(30,230,230,30));
        connections.add(new Line(430,230,230,430));
        connections.add(new Line(30,230,230,430));
        for(Line l: connections)
            l.setStroke(Color.WHITE);

        //Player 1
        x=30; y=30;
        for(int j = 0; j<2; j++){
            x=30;
            for(int i = 0; i<5; i++){
                player1_bricks.add(new Circle(x,y,7));
                x+=100;
            }
            y+=100;
        }
        for(Circle c: player1_bricks)
            c.setFill(Color.BLUEVIOLET);

        //Player 2
        x=30; y=330;
        for(int j = 0; j<2; j++){
            x=30;
            for(int i = 0; i<5; i++){
                player2_bricks.add(new Circle(x,y,7));
                x+=100;
            }
            y+=100;
        }
        for(Circle c: player2_bricks)
            c.setFill(Color.RED);


        //while(game_end){
       // if(player1_turn>player2_turn){
            for(Circle c: player1_bricks){
                c.setOnMouseClicked(e -> {
                    //xFrom(e);
                    //yFrom(e);
                    getSrc(e);
                    System.out.println(e.getSource());
                    transition.stop();
                    player2_turn+=2;
                    System.out.println(player1_turn+"   "+player2_turn);
                });
               // break;
            }
        //}
       // else{
            for(Circle c: player2_bricks){
                c.setOnMouseClicked(e -> {
                    //xFrom(e);
                    //yFrom(e);
                    getSrc(e);
                    System.out.println(e.getSource());
                    transition.stop();
                    player1_turn+=2;
                });
               // break;
            }
       // }

        for(Circle p: points){
            p.setOnMouseClicked(e -> {
                //xTo(e);
                //yTo(e);
                //transition.setFromX(xFrom-30);
                //transition.setFromY(xFrom-30);
                transition.setToX(p.getCenterX()-src.getCenterX());
                transition.setToY(p.getCenterY()-src.getCenterY());
                transition.setNode(src);
                transition.setDuration(Duration.seconds(1));
                transition.play();
                //src.relocate(p.getCenterX(), p.getCenterY());
                System.out.println("x:" + p.getCenterX() + "   y:" + p.getCenterY());
                System.out.println("getx:" + transition.getToX() + "   gety:" + transition.getToY());
            });
        }
        //}

        //Adding to Layout
        background.toBack();
        root.getChildren().add(background);
        root.getChildren().addAll(points);
        root.getChildren().addAll(connections);
        root.getChildren().addAll(player1_bricks);
        root.getChildren().addAll(player2_bricks);

        //root.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Ludo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void xFrom(MouseEvent e){
        xFrom = 0;
        xFrom = (int) e.getX();
    }

    private void yFrom(MouseEvent e){
        yFrom = 0;
        yFrom = (int) e.getY();
    }

    private void xTo(MouseEvent e){
        xTo = 0;
        xTo = (int) e.getX();
    }

    private void yTo(MouseEvent e){
        yTo = 0;
        yTo = (int) e.getY();
    }
    private void getSrc(MouseEvent e){
        src = (Circle) e.getSource();
    }

    private void checkMove(Circle c){

    }
    private void move(Circle c){

    }
    private void isEmpty(){}

    public static void main(String[] args) {
        launch(args);
    }

}
