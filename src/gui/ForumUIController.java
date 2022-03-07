/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import G_Community_interface.ICommentaireService;
import G_Community_interface.IPublicationService;
import G_Community_model.commentaire;

import G_Community_model.publication;

import G_Community_service.CommentaireService;
import G_Community_service.PublicationService;
import java.awt.Color;
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

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ForumUIController implements Initializable {

    @FXML
    private ListView<String> Lnom;
    @FXML
    private ListView<String> Lpub;
    @FXML
    private ListView<String> Lcomment;
    @FXML
    private TextArea topic;
    @FXML
    private Label Erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IPublicationService ip = new PublicationService();
        ICommentaireService ic = new CommentaireService();
//        for (int i = 0; i < ip.trieSelonUsers().size(); i++) {
//            Lpub.getItems().add(ip.trieSelonUsers().get(i));
//        }
        for (int i = 0; i < ip.trieSelonUser().size(); i++) {
            Lnom.getItems().add(ip.trieSelonUser().get(i));
            Lnom.getItems().add(ip.iduser().get(i).toString());
        }
//        for (int i = 0; i < ic.ShowAllComments().size(); i++) {
//            Lcomment.getItems().add(ic.ShowAllComments().get(i).toString());
//        }
    }


    private void GotoMiniGames(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("Front_Quiz.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
       
    }

    private void GoTotournement(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("Front_Salle.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    private void logOut(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("FirstFXML.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    @FXML
    private void ajouterPub(ActionEvent event) {
        IPublicationService ip = new PublicationService();
        try {
            publication p = new publication(0, 0, topic.getText());
            ip.ajouterPublication(p, 6);

            topic.setText("");

        } catch (Exception e) {

        }

    }

    private void reloadPub(ActionEvent event) {
        PublicationService ps = new PublicationService();
        String s = Lnom.getSelectionModel().getSelectedItem();
        System.out.println(s);

    }

    @FXML
    private void getPub(MouseEvent event) {
        PublicationService ps = new PublicationService();
        Lpub.getItems().clear();

        try {
            Erreur.setText("");
            System.out.println(Lnom.getSelectionModel().getSelectedItem());
            for (int i = 0; i < ps.CountUserPub(Integer.parseInt(Lnom.getSelectionModel().getSelectedItem())).size(); i++) {
                Lpub.getItems().add(ps.CountUserPub(Integer.parseInt(Lnom.getSelectionModel().getSelectedItem())).get(i).toString());
            }
        } catch (Exception e) {
            Erreur.setText("Choose an ID Please !!");
            Erreur.setTextFill(javafx.scene.paint.Color.web("RED"));

        }

    }

    @FXML
    private void getComment(MouseEvent event) {
        ICommentaireService ic = new CommentaireService();

        Lcomment.getItems().clear();
        String id_pub = Lpub.getSelectionModel().getSelectedItem();
        String id1 = Character.toString(id_pub.charAt(0));
        String id2 = Character.toString(id_pub.charAt(1));
        id_pub = id1 + id2;
        try {
            for (int i = 0; i < ic.showComments(Integer.parseInt(id_pub)).size(); i++) {
                Lcomment.getItems().add(ic.showComments(Integer.parseInt(id_pub)).get(i).getCommentaire().toString());
            }

        } catch (Exception e) {
        }
    }

    @FXML
    private void ModifyPub(ActionEvent event) {
        String id_pub = Lpub.getSelectionModel().getSelectedItem();
        PublicationService ps = new PublicationService();
        String id1 = Character.toString(id_pub.charAt(0));
        String id2 = Character.toString(id_pub.charAt(1));
        id_pub = id1 + id2;
        ps.modifyPub(Integer.parseInt(id_pub), topic.getText());

        Erreur.setText("Modification Avec Success");
        Erreur.setTextFill(javafx.scene.paint.Color.web("GREEN"));

    }

    @FXML
    private void DeletePub(ActionEvent event) {
        try {
            String id_pub = Lpub.getSelectionModel().getSelectedItem();
            PublicationService ps = new PublicationService();
            String id1 = Character.toString(id_pub.charAt(0));
            String id2 = Character.toString(id_pub.charAt(1));
            id_pub = id1 + id2;
            ps.deletePub(Integer.parseInt(id_pub));
            Erreur.setText("DELTE DONE");
            Erreur.setTextFill(javafx.scene.paint.Color.web("WHITE"));
        } catch (Exception e) {

        }
    }

    @FXML
    private void ajouterCommentaire(ActionEvent event) {
        ICommentaireService ic = new CommentaireService();
        try {
            String id_pub = Lpub.getSelectionModel().getSelectedItem();
            String id1 = Character.toString(id_pub.charAt(0));
            String id2 = Character.toString(id_pub.charAt(1));
            id_pub = id1 + id2;
            commentaire c = new commentaire(topic.getText());
            ic.addComment(c, Integer.parseInt(id_pub), 6);
            Erreur.setText("Commented !");
            Erreur.setTextFill(javafx.scene.paint.Color.web("GREEN"));

        } catch (Exception e) {
            Erreur.setText("Erreur");
        }

    }



    private void News(ActionEvent event) throws IOException {
         Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("NEWS.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    private void commande(ActionEvent event) throws IOException {
         Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("Front_Commande.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
        
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("AccuilUI.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }

}
