/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcome;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Arose
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    void HandlingMouse(MouseEvent event) {
        
        String s = textfield1.getText();
        textfield1.setText(textfield2.getText());
        textfield2.setText(s);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
