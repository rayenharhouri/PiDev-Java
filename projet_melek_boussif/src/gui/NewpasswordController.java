/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class NewpasswordController implements Initializable {

    @FXML
    private VBox vbox;
    
    @FXML
    private TextField newpwd;
    @FXML
    private TextField codii;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancel(ActionEvent event) {
         javafx.application.Platform.exit();
        
    }

    @FXML
    private void confirm(ActionEvent event) {
        UtilisateurService us=new UtilisateurService();
         System.out.println(newpwd.getText().toString());
         System.out.println(codii.getText().toString());
                  int code=Integer.parseInt(codii.getText().toString());

         us.modifierUtilisateurss(code,newpwd.getText().toString());
          Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("mot de passe changé!");
                alert.showAndWait();
         
        
    }
    
}
