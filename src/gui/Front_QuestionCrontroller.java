/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Alert.AlertDialog;
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
import model.question;
import service.QuestionService;

/**
 * FXML Controller class
 *
 * @author habib
 */
public class Front_QuestionCrontroller implements Initializable {

    @FXML
    private Pane pnl_quess;
    @FXML
    private ScrollPane scrollpane_ques;
    @FXML
    private HBox hbox_quess;
    @FXML
    private Button btn_Quiz;
    @FXML
    private Button btn_Sign_Out;
    @FXML
    private ImageView image_user;
    @FXML
    private Label username;
    QuestionService QS = new QuestionService();
     private int taille_questions = 0;
   static int indicequestions = 0;
   static int id_question_apartir_quiz=0;
  
    private List<question> questonss = QS.start_quiz(Item_quizController.quiz_static.getId_quizs());
    @FXML
    private Button btn_resultat;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
      
            taille_questions = questonss.size();
            System.out.println(questonss);
       
       
        Node[] nodes_quess = new Node[taille_questions];
        scrollpane_ques.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indicequestions = 0; indicequestions < taille_questions; indicequestions++) {
            try {
id_question_apartir_quiz=questonss.get(indicequestions).getId_question();
                nodes_quess[indicequestions] = FXMLLoader.load(getClass().getResource("/gui/Item_Question.fxml"));

                hbox_quess.getChildren().add(nodes_quess[indicequestions]);
            } catch (IOException e) {

            }
        }
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
           if (event.getSource() == btn_Quiz) {
               Front_QuizCrontroller.score_final=0;
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Front_Quiz.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    private void resultat(ActionEvent event) throws Exception {
        
        AlertDialog.showNotification("Resultat final", "Votre resultat est : "+Front_QuizCrontroller.score_final, AlertDialog.image_checked);
         Front_QuizCrontroller.score_final=0;
         
     
               

    }
    
}
