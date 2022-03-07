/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.produit;
import service.ServiceProduit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Item_produitController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label libelle;
    @FXML
    private Label label_prix;
    @FXML
    private Label prix;
    @FXML
    private Label quantite;
    @FXML
    private ImageView image;
ServiceProduit SP = new ServiceProduit();
    private produit p = SP.get_produit(Front_produitCrontroller.id_produit_static);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          System.out.println("jj");
          prix.setText(String.valueOf(p.getPrix()));
           quantite.setText(String.valueOf(p.getQuantite()));
     
         String ImageUrl = "http://localhost/images/"+p.getImage();
            Image img = new Image(ImageUrl);
             image.setImage(img);
    }    

    @FXML
    private void commander(ActionEvent event) {
    }
    
}
