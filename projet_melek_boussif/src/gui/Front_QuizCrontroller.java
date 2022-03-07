/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import service.QuizzService;

/**
 * FXML Controller class
 *
 * @author habib
 */
public class Front_QuizCrontroller implements Initializable {

    @FXML
    private Pane pnl_quizs;
    @FXML
    private ScrollPane scrollpane_quiz;
    @FXML
    private HBox hbox_quizs;
    @FXML
    private Button btn_Quiz;
    @FXML
    private Button btn_Sign_Out;
    @FXML
    private ImageView image_user;
    @FXML
    private Label username;
    QuizzService QS = new QuizzService();
     private int taille_quizs = 0;
   static int indiceQuiz = 0;
    static int score_final=0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      QS.ModifierQuizz_resultat();
       
            taille_quizs = QS.afficherQuizz().size();
       
        Node[] nodes_quiz = new Node[taille_quizs];
        scrollpane_quiz.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceQuiz = 0; indiceQuiz < taille_quizs; indiceQuiz++) {
            try {

                nodes_quiz[indiceQuiz] = FXMLLoader.load(getClass().getResource("/gui/Item_Quiz.fxml"));

                hbox_quizs.getChildren().add(nodes_quiz[indiceQuiz]);
            } catch (IOException e) {

            }
        }
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
         
    }
    
}
