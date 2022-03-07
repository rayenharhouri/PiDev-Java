/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.Salle_service;
import model.Salle_jeu;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Item_salleController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label libelle;
    @FXML
    private Label label_prix;
    @FXML
    private Label gouv;
    @FXML
    private Label nom;
    Salle_service SS = new Salle_service();
     Salle_jeu t = SS.get_Salle_jeu_affichage(Front_SalleCrontroller.indiceSalle);
     static int id_salle_tournoi = 0;
    @FXML
    private ImageView image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
   
        nom.setText(t.getNomSalleJ());
        gouv.setText(t.getGouvernorat());
         String ImageUrl = "http://localhost/img"+t.getNomSalleJ()+".png";
            Image img = new Image(ImageUrl);
             image.setImage(img);
            
        // TODO
    }    

    @FXML
    private void tournoi(ActionEvent event) throws IOException {
           
                 id_salle_tournoi=t.getId_salleJ();
            
           Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Front_Tournoi.fxml")));
            stage.setScene(scene);
            stage.show();
    }
    
}
