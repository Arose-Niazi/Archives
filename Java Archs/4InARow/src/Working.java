import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;

import java.util.Optional;
import java.util.Random;

public class Working {
    private Main currentGameMain;
    private static  Player players[];
    private int pCurrentTurn = -1;
    private int totalPlayers;
    private int toCheckInRow;
    static boolean playersSelected=false;

    public Working(Main currentGameMain,int totalPlayers,int toCheckInRow) {

        this.currentGameMain = currentGameMain;
        this.totalPlayers=totalPlayers;
        this.toCheckInRow = toCheckInRow;

        if(!playersSelected)
        {
            players = new Player[totalPlayers];
            Random r = new Random();
            for(int i=0; i<totalPlayers; i++)
            {
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Enter Name");
                dialog.setHeaderText("Enter player " + (i+1) + "'s name");
                dialog.setContentText("Please enter name:");
                dialog.initOwner(currentGameMain.getStage());
                Optional<String> result = dialog.showAndWait();
                if(result.isPresent())
                {
                    if(result.get().isEmpty())
                    {
                        i--;
                    }
                    else
                    {
                        int re = r.nextInt(255);
                        int g = r.nextInt(255);
                        int b = r.nextInt(255);
                        this.players[i] = new Player(result.get(), Color.rgb(re,g,b));
                    }
                }
            }
            playersSelected=true;
        }

        nextTurn();
    }

    public void nextTurn()
    {
        pCurrentTurn++;
        if(pCurrentTurn >= totalPlayers) pCurrentTurn=0;
        currentGameMain.currentPlayer=players[pCurrentTurn];
    }

    public boolean checkForWinner(int x, int y)
    {
        int counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x + i][y] && BackGroundGrid.locationOwnerBy[x + i][y].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x - i][y] && BackGroundGrid.locationOwnerBy[x - i][y].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x][y + i] && BackGroundGrid.locationOwnerBy[x][y + i].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x][y - i] && BackGroundGrid.locationOwnerBy[x][y - i].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x + i][y + i] && BackGroundGrid.locationOwnerBy[x + i][y + i].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x - i][y - i] && BackGroundGrid.locationOwnerBy[x - i][y - i].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x - i][y + i] && BackGroundGrid.locationOwnerBy[x - i][y + i].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }
        counter=0;
        try{
            for(int i=0; i<toCheckInRow; i++)
            {
                if(BackGroundGrid.locationUsed[x + i][y - i] && BackGroundGrid.locationOwnerBy[x + i][y - i].equals(players[pCurrentTurn]))
                {
                    counter++;
                }
                if(counter == toCheckInRow)
                {
                    endGame();
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }

        return false;
    }

    public void gameEndsDraw()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(currentGameMain.getStage());
        alert.setTitle("Game Over!");
        alert.setHeaderText("DRAW!");
        alert.setContentText("No one has won the game.");
        alert.showAndWait();
        currentGameMain.endGame();
    }

    private void endGame()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(currentGameMain.getStage());
        alert.setTitle("Game Over!");
        alert.setHeaderText("Victory!");
        alert.setContentText("Congrats "+ players[pCurrentTurn].getName() +   " for wining the game");
        alert.showAndWait();
        currentGameMain.endGame();
    }
}
