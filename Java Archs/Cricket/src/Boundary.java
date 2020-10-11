import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class Boundary extends Moveable{
    Circle boundary=new Circle();
    Point2D point2D;
    public Boundary(){
        boundary.setCenterX(325);
        boundary.setCenterY(325);
        boundary.setRadius(320);
        boundary.setVisible(false);
    }

    public boolean BoundaryScored(Ball ball){
        point2D=new Point2D(ball.getPositionX(),ball.getPositionY());
        if(boundary.contains(point2D)){
            return false;
        }else {
            System.out.println(point2D);
            return true;
        }
    }



    public Circle drawBoundary(){
        System.out.println(boundary.getBoundsInLocal());
        return boundary;
    }
}
