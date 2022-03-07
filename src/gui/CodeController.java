/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author melek
 */
public class CodeController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private TextField codi;
         private Parent fxml;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newpassword(ActionEvent event) throws IOException {
                 
        UtilisateurService us=new UtilisateurService();
      Utilisateur uverif=new Utilisateur();
      System.out.println(codi.getText().toString());
               int code=Integer.parseInt(codi.getText().toString());

         
          uverif=us.code(code);
          if(uverif.getCode()!=code){
              System.out.println("valide");
              fxml = FXMLLoader. load (getClass ().getResource ("newpassword.fxml"));
        vbox.getChildren ().removeAll ();
       vbox.getChildren (). setAll (fxml);
      
              
          }
           else {
             System.out.println("erreur");
         }
        
    }
    
}
