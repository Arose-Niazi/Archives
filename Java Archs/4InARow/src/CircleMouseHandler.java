
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class CircleMouseHandler
{
    public CircleMouseHandler(CicleMouseConditions cicleMouseConditions, Event e, Color color)
    {
        if(!Main.gameStarted) return;
        Node target = (Node) e.getTarget();
        int i=0;
        boolean clickedCirlce=false;
        for(Circle c: BackGroundGrid.clickableCricles)
        {
            if(target.equals(c))
            {
                clickedCirlce=true;
                break;
            }
            i++;
        }
        if(clickedCirlce)
        {
            int y=1;
            for(boolean b: BackGroundGrid.locationUsed[i])
            {
                if(!b)
                {
                    break;
                }
                y++;
            }
            if(y > 10)
            {
                boolean emptyloc=false;
                for(boolean b[]: BackGroundGrid.locationUsed)
                {
                    for(boolean b1: b)
                        if(!b1)
                        {
                            emptyloc=true;
                            break;
                        }
                }
                if(emptyloc)
                    return;
                else
                {
                    Main.onGoingGame.gameEndsDraw();
                    return;
                }
            }
            switch (cicleMouseConditions)
            {
                case HOVER:
                {
                    BackGroundGrid.clickableCricles.get(i).setFill(Main.currentPlayer.playerColor);
                    break;
                }
                case CLICK:
                {
                    if(!Main.canSelectNext) return;
                    Main.canSelectNext=false;

                    BackGroundGrid.locationUsed[i][y - 1] = true;
                    BackGroundGrid.locationOwnerBy[i][y-1] = Main.currentPlayer;
                    new MoveCircle(BackGroundGrid.clickableCricles.get(i), -1, BackGroundGrid.lastYLoc - (50*y), Duration.millis(1000),true);
                    BackGroundGrid.addAnotherSelectableBall(i);
                    if(Main.onGoingGame.checkForWinner(i,y-1))
                    {
                        return;
                    }
                    Main.onGoingGame.nextTurn();
                    break;
                }
            }
        }
    }
}
