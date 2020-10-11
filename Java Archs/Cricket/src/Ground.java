import javafx.scene.image.Image;

public class Ground {
    private int width;
    private int height;
    private Image image;

    public Ground(int width, int height) {
        this.width = width;
        this.height = height;
        image=new Image("images/ground.png",width,height,false,false);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }
}
