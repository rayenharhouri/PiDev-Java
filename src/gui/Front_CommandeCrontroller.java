/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Commande;
import service.Commandeservice;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Front_CommandeCrontroller implements Initializable {

    @FXML
    private Pane pnl_Commande;
    @FXML
    private ScrollPane scrollpane_Commande;
    @FXML
    private HBox hbox_commande;
    @FXML
    private Button btn_Commande;
    @FXML
    private ImageView image_user;
    @FXML
    private Label username;
    Commandeservice CS = new Commandeservice();
      private int taille_commande = 0;
       private int indiceCommande = 0;
       static int id_commande_item=0;
    @FXML
    private Button Commander;
       

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
 List<Commande> CL = CS.AfficherCommande_user(23);
         
            taille_commande = CL.size();
          
        
        Node[] nodes_commandes = new Node[taille_commande];
        scrollpane_Commande.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceCommande = 0; indiceCommande < taille_commande; indiceCommande++) {
            try {

                id_commande_item = CL.get(indiceCommande).getId_commande();
                nodes_commandes[indiceCommande] = FXMLLoader.load(getClass().getResource("/gui/Item_Commande.fxml"));

                hbox_commande.getChildren().add(nodes_commandes[indiceCommande]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
   
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("AccuilUI.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    @FXML
    private void Commander(ActionEvent event) throws IOException {
           Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Front_Facture.fxml")));
            stage.setScene(scene);
            stage.show();
    }
    
}
