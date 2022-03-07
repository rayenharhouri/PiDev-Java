/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Commande;
import service.Commandeservice;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLfrontController implements Initializable {

    @FXML
    private TextField tfquantite;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfidproduit;
    @FXML
    private TextField tfiduser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAjouter(ActionEvent event) {
         Commandeservice cs = new Commandeservice() {
        };
        Commande c = new Commande();

        c.setQte(Integer.parseInt(tfquantite.getText()));
        c.setPrix_Total(Integer.parseInt(tfprix.getText()));
        String a = tfidproduit.getText();
        String a1 = tfiduser.getText();

        cs.AjouterCommande(c, Integer.parseInt(a1), Integer.parseInt(a));
    }
    
}
