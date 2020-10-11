import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class Ball extends Moveable {
    private int score=0;
    private double x=0;
    private double y=-1;

    Image ball=new Image("images/ball.png",15,15,false,true);


    public Ball(){
        super();
        super.setImage(ball);
    }
    public boolean move(Bat p, ArrayList<Player> b){
        if(super.getPositionX()<=5 || super.getPositionX()>530){
            x=-x;
        }
        if(super.getPositionY()<=5 || super.getPositionY()>535){
            y=-1;
            y=-y;
        }


        if(super.intersects(p)){
            setX((this.getPositionX()-(p.getPositionX()+15))/50);
            y=-y;
        }
        try {
            for(Player c:b){
                if(this.intersects(c)){

                    return false;
                }
            }
        }catch (ConcurrentModificationException e){
        }

        super.setVelocity(x,y);
        super.update(3);

        return true;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}



/*
Commented Brick Code below





*/

