package e_laab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Habib
 */
public class FXMLController implements Initializable {

    @FXML
    private AnchorPane vbox;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField tfqm;
    @FXML
    private TextField tftheme;
    @FXML
    private TextField tfdifficulte;
    @FXML
    private TextField tfresultat;
    @FXML
    private ListView<?> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierQuiz(ActionEvent event) {
    }

    @FXML
    private void supprimerQuiz(ActionEvent event) {
    }

    @FXML
    private void afficher(ActionEvent event) {
    }
    
}
