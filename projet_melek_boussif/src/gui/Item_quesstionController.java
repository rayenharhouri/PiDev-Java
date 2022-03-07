/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Alert.AlertDialog;
import static gui.Front_QuestionCrontroller.id_question_apartir_quiz;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.question;
import service.QuestionService;

/**
 * FXML Controller class
 *
 * @author habib
 */
public class Item_quesstionController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Button btn_repondre;
    @FXML
    private Label txt_ques;
    @FXML
    private ComboBox<String> combo_rep;
    QuestionService QS = new QuestionService();
    question q = QS.get_question_affichage(id_question_apartir_quiz);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_ques.setText(q.getQuestion());
        combo_rep.getItems().addAll(q.getR1(), q.getR2(), q.getR3());
         combo_rep.getSelectionModel().select(0);
    }    

    @FXML
    private void repondre(ActionEvent event) {
        if(combo_rep.getSelectionModel().getSelectedItem().equals(q.getSolution()))
        {
            Front_QuizCrontroller.score_final++;
        }
         AlertDialog.showNotification("Reponse", "Reponse", AlertDialog.image_checked);
        
    }
    
}
