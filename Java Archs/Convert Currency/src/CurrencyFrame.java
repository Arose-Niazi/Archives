
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CurrencyFrame extends JFrame {

    private final JTextField inputText;
    private final JTextField outText;
    private final JComboBox<String> fromComboBox;
    private final JComboBox<String> toComboBox;
    private static final String toComboString[] = {"USD","PKR"};
    private static final String fromComboString[] = {"PKR"};


    public CurrencyFrame(String title)
    {
        super(title);

        inputText = new JTextField(10);
        add(inputText);
        inputText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toComboBox.getSelectedIndex() == 0) outText.setText(String.format("%d",Integer.parseInt(inputText.getText()) * 150));
                else outText.setText(String.format("%d",Integer.parseInt(inputText.getText())));
            }
        });

        fromComboBox = new JComboBox<String>(fromComboString);
        add(fromComboBox);
        fromComboBox.setMaximumRowCount(2);

        outText = new JTextField(10);
        outText.setEnabled(false);
        add(outText);

        toComboBox = new JComboBox<String>(toComboString);
        add(toComboBox);
        toComboBox.setMaximumRowCount(2);



        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);

        toComboBox.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent event)
            {
                if(event.getStateChange() == ItemEvent.SELECTED)
                {
                    if(toComboBox.getSelectedIndex() == 0) outText.setText(String.format("%d",Integer.parseInt(inputText.getText()) * 150));
                    else outText.setText(String.format("%d",Integer.parseInt(inputText.getText())));
                }
            }
        });
    }
}