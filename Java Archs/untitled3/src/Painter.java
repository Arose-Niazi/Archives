import javax.swing.*;
import java.awt.*;

public class Painter {
    public static void main(String args[])
    {
        JFrame app = new JFrame("Paint");
        ColorPicker cc = new ColorPicker();


        PaintPanel pp = new PaintPanel(cc);

        app.add(pp, BorderLayout.CENTER);
        app.add(cc.jcc, BorderLayout.SOUTH);

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(700,500);
        app.setVisible(true);
    }
}
