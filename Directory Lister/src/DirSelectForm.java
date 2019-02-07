import javax.swing.*;

public class DirSelectForm extends JFrame {

    private JPanel pane1;
    private JButton DirectoryPathButton;
    private JTextArea textArea1;
    private JScrollPane scroll;
    private JTextField DirecotryPath;
    private JButton changePathButton;
    private JCheckBox saveToFileCheckBox;
    private JCheckBox includeFilesCheckBox;
    private JCheckBox includeFoldersCheckBox;
    private JCheckBox checkSubFoldersCheckBox;
    private JCheckBox fileTypeDisincludeCheckBox;
    private JTextField textField2;

    public DirSelectForm() {

        setSize(500, 500);
        setContentPane(pane1);
        setLocationRelativeTo(null);

    }

    public JButton getDirectoryPathButton() {
        return DirectoryPathButton;
    }

    public JTextArea getTextPane1() {
        return textArea1;
    }

    public JPanel getPane1() {
        return pane1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JTextField getDirecotryPath() {
        return DirecotryPath;
    }

    public JButton getChangePathButton() {
        return changePathButton;
    }

    public JCheckBox getSaveToFileCheckBox() {
        return saveToFileCheckBox;
    }

    public JCheckBox getIncludeFilesCheckBox() {
        return includeFilesCheckBox;
    }

    public JCheckBox getIncludeFoldersCheckBox() {
        return includeFoldersCheckBox;
    }

    public JCheckBox getCheckSubFoldersCheckBox() {
        return checkSubFoldersCheckBox;
    }


    public JCheckBox getFileTypeDisincludeCheckBox() {
        return fileTypeDisincludeCheckBox;
    }

    public JTextField getTextField2() {
        return textField2;
    }
}

