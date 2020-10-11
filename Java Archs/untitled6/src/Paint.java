import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Paint  {
    public static void main(String args[])
    {
        //JFrame app = new JFrame("Paint");
        Frame jp = new Frame();

        Graphics g = jp.getGraphics();

        jp.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
               // g.setColor(Color.CYAN);
                g.fillOval(e.getX(),e.getY(),20,20);

            }
        });
        //app.add(jp);

        //app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp.setSize(700,500);
        jp.setVisible(true);
    }
}
