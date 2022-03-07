/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.produit;
import service.ServiceProduit;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Front_produitCrontroller implements Initializable {

    @FXML
    private Pane pnl_salle;
    @FXML
    private ScrollPane scrollpane_Salle;
    @FXML
    private HBox hbox_salle;
    static int id_produit_static=0;
    
    private int taille_produit=0;
    private ServiceProduit SP = new ServiceProduit();
    private int indiceProduit=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             List<produit> ls = SP.afficher();
         taille_produit=ls.size();
    Node[] nodes_produit = new Node[taille_produit];
        scrollpane_Salle.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceProduit = 0; indiceProduit < taille_produit; indiceProduit++) {
            try {
                System.out.println("ss");
id_produit_static=ls.get(indiceProduit).getId_produit();
                nodes_produit[indiceProduit] = FXMLLoader.load(getClass().getResource("/gui/Item_Produit.fxml"));
  hbox_salle.getChildren().add(nodes_produit[indiceProduit]);
               
            } catch (IOException e) {

            }
        }
    }    

    @FXML
    private void backss(ActionEvent event) throws IOException {
         Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("AccuilUI.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
        
        
    }
    
}
