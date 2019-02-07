import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class DirSelect  implements WindowListener {
    static private JPanel pane1;
    static private JButton DirectoryPathButton;
    static private JTextArea textPane1;
    static private JTextField DirecotryPath;

    static private File DirectoryPath = new File(System.getProperty("user.dir")) ;
    static private File location;
    static private File SaveToLocation = new File(System.getProperty("user.dir")) ;

    DirSelectForm d;

    JFileChooser DirectoryChoose = new JFileChooser();

    String DirectoryPathChooserTitle = "Select a path";

    public DirSelect() {
        DirSelectSetup();
        SetupActions();
    }

    private void DirSelectSetup() {
        d = new DirSelectForm();

        pane1 = d.getPane1();
        DirectoryPathButton = d.getDirectoryPathButton();
        textPane1 = d.getTextPane1();
        DirecotryPath = d.getDirecotryPath();
        DirecotryPath.setText(DirectoryPath.toString());
        DirecotryPath.setEditable(true);
        DirecotryPath.addFocusListener(new PathChangeViaTextF());

        d.addWindowListener(this);


    }
    public void Show() {
        d.setVisible(true);
    }

    private void SetupActions() {
        DirectoryPathButton.addActionListener(new PathChangeViaButton());
        DirecotryPath.addActionListener(new PathChangeViaText());
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowOpened(WindowEvent e) {
    }
    public void windowClosed(WindowEvent e) {
    }
    public void windowIconified(WindowEvent e) {
    }
    public void windowDeiconified(WindowEvent e) {
    }
    public void windowActivated(WindowEvent e) {
    }
    public void windowDeactivated(WindowEvent e) {
    }

    static public void UpdateText(String text)
    {
       textPane1.append(text);
    }

    public class PathChangeViaTextF implements FocusListener {
        @Override
        public void focusLost(FocusEvent e) {
            if(!location.exists())
            {
                location = DirectoryPath;
                DirecotryPath.setText(DirectoryPath.toString());
                System.out.println("Path override");
            }
        }

        @Override
        public void focusGained(FocusEvent e) {

        }
    }

    public class PathChangeViaButton implements ActionListener {
        public void actionPerformed(ActionEvent a)
        {
            DirectoryChoose.setCurrentDirectory(DirectoryPath);
            DirectoryChoose.setDialogTitle(DirectoryPathChooserTitle);
            DirectoryChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            DirectoryChoose.setAcceptAllFileFilterUsed(false);
            if (DirectoryChoose.showOpenDialog(d) == JFileChooser.APPROVE_OPTION)
            {
                location = DirectoryChoose.getSelectedFile();
                if(!location.exists())
                {
                    System.out.println("Error invalid path");
                }
                else
                {
                    System.out.println("Path Changed");
                    DirectoryPath = location;
                    DirecotryPath.setText(DirectoryPath.toString());
                }
            }
            else {
                System.out.println("No Selection ");
            }
        }
    }

    public class PathChangeViaText implements ActionListener {
        public void actionPerformed(ActionEvent a)
        {
            location = new File(DirecotryPath.getText());
            if(!location.exists())
            {
                System.out.println("Error invalid path");
            }
            else
            {
                System.out.println("Path Changed");
                DirectoryPath = location;
                DirecotryPath.setText(DirectoryPath.toString());
            }
            /*DirReader First = new DirReader(location.toString());
            UpdateText("\n\n\tFiles and Folders: "+First.CheckDir(location.toString(),0));
            try {
                First.StoreToFile("Test.txt");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }*/
        }
    }
}




