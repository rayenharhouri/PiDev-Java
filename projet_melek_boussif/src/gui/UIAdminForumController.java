/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import G_Community_model.publication;
import G_Community_service.PublicationService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class UIAdminForumController implements Initializable {

    @FXML
    private ListView<String> LAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PublicationService ps = new PublicationService();
        for (int i = 0; i < ps.afficherPub().size(); i++) {
            LAdmin.getItems().add(ps.afficherPub().get(i).getId_pub() + ps.afficherPub().get(i).getTopic().toString().toUpperCase());
        }

    }

    @FXML
    private void GotoForum(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("ForumUI.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    @FXML
    private void GotoStore(ActionEvent event) {
    }

    @FXML
    private void GotoMiniGames(ActionEvent event) {
    }

    @FXML
    private void GoTotournement(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
    }

    @FXML
    private void delete_pub(ActionEvent event) {
        PublicationService ps = new PublicationService();
        String id_pub = LAdmin.getSelectionModel().getSelectedItem();
        String id1 = Character.toString(id_pub.charAt(0));
        String id2 = Character.toString(id_pub.charAt(1));
        id_pub = id1 + id2;
        ps.deletePub(Integer.parseInt(id_pub));

    }

    @FXML
    private void Reload(ActionEvent event) {
        PublicationService ps = new PublicationService();
        LAdmin.getItems().clear();
        for (int i = 0; i < ps.afficherPub().size(); i++) {
            LAdmin.getItems().add(ps.afficherPub().get(i).getId_pub() + ps.afficherPub().get(i).getTopic().toString().toUpperCase());
        }

    }

}
