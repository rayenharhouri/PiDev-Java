/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Utilisateur;
import service.UtilisateurService;
import util.mail;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class ResetpasswordController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private TextField Username;

    private Parent fxml;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    

    @FXML
    private void sendmail(ActionEvent event) throws SQLException, Exception {
        
        
         UtilisateurService us=new UtilisateurService();
      Utilisateur uverif=new Utilisateur();
         System.out.println(Username.getText().toString());
          uverif=us.verification(Username.getText().toString());
         if(uverif.getEmail()!="")
         {
             
             System.out.println("valide");
            int code= us.generer(uverif.getID());
             
             mail.sendMail(uverif.getEmail(), code);
            fxml = FXMLLoader. load (getClass ().getResource ("code.fxml"));
        vbox.getChildren ().removeAll ();
       vbox.getChildren (). setAll (fxml);
        
            
             
         }
         else {
             System.out.println("erreur");
         }
        
       
    }
    
}
