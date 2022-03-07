/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IcommandeService;
import interfaces.IcommandeService;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Commande;
import model.Facture;
import service.Commandeservice;
import util.MaConnexion;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML2Controller implements Initializable {

    static java.sql.Connection cnx = MaConnexion.getInstance().getCnx();
    @FXML
    private ListView<Commande> lvcommande;
    @FXML
    private TextField erreur;
    @FXML
    private TextField tfquantite;
    @FXML
    private Button aff_button;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfiduser;
    @FXML
    private TextField tfidproduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAjouter(ActionEvent event) {
         lvcommande.getItems().clear();
        Commandeservice cs = new Commandeservice() {
        };
        Commande c = new Commande();

        c.setQte(Integer.parseInt(tfquantite.getText()));
        c.setPrix_Total(Integer.parseInt(tfprix.getText()));
        String a = tfidproduit.getText();
        String a1 = tfiduser.getText();

        cs.AjouterCommande(c, Integer.parseInt(a1), Integer.parseInt(a));
        lvcommande.getItems().addAll(cs.AfficherCommande());
    }

    @FXML
    private void index(MouseEvent event) {

        Commande selectedItem = lvcommande.getSelectionModel().getSelectedItem();
        tfquantite.setText(String.valueOf(selectedItem.getQte()));
        tfprix.setText(String.valueOf(selectedItem.getPrix_Total()));
        tfiduser.setText(String.valueOf(selectedItem.getId_u()));
        tfidproduit.setText(String.valueOf(selectedItem.getId_produit()));

    }

    @FXML
    private void btnModifier(ActionEvent event) {

        try {
            String sql = " UPDATE commande SET id_produit=?,qte=?, prix_Total=?,id_u =? WHERE id_commande=?";
            PreparedStatement pst = cnx.prepareStatement(sql);
            Commande selectedItem = lvcommande.getSelectionModel().getSelectedItem();

            pst.setInt(1, Integer.parseInt(tfidproduit.getText()));
            pst.setInt(2, Integer.parseInt(tfquantite.getText()));
            pst.setInt(3, Integer.parseInt(tfprix.getText()));
            pst.setInt(4, Integer.parseInt(tfiduser.getText()));
            pst.setInt(5, selectedItem.getId_commande());

            int i = pst.executeUpdate();
            if (i == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("commande modifiÃ©!");
                alert.showAndWait();
            }

        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void btnSuprimer(ActionEvent event) {
        IcommandeService hs = new Commandeservice();
        hs.SupprimerCommande(2);
        int selecteditem = lvcommande.getSelectionModel().getSelectedIndex();
        lvcommande.getItems().remove(selecteditem);
    }

    @FXML
    private void afficherCommande(ActionEvent event) {
       
        IcommandeService hs = new Commandeservice();
        lvcommande.getItems().addAll(hs.AfficherCommande());

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }


    

}
