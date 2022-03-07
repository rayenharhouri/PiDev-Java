/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class NEWSController implements Initializable {

    private WebEngine webEngine;
    private StackPane root;
    @FXML
    private WebView WView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        webEngine = WView.getEngine();
        webEngine.load("https://esportsinsider.com");
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
    private void GotoForum(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("ForumUI.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }


}
