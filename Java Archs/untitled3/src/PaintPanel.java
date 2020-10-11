import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class PaintPanel extends JPanel {
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Color> color = new ArrayList<Color>();
    private ColorPicker c;


    public PaintPanel(ColorPicker c)
    {
        this.c = c;
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
               points.add(e.getPoint());
               color.add(c.c);
               repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       for(int i=0; i<points.size(); i++)
       {
            g.fillOval(points.get(i).x, points.get(i).y, 4, 4);
            g.setColor(color.get(i));
        }
    }
}
