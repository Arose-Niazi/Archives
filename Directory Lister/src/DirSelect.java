import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class DirSelect {
    static private JPanel pane1;
    static private JButton DirectoryPathButton;
    static private JTextArea TextBoxOutput;
    static private JTextField DirectoryPath;

    static private JButton SaveToPathButton;
    static private JCheckBox saveToFileCheckBox;
    static private JTextField FilePath;

    static private File DirectoryTo = new File(System.getProperty("user.dir")) ;
    static private File location;

    static private File SaveToLocation = new File(System.getProperty("user.dir")) ;
    static private File locationFile;

    DirSelectForm d;

    JFileChooser DirectoryChoose = new JFileChooser();

    String PathChooserTitle = "Select a path";

    public DirSelect() {
        DirSelectSetup();
        SetupActions();
    }

    private void DirSelectSetup() {
        d = new DirSelectForm();

        pane1 = d.getPane1();

        SaveToPathButton = d.getChangePathButton();

        saveToFileCheckBox = d.getSaveToFileCheckBox();
        saveToFileCheckBox.setSelected(true);

        FilePath = d.getFilePath();
        FilePath.setText(SaveToLocation.toString());
        FilePath.setEditable(true);

        DirectoryPathButton = d.getDirectoryPathButton();

        TextBoxOutput = d.getTextPane1();

        DirectoryPath = d.getDirecotryPath();
        DirectoryPath.setText(DirectoryTo.toString());
        DirectoryPath.setEditable(true);


        d.addWindowListener(new WindowActions());


    }
    public void Show() {
        d.setVisible(true);
    }

    private void SetupActions() {

        saveToFileCheckBox.addActionListener(new SaveCheckBox());

        FilePath.addFocusListener(new SaveChangeViaTextF());
        DirectoryPath.addFocusListener(new PathChangeViaTextF());

        DirectoryPathButton.addActionListener(new PathChangeViaButton());
        DirectoryPath.addActionListener(new PathChangeViaText());

        SaveToPathButton.addActionListener(new SaveChangeViaButton());
        FilePath.addActionListener(new SaveChangeViaText());
    }

    public class WindowActions implements WindowListener {
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
    }

    static public void UpdateText(String text)
    {
       TextBoxOutput.append(text);
    }

    public class PathChangeViaTextF implements FocusListener {
        @Override
        public void focusLost(FocusEvent e) {
            if(!location.exists())
            {
                location = DirectoryTo;
                DirectoryPath.setText(DirectoryTo.toString());
                System.out.println("Path override");
            }
        }

        @Override
        public void focusGained(FocusEvent e) {

        }
    }

    public class SaveChangeViaTextF implements FocusListener {
        @Override
        public void focusLost(FocusEvent e) {
            if(!locationFile.exists())
            {
                locationFile = SaveToLocation;
                FilePath.setText(SaveToLocation.toString());
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
            DirectoryChoose.setCurrentDirectory(DirectoryTo);
            DirectoryChoose.setDialogTitle(PathChooserTitle);
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
                    DirectoryTo = location;
                    DirectoryPath.setText(DirectoryTo.toString());
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
            location = new File(DirectoryPath.getText());
            if(!location.exists())
            {
                System.out.println("Error invalid path");
            }
            else
            {
                System.out.println("Path Changed");
                DirectoryTo = location;
                DirectoryPath.setText(DirectoryTo.toString());
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

    public class SaveChangeViaButton implements ActionListener {
        public void actionPerformed(ActionEvent a)
        {
            DirectoryChoose.setCurrentDirectory(SaveToLocation);
            DirectoryChoose.setDialogTitle(PathChooserTitle);
            DirectoryChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            DirectoryChoose.setAcceptAllFileFilterUsed(false);
            if (DirectoryChoose.showOpenDialog(d) == JFileChooser.APPROVE_OPTION)
            {
                locationFile = DirectoryChoose.getSelectedFile();
                if(!locationFile.exists())
                {
                    System.out.println("Error invalid path");
                }
                else
                {
                    System.out.println("Path Changed");
                    SaveToLocation = locationFile;
                    FilePath.setText(SaveToLocation.toString());
                }
            }
            else {
                System.out.println("No Selection ");
            }
        }
    }

    public class SaveChangeViaText implements ActionListener {
        public void actionPerformed(ActionEvent a)
        {
            locationFile = new File(FilePath.getText());
            if(!locationFile.exists())
            {
                System.out.println("Error invalid path");
            }
            else
            {
                System.out.println("Path Changed");
                SaveToLocation = locationFile;
                FilePath.setText(SaveToLocation.toString());
            }
        }
    }

    public class SaveCheckBox implements ActionListener {
        public void actionPerformed(ActionEvent a)
        {

            if(!saveToFileCheckBox.isSelected())
            {
                FilePath.setEditable(false);
                FilePath.setEnabled(false);
                SaveToPathButton.setEnabled(false);
            }
            else
            {
                FilePath.setEditable(true);
                FilePath.setEnabled(true);
                SaveToPathButton.setEnabled(true);
            }
        }
    }
}




