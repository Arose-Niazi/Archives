import com.sun.javafx.scene.control.skin.VirtualFlow;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.LinkedList;


public class BackGroundGrid extends Rectangle {

    static ArrayList<Circle> spaces = new ArrayList<>();
    static LinkedList<Circle> clickableCricles = new LinkedList<>();
    static LinkedList<Circle> allPlacedCircles;
    static boolean locationUsed[][] = new boolean[10][10];
    static Player locationOwnerBy[][] = new Player[10][10];


    static int lastYLoc;

    static {
        resetGrid();
    }

    static void resetGrid()
    {
        locationUsed = new boolean[10][10];
        allPlacedCircles = new LinkedList<>();
    }
    public BackGroundGrid() {
        super(Main.screenBounds.getWidth() - 750, Main.screenBounds.getHeight() - 500, 500, 500);
        setFill(Color.YELLOW);
        setStroke(Color.BLACK);
        setStrokeWidth(2.0);

        for(int i=0; i<10; i++)
        {
            Circle c = new Circle((Main.screenBounds.getWidth() - 725) + i*50 ,Main.screenBounds.getHeight() - 525,20);
            c.setFill(Color.RED);
            c.setOnMouseEntered(e -> new CircleMouseHandler(CicleMouseConditions.HOVER,e,Color.BLUE));
            c.setOnMouseExited(e -> new CircleMouseHandler(CicleMouseConditions.HOVER,e,Color.RED));
            c.setOnMouseClicked(e -> new CircleMouseHandler(CicleMouseConditions.CLICK,e,null));
            clickableCricles.add(c);
            c.setStroke(Color.BLACK);
        }

        for(int i=0; i<10; i++)
        {
            for(int k=0; k<10; k++)
            {
                Circle c = new Circle((Main.screenBounds.getWidth() - 725) + i*50,(Main.screenBounds.getHeight() - 475) + k*50,20);
                c.setFill(Color.WHITE);
                spaces.add(c);
                lastYLoc = 100 + k*50;
            }
        }


    }

    static void addAnotherSelectableBall(int ballLoc) {
        for(int i=ballLoc+1; i<10; i++)
        {
            new MoveCircle(BackGroundGrid.clickableCricles.get(i), -50, -1, Duration.millis(500));
        }
        allPlacedCircles.add(clickableCricles.get(ballLoc));
        clickableCricles.remove(ballLoc);
        Circle c = new Circle((Main.screenBounds.getWidth() - 725) + 9*50 ,Main.screenBounds.getHeight() - 525,20);
        c.setFill(Color.ORANGE);
        clickableCricles.add(c);
        Main.root.getChildren().removeAll(clickableCricles);
        Main.root.getChildren().addAll(clickableCricles);
        c.setOnMouseEntered(e -> new CircleMouseHandler(CicleMouseConditions.HOVER,e,Color.BLUE));
        c.setOnMouseExited(e -> new CircleMouseHandler(CicleMouseConditions.HOVER,e,Color.RED));
        c.setOnMouseClicked(e -> new CircleMouseHandler(CicleMouseConditions.CLICK,e,null));
        c.setStroke(Color.BLACK);
    }
}
