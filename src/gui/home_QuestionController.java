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
import model.question;
import model.quiz;
import service.QuestionService;
import service.QuizzService;

/**
 * FXML Controller class
 *
 * @author habib
 */
public class home_QuestionController implements Initializable {

    @FXML
    private VBox vboxdrawer;
    @FXML
    private ImageView imagechange;
    @FXML
    private Label fullName;
    @FXML
    private Button btn_quiz;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnl_question;
    @FXML
    private TableView<question> tabview;
    @FXML
    private TableColumn<question, String> col_question;
    @FXML
    private TableColumn<question, String> col_matiere;
    @FXML
    private TableColumn<question, String> col_r1;
    @FXML
    private TableColumn<question, String> col_r2;
    @FXML
    private TableColumn<question, String> col_r3;
    @FXML
    private TableColumn<question, String> col_solution;
    @FXML
    private TableColumn<question, String> col_Diffi;
    @FXML
    private TableColumn<question, Integer> col_id;
    @FXML
    private TextField txt_Question;
    @FXML
    private TextField txt_matiere;
    @FXML
    private TextField txt_r1;
    @FXML
    private Button btn_ajout;
    @FXML
    private TextField txt_r3;
    @FXML
    private TextField txt_r2;
    @FXML
    private TextField txt_solution;
    @FXML
    private TextField txt_diff;
            private TableColumn<question, String> col_btnDelet;
         
          QuestionService Ques_service = new QuestionService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabview.setEditable(true);
    Modifier();
     
        try { 
            refreche();
        } catch (SQLException ex) {
         }
        
        
        
        
        
        
        col_btnDelet = new TableColumn("Supprimer");
              javafx.util.Callback<TableColumn<question, String>, TableCell<question, String>> cellFactory
                = new Callback<TableColumn<question, String>, TableCell<question, String>>() {
            public TableCell call(final TableColumn<question, String> param) {
                final TableCell<question, String> cell = new TableCell<question, String>() {

                    final Button btn = new Button("supprimer");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                question u = getTableView().getItems().get(getIndex());
                              
                                 AlertDialog.showNotification("supprimer", "supprimer", AlertDialog.image_checked);
                                    Ques_service.Supprimerquest(u.getId_question());
                               
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
        col_btnDelet.setCellFactory(cellFactory);
        tabview.getColumns().add(col_btnDelet);
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {  
        if (event.getSource() == btn_quiz) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Home_Quiz.fxml")));
            stage.setScene(scene);
            stage.show();

        }
        
    }

    @FXML
    private void ajouter_Question(ActionEvent event) throws SQLException {
        
        
         if (txt_matiere.getText().equals("")) {
                  AlertDialog.showNotification("Error !", "Champ vide de txt_matiere", AlertDialog.image_cross);
      
            
        }
         else if (txt_Question.getText().equals("")) {
                  AlertDialog.showNotification("Error !", "Champ vide de txt_Question", AlertDialog.image_cross);
      
           
           
        }
          else if (txt_diff.getText().equals("")) {
                 AlertDialog.showNotification("Error !", "Champ vide de txt_diff", AlertDialog.image_cross);
      
           
        }
          else if (txt_solution.getText().equals("")) {
              AlertDialog.showNotification("Error !", "Champ vide de txt_solution", AlertDialog.image_cross);
      
             
           
        }
          else if (txt_r1.getText().equals("")) {
               AlertDialog.showNotification("Error !", "Champ vide de txt_r1", AlertDialog.image_cross);
      
           
        }
          else if (txt_r2.getText().equals("")) {
               AlertDialog.showNotification("Error !", "Champ vide de txt_r2", AlertDialog.image_cross);
      
           
        }
          else if (txt_r3.getText().equals("")) {
               AlertDialog.showNotification("Error !", "Champ vide de txt_r3", AlertDialog.image_cross);
      
        }
          else {
              
              question q = new question();
              q.setDifficulte(txt_diff.getText());
                q.setMatiere(txt_matiere.getText());
                 q.setQuestion(txt_Question.getText());
                  q.setSolution(txt_solution.getText());
                   q.setR1(txt_r1.getText());
                    q.setR2(txt_r2.getText());
                     q.setR3(txt_r3.getText());
                     q.setId_quizs(home_QuizController.id_quiz);
                  Ques_service.Ajouterquest(q);
                  refreche();
                     AlertDialog.showNotification("ajout", "ajout", AlertDialog.image_checked);
          }
        
        
    }
       public void refreche() throws SQLException {
        
 

           
        col_matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
          col_matiere.setCellFactory(TextFieldTableCell.<question> forTableColumn());
        col_Diffi.setCellValueFactory(new PropertyValueFactory<>("difficulte"));
         col_Diffi.setCellFactory(TextFieldTableCell.<question> forTableColumn());
        col_solution.setCellValueFactory(new PropertyValueFactory<>("solution"));
                  col_solution.setCellFactory(TextFieldTableCell.<question> forTableColumn());
                         col_question.setCellValueFactory(new PropertyValueFactory<>("question"));
                  col_question.setCellFactory(TextFieldTableCell.<question> forTableColumn());
                    col_r1.setCellValueFactory(new PropertyValueFactory<>("R1"));
                  col_r1.setCellFactory(TextFieldTableCell.<question> forTableColumn());
                    col_r2.setCellValueFactory(new PropertyValueFactory<>("R2"));
                  col_r2.setCellFactory(TextFieldTableCell.<question> forTableColumn());
                    col_r3.setCellValueFactory(new PropertyValueFactory<>("R3"));
                  col_r3.setCellFactory(TextFieldTableCell.<question> forTableColumn());
  
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_question"));

        tabview.getItems().clear();

        tabview.setItems(Ques_service.afficherquest_Quiz(home_QuizController.id_quiz));

    }
        public void Modifier()
    {
         
                   
                  
                   
            
        
               
                col_matiere.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String matiere = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
            q.setMatiere(matiere);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                        col_Diffi.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String diff = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
            q.setDifficulte(diff);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                                col_question.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String ques = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
            q.setQuestion(ques);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                                        col_solution.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String sol = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
            q.setSolution(sol);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                                                col_r1.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String r1 = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
            q.setR1(r1);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                                                        col_r2.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String r2 = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
      q.setR2(r2);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                                                                col_r3.setOnEditCommit((TableColumn.CellEditEvent<question, String> event) -> {
            TablePosition<question, String> pos = event.getTablePosition();
                
            String r3 = event.getNewValue();
                 
            int row = pos.getRow();
            question q = event.getTableView().getItems().get(row);
           
  
            q.setR3(r3);
                 
                        Ques_service.Modifierquest(q.getId_question(),q);
                 
        });
                   
           
    }

    @FXML
    private void start_quiz(ActionEvent event) throws SQLException {
        
     
        
        
    }
}
