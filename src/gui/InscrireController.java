/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IutilisateurService;
import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import model.Utilisateur;
import service.UtilisateurService;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Pos;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class InscrireController implements Initializable {
    
     final FileChooser fileChooser =new FileChooser();
        final Desktop desktop =Desktop.getDesktop();
    
    @FXML
    private TextField tfnom;
      @FXML
    private TextField tfprenom;
          @FXML
    private TextField tfusername;
          @FXML
      private TextField tfemail;
            @FXML
    private PasswordField tfpass;
     
      @FXML
    private TextField tfbestgame;
      @FXML
    private TextField tfequipe;
    @FXML
    private VBox tfpasswod;
    @FXML
    private TextField L_contenu;
    
    
      
      
    
      
  
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        // TODO
    }    
    @FXML
    public void inscrire(ActionEvent event){
         UtilisateurService us=new UtilisateurService();
         System.out.println(tfnom.getText().toString());
         System.out.println(tfprenom.getText().toString());
          System.out.println(tfusername.getText().toString());
         System.out.println(tfemail.getText().toString());
         System.out.println(tfbestgame.getText().toString());
         System.out.println(tfpass.getText().toString());
         System.out.println(tfequipe.getText().toString());
                  System.out.println(L_contenu.getText().toString());

         
         
         int equipe=Integer.parseInt(tfequipe.getText().toString());
         if(tfnom.getText().isEmpty() || tfprenom.getText().isEmpty() || tfbestgame.getText().isEmpty() ||tfpass.getText().isEmpty() || tfemail.getText().isEmpty() || tfequipe.getText().isEmpty())
         {  Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("problem");
                alert.setHeaderText(null);
                alert.setContentText(" champs vide ou login utilisé");
                alert.showAndWait();}
         else {
             int opt=JOptionPane.showConfirmDialog(null, "confirm this account", "confirm", JOptionPane.YES_NO_OPTION);
             
             if(opt==0)
             {
                
         
       Utilisateur u=new Utilisateur(tfnom.getText().toString(),tfprenom.getText().toString(),tfusername.getText().toString(),tfemail.getText().toString(),tfbestgame.getText().toString(),tfpass.getText().toString(),equipe,L_contenu.getText().toString());
        us.ajouterUtilisateur(u);
         Notifications notificationBuilder = Notifications.create()
                    .title("alert").text("compte ajouté").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER_LEFT)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("valider");
                    });

            notificationBuilder.darkStyle();
            notificationBuilder.show();
             }

    
    
    }
    }

    @FXML
    private void select(ActionEvent event) {
           L_contenu.clear();
                fileChooser.setTitle("Select image");

                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "Documents\\NetBeansProjects\\projet_melek_boussif\\src\\gui\\assets\\"));
                File file = fileChooser.showOpenDialog(null);

                if (file != null) {
                    List<File> files = Arrays.asList(file);
                    L_contenu.setText(file.getAbsolutePath());
                }
            }
        
       
        
}
    


  
