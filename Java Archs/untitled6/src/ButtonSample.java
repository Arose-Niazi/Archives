import javax.swing.*;
import java.awt.*;

public class ButtonSample {
    public static void main(String args[])
    {
        JFrame jFrame= new JFrame("Button Sample");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Select me");
        Container contentPane = jFrame.getContentPane();
        contentPane.add(button,BorderLayout.SOUTH);

        jFrame.setSize(300,100);
        jFrame.setVisible(true);
    }
}
