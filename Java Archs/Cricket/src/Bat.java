import javafx.scene.image.Image;

public class Bat extends Moveable {
    private int downFactor=0;
    Image rect=new Image("realVenus.jpg",50,5,false,false);

    public Bat(){
        super.setImage(rect);
    }
    public void move(int x){

        super.setVelocity(x,0);
        super.update(10);
        if(super.getPositionX()<-10 || super.getPositionX()>=520){
            super.setVelocity(-x,0);
            super.update(10);
        }



    }


    public int getDownFactor() {
        return downFactor;
    }

    public void setDownFactor(int downFactor) {
        this.downFactor = downFactor;
    }
}




/*
Commented Brick Code below



*/

