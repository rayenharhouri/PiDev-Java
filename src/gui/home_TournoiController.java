/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Alert.AlertDialog;
import service.Salle_service;
import service.tournoi_service;
import model.Salle_jeu;
import model.tournoi;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class home_TournoiController implements Initializable {

    @FXML
    private VBox vboxdrawer;
    @FXML
    private Button btn_affichage;
    @FXML
    private Button btn_tournoi;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnl_tournoi;
    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<tournoi> tabview;
    @FXML
    private TableColumn<tournoi, String> col_nom;
    @FXML
    private TableColumn<tournoi, Float> col_prix;
    @FXML
    private TableColumn<tournoi, String> col_Type_jeu;
    @FXML
    private TableColumn<tournoi, Date> col_date;
    @FXML
    private TableColumn<tournoi, Integer> col_nb_equipe;
    @FXML
    private TableColumn<tournoi, Integer> col_id;
    @FXML
    private TextField txt_nnb_equipe;
    @FXML
    private Button btn_ajout;
    @FXML
    private TextField txt_type_jeu;
    @FXML
    private DatePicker datetournoi;
    @FXML
    private TextField txt_prix;
    @FXML
    private ComboBox<Integer> combo_salle;
        private TableColumn<tournoi, String> col_btnDelet;
Salle_service salle_service = new Salle_service();
    tournoi_service ts = new tournoi_service();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         combo_salle.setItems(salle_service.get_ids_salle_jeux());
        combo_salle.getSelectionModel().select(0);
           tabview.setEditable(true);
        Modifier();
        search();
         try { 
            refreche();
        } catch (SQLException ex) {
           }
         col_btnDelet = new TableColumn("Supprimer");
              javafx.util.Callback<TableColumn<tournoi, String>, TableCell<tournoi, String>> cellFactory
                = new Callback<TableColumn<tournoi, String>, TableCell<tournoi, String>>() {
            public TableCell call(final TableColumn<tournoi, String> param) {
                final TableCell<tournoi, String> cell = new TableCell<tournoi, String>() {

                    final Button btn = new Button("supprimer");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                tournoi u = getTableView().getItems().get(getIndex());
                             
                             

                                try {
                                    ts.Supprimer(u.getId_tournoi());
                                } catch (SQLException ex) {
                                 }
                                    AlertDialog.showNotification("Supressin !", "Supressin", AlertDialog.image_checked);
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
    public void refreche() throws SQLException {

        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_salle"));
       
        col_Type_jeu.setCellValueFactory(new PropertyValueFactory<>("type_jeu"));
         col_Type_jeu.setCellFactory(TextFieldTableCell.<tournoi> forTableColumn());
          col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
    
         col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
      
         col_nb_equipe.setCellValueFactory(new PropertyValueFactory<>("nombre_equipre"));
        col_nb_equipe.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
      
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_tournoi"));

        tabview.getItems().clear();

        tabview.setItems(ts.Affichertout());

    }
     public void search() {
        txt_Seach.setOnKeyReleased(e
                -> {
            if (txt_Seach.getText().equals("") ) {

                try {
                    refreche();
                } catch (SQLException ex) {
                }

            } else {

                try {
                 
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_salle"));
         
        col_Type_jeu.setCellValueFactory(new PropertyValueFactory<>("type_jeu"));
         col_Type_jeu.setCellFactory(TextFieldTableCell.<tournoi> forTableColumn());
          col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
    
         col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
      
         col_nb_equipe.setCellValueFactory(new PropertyValueFactory<>("nombre_equipre"));
        col_nb_equipe.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
      
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_tournoi"));

        tabview.getItems().clear();

        tabview.getItems().clear();

                    tabview.setItems(ts.serach(txt_Seach.getText()));

                } catch (SQLException ex) {
                }
        

            }
        }
        );

    }
    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
           if (event.getSource() == btn_affichage) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Home_Salle.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }
    private void handleClicks1(ActionEvent event) throws IOException {
           if (event.getSource() == btn_affichage) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/affichage.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    private void ajouter_tournoi(ActionEvent event) throws SQLException {
         if (txt_nnb_equipe.getText().equals("")) {
                   AlertDialog.showNotification("Error !", "Champ vide de txt_nnb_equipe", AlertDialog.image_cross);
      
             
        } else if (txt_nnb_equipe.getText().matches("^[a-zA-Z]+$")) {
            
                   AlertDialog.showNotification("Error !", "txt_nnb_equipe incorrect", AlertDialog.image_cross);
           
          
        } else if (Integer.valueOf(txt_nnb_equipe.getText()) <= 0) {
              AlertDialog.showNotification("Error !", "Champ de txt_nnb_equipe incorrect", AlertDialog.image_cross);
                  
          
        }
         else if (datetournoi.getValue() == null ) {
                AlertDialog.showNotification("Error !", "Champ vide de datetournoi", AlertDialog.image_cross);
               
        
        } 
         else if (txt_type_jeu.getText().equals("")) {
                     AlertDialog.showNotification("Error !", "Champ vide de txt_type_jeu", AlertDialog.image_cross);
               
             
         
        } else if (txt_type_jeu.getText().matches("^[0-9]+$")) {
             AlertDialog.showNotification("Error !", "Champ de txt_type_jeu incorrect", AlertDialog.image_cross);
             
                
        
        }
         else if (txt_prix.getText().equals("")) {
               AlertDialog.showNotification("Error !", "Champ vide de Prix", AlertDialog.image_cross);
           
            
          
        } 
         else if (txt_prix.getText().matches("^[a-zA-Z]+$")) {
                    AlertDialog.showNotification("Error !", "Champ de txt_prix incorrect", AlertDialog.image_cross);
       
        
        }
        else if (Float.valueOf(txt_prix.getText()) <= 0) {
               AlertDialog.showNotification("Error !", "Champ de txt_prix incorrect", AlertDialog.image_cross);
       
         
        } 
        else
        {
                    Date dd = new java.sql.Date(new Date(datetournoi.getEditor().getText()).getTime());
            tournoi t = new tournoi(Integer.parseInt(txt_nnb_equipe.getText()), (java.sql.Date) dd, txt_type_jeu.getText(), Float.parseFloat(txt_prix.getText()), combo_salle.getSelectionModel().getSelectedItem());
       ts.Ajouter(t);
       refreche();
         AlertDialog.showNotification("Ajout !", "Ajout", AlertDialog.image_checked);
       
        }
        
    }
        public void Modifier()
    {
              col_Type_jeu.setOnEditCommit((TableColumn.CellEditEvent<tournoi, String> event) -> {
            TablePosition<tournoi, String> pos = event.getTablePosition();
                
            String type_jeu = event.getNewValue();
                 
            int row = pos.getRow();
            tournoi s = event.getTableView().getItems().get(row);
           
  
            s.setType_jeu(type_jeu);
                    try {
                        ts.Modifier(s,s.getId_tournoi());
                    } catch (SQLException ex) {
                     }
        });
                   col_nb_equipe.setOnEditCommit((TableColumn.CellEditEvent<tournoi, Integer> event) -> {
            TablePosition<tournoi, Integer> pos = event.getTablePosition();
           
            Integer nb_equipe = event.getNewValue();
                  
            int row = pos.getRow();
            tournoi t = event.getTableView().getItems().get(row);
          
  
            t.setNombre_equipre(nb_equipe);
                    try {
                        ts.Modifier(t,t.getId_tournoi());
                    } catch (SQLException ex) {
                    }
        });  
                       col_prix.setOnEditCommit((TableColumn.CellEditEvent<tournoi, Float> event) -> {
            TablePosition<tournoi, Float> pos = event.getTablePosition();
           
            Float Prix = event.getNewValue();
                  
            int row = pos.getRow();
            tournoi ab = event.getTableView().getItems().get(row);
          
  
            ab.setPrix(Prix);
                    try {
                        ts.Modifier(ab,ab.getId_tournoi());
                    } catch (SQLException ex) {
                    }
        });
                          col_date.setOnEditCommit((TableColumn.CellEditEvent<tournoi, Date> event) -> {
            TablePosition<tournoi, Date> pos = event.getTablePosition();
           
            Date date = event.getNewValue();
     
 
      
         java.sql.Date dd=  new java.sql.Date(  date.getTime());
            int row = pos.getRow();
            tournoi ab = event.getTableView().getItems().get(row);
          
  
            ab.setDate(dd);
                    try {
                       ts.Modifier(ab,ab.getId_tournoi());
                    } catch (SQLException ex) {
                    }
        });  
            
    }

    @FXML
    private void baaack(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("affichage.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }
}
