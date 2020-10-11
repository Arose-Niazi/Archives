/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousem;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseListener;

/**
 *
 * @author Anas
 */
public class Frame extends JFrame{
    JButton B;
    public Frame(){
    super("MouseMove");
    setLayout(new FlowLayout());
    
    B=new JButton("Click me");
    B.addMouseListener(new Mouse());
    add(B);
}
    private class Mouse extends MouseAdapter{

    public void mouseEntered(MouseEvent e) {
    B.setLocation((int)Math.random()*((350-4)+1)+4,(int)Math.random()*((450-5)+1)+5);
    
    } 
    }
}
