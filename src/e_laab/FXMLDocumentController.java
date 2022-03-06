/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_laab;

import com.mysql.jdbc.Connection;
import e_laab.services.QuizService;
import elaab.model.quiz;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import util.MaConnexion;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
 *
 * @author Habib
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField tfid;
     @FXML
    private TextField tfimage;
      @FXML
    private TextField tfqm;
       @FXML
    private TextField tftheme;
         @FXML
    private TextField tfresultat;
     
    @FXML
    private AnchorPane vbox ;
    @FXML
    private TextField tfdifficulte;
    
   
    @FXML
    private ListView<quiz> listView;
    
    ObservableList<quiz> quiz;
QuizService qi=new QuizService();
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
       }
    
   
    
    @FXML
    public void afficher (ActionEvent event){
    /*QuizService qs =new QuizService();
    listView.getItems().addAll(qs.afficherQuiz());
    */
    }
   

    public void  UpdateList(){
    quiz=qi.afficherQuiz();
    listView.getItems().setAll(quiz);
    }
    
    
    @FXML
    private void modifierQuiz(ActionEvent event) {
    /*
        try {
          
           Connection cnx = MaConnexion.getInstance().getCnx();
        
            String value1=tfimage.getText();
          String value2=tfdifficulte.getText();
              String value3=tftheme.getText();
          String req = "UPDATE `quiz` SET `image`='" + value1 + "',`difficulte`='" + value2 + "',`theme`='" + value3 +"'";
            
            PreparedStatement st = cnx.prepareStatement(req);
            st.execute();
            System.out.println("modif fait succes");
            //UpdateList();
            quiz=qi.afficherQuiz();
    listView.getItems().setAll(quiz);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
    }
    

    @FXML
    private void supprimerQuiz(){
    /*
 String req = "DELETE FROM quiz WHERE id_quiz=?";
         Connection cnx = MaConnexion.getInstance().getCnx();

        try 
        {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, tfid.getText());
           
            System.out.println("suppression fait avec succes ");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();

}

        

*/
    }
}
    

