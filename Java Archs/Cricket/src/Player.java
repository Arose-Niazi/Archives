import javafx.scene.image.Image;

public class Player extends Moveable {
    double power=2.5;

    Image brick=new Image("red.jpg",30,30,false,true);
    public Player(int x, int y){
        this.setImage(brick);
        this.setPosition(x,y);

    }



    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

}
