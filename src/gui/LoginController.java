/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Utilisateur;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class LoginController implements Initializable {
 @FXML
    private VBox vbox ;
    private Parent fxml;
    @FXML
    private TextField Username;
     @FXML
    private PasswordField Password;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    public void connect(ActionEvent event) throws IOException {
       
     
        Utilisateur u=new Utilisateur();
         UtilisateurService us=new UtilisateurService();
         System.out.println(Username.getText().toString());
         System.out.println(Password.getText().toString());
         if(us.login(Username.getText(),Password.getText()))
         {
             FXMLLoader loader;
             u=us.getUtilisateur(Username.getText(),Password.getText());
              if(u.getRole().equals("client"))
              {
             System.out.println("connected");             
              loader = new FXMLLoader(getClass().getResource("profil.fxml"));
              fxml=loader.load();
             profilcontroller profilcontroller=loader.getController();
             profilcontroller.setUtilisateur(u);
              }
              else
              {
               loader = new FXMLLoader(getClass().getResource("affichage.fxml"));
               fxml=loader.load();
             affichagecontroller dashboardController=loader.getController();
            
              }
             
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxml);
             stage.setScene(scene);
             stage.show();
              
         }
         else {
             
             System.out.println("erreur");
         }
    }
    @FXML
    public void pass(ActionEvent event) throws IOException
    {
          fxml = FXMLLoader. load (getClass ().getResource ("resetpassword.fxml"));
        vbox.getChildren ().removeAll ();
       vbox.getChildren (). setAll (fxml);
    }
}
