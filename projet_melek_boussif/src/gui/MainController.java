/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author melek
 */
public class MainController implements Initializable {

    @FXML
    private VBox vbox ;
    private Parent fxml;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
TranslateTransition t = new TranslateTransition (Duration.seconds (1), vbox);
t.setToX (0);
t.play ();
t.setOnFinished ( (e) ->{
    try{
        fxml = FXMLLoader. load (getClass ().getResource ("inscrire.fxml"));
        vbox.getChildren ().removeAll ();
       vbox.getChildren (). setAll (fxml);
    }catch (IOException ex) {
    
}
});
}
    @FXML
    private void open_signup(ActionEvent event) {
     TranslateTransition t = new TranslateTransition (Duration.seconds (1), vbox);
      t.setToX (vbox.getLayoutX () * 2.5);
        t.play ();
        t.setOnFinished ( (e) ->{
    try{
        fxml = FXMLLoader. load (getClass ().getResource ("inscrire.fxml"));
        vbox.getChildren ().removeAll ();
       vbox.getChildren (). setAll (fxml);
    }catch (IOException ex) {
    
}
});
}
        @FXML
    private void open_login(ActionEvent event) {
     TranslateTransition t = new TranslateTransition (Duration.seconds (1), vbox);
t.setToX (vbox.getLayoutX () * 15);
t.play ();
t.setOnFinished ( (e) ->{
    try{
        fxml = FXMLLoader. load (getClass ().getResource ("login.fxml"));
        vbox.getChildren ().removeAll ();
       vbox.getChildren (). setAll (fxml);
    }catch (IOException ex) {
    
}
});
}

    @FXML
    private void exit(ActionEvent event) {
    }

}