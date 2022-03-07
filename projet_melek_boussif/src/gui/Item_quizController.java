/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.quiz;
import service.QuizzService;

/**
 * FXML Controller class
 *
 * @author habib
 */
public class Item_quizController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label matiere_txt;
    @FXML
    private Label diff_txt;
    @FXML
    private ImageView image_qr;
    
    private QuizzService QS = new QuizzService();
    static quiz quiz_static = null;
    @FXML
    private Button btn_start;
    private String ImageUrl = "http://localhost/img/";
    
   

   /* public void setImage_qr(ImageView image_qr) {
        this.image_qr = image_qr;
    }

    public void setImage(Image image) {
        this.image = image;
    }
*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quiz_static = QS.get_quiz_affichage(Front_QuizCrontroller.indiceQuiz);
        Image image = new Image(ImageUrl + quiz_static.getImage());

        image_qr.setImage(image);
        diff_txt.setText(quiz_static.getDifficulte());
        matiere_txt.setText(quiz_static.getMatiere());
   
    }

    @FXML
    private void start(ActionEvent event)  {
        try{
            
            Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        //stage.setMaximized(true);
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Front_Question.fxml")));
        stage.setScene(scene);
        stage.show();}
        
        catch(IOException ex){
            ex.printStackTrace();
            
        }
                
    }

}
