/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IutilisateurService;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Utilisateur;
import service.UtilisateurService;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Utilisateur;
import service.UtilisateurService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class profilcontroller implements Initializable {

    @FXML
    private TextField profil_name;
    @FXML
    private TextField profil_lastname;
    @FXML
    private TextField profil_email;
    @FXML
    private TextField profil_username;
    @FXML
    private Button button_save_profil;
    @FXML
    private Label label_id_utilisateur;
    @FXML
    private TextField profil_bestgame;
    Parent fxml;
    @FXML
    private ImageView tfimage;
    
    private double x, y;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOI
    
    }

    void setUtilisateur(Utilisateur u) {
        profil_name.setText(u.getNom());
        profil_lastname.setText(u.getPrenom());
        profil_username.setText(u.getLogin());
        profil_email.setText(u.getEmail());
        profil_bestgame.setText(u.getBestgame());
        label_id_utilisateur.setText(String.valueOf(u.getID()));

    }

    @FXML
    private void modifier_profil_final(ActionEvent event) {
        Utilisateur u = new Utilisateur();
        u.setEmail(profil_email.getText());
        u.setNom(profil_lastname.getText());
        u.setPrenom(profil_name.getText());
        u.setBestgame(profil_bestgame.getText());

        IutilisateurService us = new UtilisateurService();
        System.out.println(this.label_id_utilisateur.getText());
        int opt=JOptionPane.showConfirmDialog(null, "confirm modification", "confirm", JOptionPane.YES_NO_OPTION);
             
             if(opt==0)
             {

        us.modifierUtilisateur1(Integer.parseInt(this.label_id_utilisateur.getText()), u);
        UtilisateurService x = new UtilisateurService();

//        System.out.println(user);
//        File file = new File(user.getImage());
//        System.out.println(file);
//        Image image = new Image(file.toURI().toString());
//        tfimage.setImage(image);
        profil_lastname.setDisable(true);
        profil_name.setDisable(true);
        profil_email.setDisable(true);
        profil_bestgame.setDisable(true);
        button_save_profil.setVisible(false);
             }

    }

    @FXML
    private void modifier_profil(ActionEvent event) {
        if (profil_name.isDisable()) {

            profil_lastname.setDisable(false);

            profil_name.setDisable(false);
            profil_email.setDisable(false);
            profil_bestgame.setDisable(false);

            button_save_profil.setVisible(true);
        } else {

            profil_lastname.setDisable(true);

            profil_name.setDisable(true);
            profil_email.setDisable(true);
            profil_bestgame.setDisable(true);

            button_save_profil.setVisible(false);
        }

    }

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstFXML.fxml"));
        fxml = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void acceuil(ActionEvent event) throws IOException {
          Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AccuilUI.fxml")));
            stage.setScene(scene);
            stage.show();
    }
            
              }
             
            
    
    
    


