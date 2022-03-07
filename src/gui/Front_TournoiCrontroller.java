/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.tournoi_service;
import model.tournoi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Front_TournoiCrontroller implements Initializable {

    @FXML
    private Pane pnl_Tournoi;
    @FXML
    private ScrollPane scrollpane_Tournoi;
    @FXML
    private HBox hbox_tournoi;
    @FXML
    private ImageView image_user;
    @FXML
    private Label username;
  private int taille_tournoi = 0;
  private int indiceTournoi = 0;
  static int id_tournoi_static =0;
    tournoi_service TS = new tournoi_service();
    @FXML
    private Button btn_Salle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
            List<tournoi> listT = TS.Affichertout_salle(Item_salleController.id_salle_tournoi);
            System.out.println(listT);
                 taille_tournoi = listT.size();
     
        Node[] nodes_tournoi = new Node[taille_tournoi];
        scrollpane_Tournoi.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceTournoi = 0; indiceTournoi < taille_tournoi; indiceTournoi++) {
            try {
                id_tournoi_static=listT.get(indiceTournoi).getId_tournoi();

                nodes_tournoi[indiceTournoi] = FXMLLoader.load(getClass().getResource("/GUI/Item_Tournoi.fxml"));

                hbox_tournoi.getChildren().add(nodes_tournoi[indiceTournoi]);
            } catch (IOException e) {

            }
        }
        } catch (SQLException ex) {
        }
  
               
       
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
           if (event.getSource() == btn_Salle) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Front_Salle.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }
    
}
