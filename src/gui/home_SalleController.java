/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Alert.AlertDialog;
import service.Salle_service;
import model.Salle_jeu;
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
import javafx.scene.control.ComboBox;
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

/**
 * FXML Controller class
 *
 * @author HP
 */
public class home_SalleController implements Initializable {

    @FXML
    private VBox vboxdrawer;
    @FXML
    private ImageView imagechange;
    @FXML
    private Label fullName;
    @FXML
    private Button btn_affichage;
    @FXML
    private Button btn_tournoi;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnl_salle_de_jeux;
    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<Salle_jeu> tabview;
    @FXML
    private TableColumn<Salle_jeu, String> col_nom;
    @FXML
    private TableColumn<Salle_jeu, String> col_Gouvernorat;
    @FXML
    private TableColumn<Salle_jeu, Integer> col_id;
    @FXML
    private TextField txt_nom;
    @FXML
    private Button btn_ajout;
     private TableColumn<Salle_jeu, String> col_btnDelet;
Salle_service salle_service = new Salle_service();
    @FXML
    private TextField txt_gouvernorat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tabview.setEditable(true);
        Modifier();
        search();
         try { 
            refreche();
        } catch (SQLException ex) {
           }
         col_btnDelet = new TableColumn("Supprimer");
              javafx.util.Callback<TableColumn<Salle_jeu, String>, TableCell<Salle_jeu, String>> cellFactory
                = new Callback<TableColumn<Salle_jeu, String>, TableCell<Salle_jeu, String>>() {
            public TableCell call(final TableColumn<Salle_jeu, String> param) {
                final TableCell<Salle_jeu, String> cell = new TableCell<Salle_jeu, String>() {

                    final Button btn = new Button("supprimer");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Salle_jeu u = getTableView().getItems().get(getIndex());
                             
                             

                                try {
                                    salle_service.Supprimer(u.getId_salleJ());
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

        col_nom.setCellValueFactory(new PropertyValueFactory<>("nomSalleJ"));
          col_nom.setCellFactory(TextFieldTableCell.<Salle_jeu> forTableColumn());
        col_Gouvernorat.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
         col_Gouvernorat.setCellFactory(TextFieldTableCell.<Salle_jeu> forTableColumn());
       
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_salleJ"));

        tabview.getItems().clear();

        tabview.setItems(salle_service.Affichertout());

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
                 
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nomSalleJ"));
          col_nom.setCellFactory(TextFieldTableCell.<Salle_jeu> forTableColumn());
        col_Gouvernorat.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
         col_Gouvernorat.setCellFactory(TextFieldTableCell.<Salle_jeu> forTableColumn());
       
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_salleJ"));

        tabview.getItems().clear();

                    tabview.setItems(salle_service.serach(txt_Seach.getText()));

                } catch (SQLException ex) {
                }
        

            }
        }
        );

    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
            if (event.getSource() == btn_tournoi) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Home_Tournoi.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    private void ajouter_salle_de_jeux(ActionEvent event) throws SQLException {
         if (txt_nom.getText().equals("")) {
          
              AlertDialog.showNotification("Error !", "Champ vide de txt_nom", AlertDialog.image_cross);
             
       } else if (txt_nom.getText().matches("^[0-9]+$")) {
             
                 AlertDialog.showNotification("Error !", "il faut saisir des caracteres", AlertDialog.image_cross);
         
        }
         else   if (txt_gouvernorat.getText().equals("")) {
               AlertDialog.showNotification("Error !", "Champ vide de txt_gouvernorat", AlertDialog.image_cross);
           
       
       } else if (txt_nom.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Error !", "il faut saisir des caracteres", AlertDialog.image_cross);
         
        }
       else{
           Salle_jeu s = new Salle_jeu(txt_nom.getText(), txt_gouvernorat.getText());
           salle_service.Ajouter(s);
          refreche(); 
                AlertDialog.showNotification("Ajout !", "Ajout", AlertDialog.image_checked);
                        
       }
      
      
    }
       public void Modifier()
    {
              col_nom.setOnEditCommit((TableColumn.CellEditEvent<Salle_jeu, String> event) -> {
            TablePosition<Salle_jeu, String> pos = event.getTablePosition();
                
            String nom = event.getNewValue();
                 
            int row = pos.getRow();
            Salle_jeu s = event.getTableView().getItems().get(row);
           
  
            s.setNomSalleJ(nom);
                    try {
                        salle_service.Modifier(s,s.getId_salleJ());
                    } catch (SQLException ex) {
                     }
        });
                    col_Gouvernorat.setOnEditCommit((TableColumn.CellEditEvent<Salle_jeu, String> event) -> {
            TablePosition<Salle_jeu, String> pos = event.getTablePosition();
                
            String gouvernorat = event.getNewValue();
                 
            int row = pos.getRow();
            Salle_jeu s = event.getTableView().getItems().get(row);
           
  
            s.setGouvernorat(gouvernorat);
                    try {
                        salle_service.Modifier(s,s.getId_salleJ());
                    } catch (SQLException ex) {
                     }
        });
    }
    
}
