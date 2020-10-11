import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorPicker {

    protected JColorChooser jcc;
    protected Color c;

    public ColorPicker()
    {
        jcc = new JColorChooser();
        jcc.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                c = jcc.getSelectionModel().getSelectedColor();
            }
        });
        jcc.setPreviewPanel(new JPanel());
    }
}
