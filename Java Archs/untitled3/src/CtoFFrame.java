import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtoFFrame extends JFrame {

    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel resultLabel;
    private JTextField fromTextField;

    private JRadioButton fromCbutton;
    private JRadioButton fromFbutton;
    private JRadioButton toCbutton;
    private JRadioButton toFbutton;

    public CtoFFrame() {
        super("Temperature Converted");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLayout(new FlowLayout());
        fromLabel = new JLabel("From ");
        toLabel = new JLabel("To ");

        resultLabel = new JLabel("");

        fromTextField = new JTextField(10);

        fromCbutton = new JRadioButton("C (Degree)",true);
        toCbutton = new JRadioButton("C (Degree)");
        fromFbutton = new JRadioButton("F (Degree)");
        toFbutton = new JRadioButton("F (Degree)",true);

        ButtonGroup fromGroup = new ButtonGroup();
        fromGroup.add(fromCbutton);
        fromGroup.add(fromFbutton);

        ButtonGroup toGroup = new ButtonGroup();
        toGroup.add(toCbutton);
        toGroup.add(toFbutton);

        add(fromLabel);
        add(fromCbutton);
        add(fromFbutton);
        add(fromTextField);
        add(toLabel);
        add(toCbutton);
        add(toFbutton);
        add(resultLabel);

        fromTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toCbutton.isSelected())
                {
                    if(fromCbutton.isSelected())
                    {
                        resultLabel.setText(fromTextField.getText());
                    }
                    else {
                        resultLabel.setText(String.format("%.2f",(Double.parseDouble(fromTextField.getText())- 32)*5/9 ));
                    }
                }
                else
                {
                    if(fromCbutton.isSelected())
                    {
                        resultLabel.setText(String.format("%.2f",(Double.parseDouble(fromTextField.getText())* 9/5) + 32));

                    }
                    else {
                        resultLabel.setText(fromTextField.getText());
                    }
                }
            }
        });

    }
}
