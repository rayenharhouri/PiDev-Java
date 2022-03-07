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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.quiz;
import service.QuestionService;
import service.QuizzService;

/**
 * FXML Controller class
 *
 * @author habib
 */
public class home_QuizController implements Initializable {

    
    @FXML
    private VBox vboxdrawer;
    @FXML
    private ImageView imagechange;
    @FXML
    private Label fullName;
    @FXML
    private Button btn_affichage;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnl_quiz;
    @FXML
    private TableView<quiz> tabview;
    @FXML
    private TableColumn<quiz, String> col_matiere;
    @FXML
    private TableColumn<quiz, String> col_diff;
    @FXML
    private TableColumn<quiz, String> col_image;
    @FXML
    private TableColumn<quiz, Integer> col_id;
    @FXML
    private TextField txt_matiere;
    @FXML
    private TextField txt_difficulte;
    @FXML
    private Button btn_ajout;
    private TableColumn<quiz, String> col_btnDelet;
    private TableColumn<quiz, String> col_btnQuess;
    QuizzService QS = new QuizzService();
      QuestionService Ques_service = new QuestionService();
          
    private quiz Quiz = null;
    static int id_quiz=0;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          tabview.setEditable(true);
      Modifier();
       setCellfromtabletoQuiz();
       
        try { 
            refreche();
        } catch (SQLException ex) {
         }
        
        
        
        
        
        
        col_btnDelet = new TableColumn("Supprimer");
              javafx.util.Callback<TableColumn<quiz, String>, TableCell<quiz, String>> cellFactory
                = new Callback<TableColumn<quiz, String>, TableCell<quiz, String>>() {
            public TableCell call(final TableColumn<quiz, String> param) {
                final TableCell<quiz, String> cell = new TableCell<quiz, String>() {

                    final Button btn = new Button("supprimer");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                quiz u = getTableView().getItems().get(getIndex());
                              
                              
                                    QS.SupprimerQuizz(u.getId_quizs());
                                        AlertDialog.showNotification("supprimer", "supprimer", AlertDialog.image_checked);
                               
                                try {
                                    refreche();
                                } catch (SQLException ex) {
                                 }

                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
              
                  col_btnQuess = new TableColumn("Questions");
              javafx.util.Callback<TableColumn<quiz, String>, TableCell<quiz, String>> cellFactoryQues
                = new Callback<TableColumn<quiz, String>, TableCell<quiz, String>>() {
            public TableCell call(final TableColumn<quiz, String> param) {
                final TableCell<quiz, String> cell = new TableCell<quiz, String>() {

                    final Button btn = new Button("Questions");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                quiz u = getTableView().getItems().get(getIndex());
                              id_quiz=u.getId_quizs();
                              
                
                                try {
                                                       Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene;
                                    scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Home_Question.fxml")));
                                      stage.setScene(scene);
            stage.show();  
                                } catch (IOException ex) {
                                    Logger.getLogger(home_QuizController.class.getName()).log(Level.SEVERE, null, ex);
                                }
          
                               
                            

                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        col_btnDelet.setCellFactory(cellFactory);
        tabview.getColumns().add(col_btnDelet);
           col_btnQuess.setCellFactory(cellFactoryQues);
        tabview.getColumns().add(col_btnQuess);
    }    
    
    
     public void refreche() throws SQLException {

        col_matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
          col_matiere.setCellFactory(TextFieldTableCell.<quiz> forTableColumn());
        col_diff.setCellValueFactory(new PropertyValueFactory<>("difficulte"));
         col_diff.setCellFactory(TextFieldTableCell.<quiz> forTableColumn());
        col_image.setCellValueFactory(new PropertyValueFactory<>("image"));
                  col_image.setCellFactory(TextFieldTableCell.<quiz> forTableColumn());
       
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_quizs"));

        tabview.getItems().clear();

        tabview.setItems(QS.afficherQuizz());

    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException { 
    
    
        
    }

    @FXML
    private void ajouter_quiz(ActionEvent event) throws SQLException {
          if (txt_matiere.getText().equals("")) {
               AlertDialog.showNotification("Error !", "Champ vide de txt_matiere", AlertDialog.image_cross);
    
        
           
        } else if (txt_matiere.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur txt_matiere !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
          
        }
           else   if (txt_difficulte.getText().equals("")) {
                  AlertDialog.showNotification("Error !", "Champ vide de txt_difficulte", AlertDialog.image_cross);
    
           
        } else if (txt_difficulte.getText().matches("^[0-9]+$")) {
                 AlertDialog.showNotification("Erreur txt_difficulte !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
      
           
        }
        else {
            quiz q = new quiz("",txt_matiere.getText(), txt_difficulte.getText(), 0);
            QS.AjouterQuizz(q);
            refreche();
                AlertDialog.showNotification("Ajout", "Ajout", AlertDialog.image_checked);
      
        }
    }
      public void Modifier()
    {
         
                   
                  
                   
            
        
               
                col_matiere.setOnEditCommit((TableColumn.CellEditEvent<quiz, String> event) -> {
            TablePosition<quiz, String> pos = event.getTablePosition();
                
            String matiere = event.getNewValue();
                 
            int row = pos.getRow();
            quiz q = event.getTableView().getItems().get(row);
           
  
            q.setMatiere(matiere);
                 
                        QS.ModifierQuizz(q,q.getId_quizs());
                 
        });
                   
                col_diff.setOnEditCommit((TableColumn.CellEditEvent<quiz, String> event) -> {
            TablePosition<quiz, String> pos = event.getTablePosition();
                
            String diff = event.getNewValue();
                 
            int row = pos.getRow();
            quiz q = event.getTableView().getItems().get(row);
           
  
            q.setDifficulte(diff);
                 
                        QS.ModifierQuizz(q,q.getId_quizs());
                 
        });
                   
                col_image.setOnEditCommit((TableColumn.CellEditEvent<quiz, String> event) -> {
            TablePosition<quiz, String> pos = event.getTablePosition();
                
            String image = event.getNewValue();
                 
            int row = pos.getRow();
            quiz q = event.getTableView().getItems().get(row);
           
  
            q.setImage(image);
                 
                        QS.ModifierQuizz(q,q.getId_quizs());
                 
        });
    }

 
        private void setCellfromtabletoQuiz() {
        tabview.setOnMouseClicked(e -> {

            Quiz  = tabview.getItems().get(tabview.getSelectionModel().getSelectedIndex());
           
        

      
        }
        );

    }
}
