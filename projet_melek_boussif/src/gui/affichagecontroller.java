/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import static javafx.scene.control.ButtonBar.ButtonData.LEFT;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Equipe;
import model.Utilisateur;
import org.controlsfx.control.Notifications;
import service.EquipeService;
import service.UtilisateurService;
import util.MaConnexion;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class affichagecontroller implements Initializable {
    
    static java.sql.Connection cnx = MaConnexion.getInstance().getCnx();

    @FXML
    private ListView<Utilisateur> affichage;
    @FXML
    private TextField tfidsupprim;
    @FXML
    private TextField cherche;
    
    Parent fxml;
    
      //  final ObservableList<Utilisateur> utilisateurs = FXCollections.observableArrayList();
    
  //  ObservableList<Utilisateur> utilisateurs;
   // Statement st=null;
   // ResultSet rs=null;
   // UtilisateurService us=new UtilisateurService();
    
   // public void affiche(){
   //  utili=us.afficherUtilisateurs();
    //    affichage.getItems().setAll(utili);
    //}
    @FXML
    private TabPane affiche;
    @FXML
    private ListView<Equipe> affichage_e;
    @FXML
    private TextField tf_chercher_e;
    @FXML
    private TextField tf_supprim_e;
    @FXML
    private TextField titres;
  
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void supprimer(ActionEvent event) {
                 UtilisateurService us=new UtilisateurService();

        System.out.println(tfidsupprim.getText().toString());
         
         
         int id=Integer.parseInt(tfidsupprim.getText().toString());
         us.supprimerUtilisateurs(id);
         
    }

    @FXML
    private void trier(ActionEvent event) {
         UtilisateurService hs = new UtilisateurService();
        affichage.getItems().addAll(hs.trierUtilisateursid());

        
        
    }

    @FXML
    private void chercher(ActionEvent event) {
        UtilisateurService hs = new UtilisateurService();
        System.out.println(cherche.getText().toString());
        
        affichage.getItems().addAll(hs.chercherUtilisateursid(cherche.getText().toString()));
        

    }
    
    @FXML
    private void afficher(ActionEvent event) {
       
          UtilisateurService hs = new UtilisateurService();
        affichage.getItems().addAll(hs.afficherUtilisateurs());
         Notifications notificationBuilder = Notifications.create()
                    .title("information").text("affichage terminé").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("valider");
                    });

            notificationBuilder.darkStyle();
            notificationBuilder.show();
                
    
    }

    @FXML
    private void trier_e(ActionEvent event) {
         EquipeService hs = new EquipeService();
        affichage_e.getItems().addAll(hs.trierequipe());
        
    }

    @FXML
    private void afficher_e(ActionEvent event) {
         EquipeService hs = new EquipeService();
        affichage_e.getItems().addAll(hs.afficherEquipe());
        
        
    }

    @FXML
    private void chercher_e(ActionEvent event) {
         EquipeService hs = new EquipeService();
        System.out.println(tf_chercher_e.getText().toString());
        
        affichage_e.getItems().addAll(hs.chercherequipe(tf_chercher_e.getText().toString()));
    }

    @FXML
    private void supprimer_e(ActionEvent event) {
         EquipeService us=new EquipeService();

        System.out.println(tf_supprim_e.getText().toString());
         
         
         int id=Integer.parseInt(tf_supprim_e.getText().toString());
         us.supprimerEquipe(id);
         
        
    }

    @FXML
    private void exit(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    private void actualiser(ActionEvent event) throws IOException {
        
          affichage_e.getItems().clear();
        
    }

    @FXML
    private void modifier_e(ActionEvent event) {
        
        
         EquipeService hs = new EquipeService();
        Equipe h = new Equipe();
        try {

            String sql = " UPDATE equipe SET titres=? WHERE id_e=?";
            PreparedStatement pst = cnx.prepareStatement(sql);
            Equipe selectedItem = affichage_e.getSelectionModel().getSelectedItem();

            pst.setInt(1, Integer.parseInt(titres.getText()));
            pst.setInt(2, selectedItem.getId_e());

            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("titres modifié!");
                alert.showAndWait();

            }
        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }

//        L_afficher 
        affichage_e.getItems().clear();
        affichage_e.getItems().addAll(hs.afficherEquipe());
        titres.setText("");
      

    }

    @FXML
    private void gestionquiz(ActionEvent event) throws IOException {
         Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Home_Quiz.fxml")));
            stage.setScene(scene);
            stage.show();
        
        
    }

    @FXML
    private void loadAdmin(ActionEvent event) throws IOException {
         Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("UIAdminForum.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }
    
}
