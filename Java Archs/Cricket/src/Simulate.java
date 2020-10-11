import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Simulate{
    Label score=new Label();
    int settingA=0,settingB=650;
    private Group root=new Group();
    Scene scene=new Scene(root);
    private Canvas canvas;
    ArrayList<Player> Fielders =new ArrayList<>();


    Ground ground;
    Boundary boundary=new Boundary();
    Bat bat =new Bat();
    Ball ball =new Ball();


    public void starts(Stage stage){

        canvas=new Canvas(Screen.getWidth(),Screen.getHeight());


        score.setLayoutY(settingB+5);
        score.setLayoutX(settingA+10);

        SettingBricks();

        Circle boundarey=boundary.drawBoundary();

        root.getChildren().addAll(canvas,score,boundarey);
        bat.setPosition(300,258);
        ball.setPosition(300,450);



        GraphicsContext gc=canvas.getGraphicsContext2D();

        ground = new Ground(600,600);

        new AnimationTimer(){
            public void handle(long now){
                gc.drawImage(ground.getImage(),settingA,settingA,settingB,settingB);
                bat.render(gc);
                for(Player c: Fielders){
                    c.render(gc);
                }
                if(Fielders.size()==0){
                    gameOver(gc,"You won");
                    stop();
                }
                boolean test= ball.move(bat, Fielders);
                if(boundary.BoundaryScored(ball)){
                    gameOver(gc,"Boundary is scored");
                    stop();
                }
                if(test){
                    //Match stats will be added here
                }else {
                    gameOver(gc,"ball stopped");
                    this.stop();
                }


                ball.render(gc);
                score.setText("Score : " + ball.getScore());
                if(ball.getPositionY()>settingB){
                    gameOver(gc,"Game Over");
                    stop();

                }

                canvas.setOnKeyPressed(event -> {
                    switch (event.getCode()){
                        case LEFT:
                            bat.move(-3);break;
                        case RIGHT:
                            bat.move(3);break;
                        case DOWN:
                            if(bat.getDownFactor()<5){
                                bat.setPositionY(bat.getPositionY()+5);
                                bat.setDownFactor(bat.getDownFactor()+1);}
                            break;
                    }
                });
                canvas.setOnKeyReleased(event -> {
                    if(event.getCode()== KeyCode.DOWN){
                        for(int a = 0; a< bat.getDownFactor(); a++){
                            bat.setPositionY(bat.getPositionY()-(5));
                            if(ball.intersects(bat)){
                                ball.setY(ball.getY()*(-bat.getDownFactor()));
                                ball.setPositionY(settingB-100);
                            }
                        }
                        bat.setDownFactor(0);
                    }
                });
                canvas.requestFocus();

            }

        }.start();

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
    }

    public void gameOver(GraphicsContext gc,String s){
        Font font=new Font(45);
        Label restart=new Label("Next ball");
        restart.setTextFill(Color.PAPAYAWHIP);
        restart.setFont(font);
        restart.setLayoutX(250);
        restart.setLayoutY(280);
        root.getChildren().add(restart);
        restart.setOnMouseClicked(event -> SettingBricks());
        font=new Font(25);
        gc.setFont(font);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.PAPAYAWHIP);
        gc.setLineWidth(2);
        gc.fillText(s,210,200);
        gc.strokeText(s,210,200);
        gc.fillText(score.getText(),210,250);
        gc.strokeText(score.getText(),210,250);

    }

    public void SettingBricks(){

        Fielders.add(new Player(settingA+3,10));
        Fielders.add(new Player(settingA+58,450));
        //Fielders.add(new Player(settingA+185,350));
        //Fielders.add(new Player(settingA+95,250));
        Fielders.add(new Player(settingA+265,150));
        Fielders.add(new Player(settingA+278,10));
        Fielders.add(new Player(settingA+333,400));
        Fielders.add(new Player(settingA+388,295));
        Fielders.add(new Player(settingA+498,200));
        Fielders.add(new Player(settingA+498,10));
        Fielders.add(new Player(settingA+3,400));
        ball.setScore(0);

    }
}
