import javafx.scene.paint.Color;

public class Player {

    String name;
    Color playerColor;

    public Player(String name,Color playerColor)
    {
        this.name=name;
        this.playerColor=playerColor;
        Main.cMain.addPlayersData(name,playerColor);
    }

    public String getName() {
        return name;
    }
}
