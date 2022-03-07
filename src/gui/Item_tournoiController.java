/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.tournoi_service;
import static gui.Front_TournoiCrontroller.id_tournoi_static;
import model.tournoi;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Item_tournoiController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label nbr_eqp;
    @FXML
    private Label date;
    @FXML
    private Label libelle;
    @FXML
    private Label label_prix;
    @FXML
    private Label prix;
    @FXML
    private Label type;
    tournoi_service TS = new tournoi_service();
     tournoi t = TS.get_tournoi_affichage(Front_TournoiCrontroller.id_tournoi_static);
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Front_TournoiCrontroller.id_tournoi_static);
   
        date.setText(String.valueOf(t.getDate()));
        prix.setText(String.valueOf(t.getPrix()));
        nbr_eqp.setText(String.valueOf(t.getNombre_equipre()));
        type.setText(t.getType_jeu());
        // TODO
    }    

   
}
