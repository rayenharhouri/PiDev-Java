/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.Salle_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Front_SalleCrontroller implements Initializable {

    @FXML
    private Pane pnl_salle;
    @FXML
    private ScrollPane scrollpane_Salle;
    @FXML
    private HBox hbox_salle;
    @FXML
    private ImageView image_user;
    @FXML
    private Label username;
      private int taille_salle = 0;
  static int indiceSalle = 0;
  
    Salle_service SS = new Salle_service();
    @FXML
    private Button btn_Salle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      try {
           
            taille_salle = SS.Affichertout().size();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        Node[] nodes_salle = new Node[taille_salle];
        scrollpane_Salle.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceSalle = 0; indiceSalle < taille_salle; indiceSalle++) {
            try {

                nodes_salle[indiceSalle] = FXMLLoader.load(getClass().getResource("/gui/Item_Salle.fxml"));

                hbox_salle.getChildren().add(nodes_salle[indiceSalle]);
            } catch (IOException e) {

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
    
}
