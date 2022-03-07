/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.Front_CommandeCrontroller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Commande;
import service.Commandeservice;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Item_CommandeController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label prix;
    @FXML
    private TextField txt_quantite;
    Commandeservice CS = new Commandeservice();
    Commande co = CS.get_Commande_affichage(Front_CommandeCrontroller.id_commande_item);
    @FXML
    private Label total;
    @FXML
    private Button btn_Calculer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      txt_quantite.setText(String.valueOf(co.getQte()));
        
      prix.setText(String.valueOf(co.getPrix_Total() ) + " DT");
        
        
    }    


    @FXML
    private void Calculer(ActionEvent event) {
        total.setText(String.valueOf( Integer.valueOf(txt_quantite.getText())*co.getPrix_Total() ) + " DT" );
    }
    
}
