/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IfactureService;
import interfaces.IfactureService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Facture;
import service.FactureService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLController implements Initializable {

    @FXML
    private Pane pnFacture;
    @FXML
    private TextField tfsearch;
    @FXML
    private TableView<Facture> tvfacture;
    @FXML
    private TableColumn<?, ?> coladresse;
    @FXML
    private TableColumn<?, ?> coltotal;
    @FXML
    private TextField tfadresse;
    @FXML
    private HBox combofacture;
    @FXML
    private TextField tfuser;
    @FXML
    private TextField erreur;
    @FXML
    private TextField tffacture;
    @FXML
    private TextField tfadresse1;
    @FXML
    private Button btnCommande;
    @FXML
    private Button btnretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnFacture.toFront();
        fnShowFacture();
    }    

    @FXML
    private void btnAjouter(ActionEvent event) {
        IfactureService ip = new FactureService();
        try{
            
          
            Facture f = new Facture(tfadresse.getText(), 525);
            
            //System.out.println(f);
            String a = tfuser.getText();
            ip.AjouterFacture(f,Integer.parseInt(a));
            ip.AjouterFacture(f,2);
            erreur.setText("Ajout avec success");
    }
        catch(Exception e){
            erreur.setText("Erreur");
        
    }}

    @FXML
    private void btnModifier(ActionEvent event) {
        IfactureService ip = new FactureService();
        try {
            String a = tfadresse1.getText();
            ip.ModififierFacture(a,Integer.parseInt(tffacture.getText()));
            erreur.setText("succées de modification");
        } catch (Exception e) {
            erreur.setText("Erreur  ");
        }

    }

    @FXML
    private void btnSuprimer(ActionEvent event) {
        IfactureService ip = new FactureService();
        try {
            String a = tfuser.getText();
            ip.SupprimerFacture(Integer.parseInt(a));
            erreur.setText("Supression avec success");
            
        } catch (Exception e) {
            erreur.setText("Erreur");
  
        }
    }
    
    public void fnShowFacture(){
        FactureService sr= new FactureService() {};
        List espaceList = sr.AfficherFacture();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse_livraison")); 
     coltotal.setCellValueFactory(new PropertyValueFactory<>("total_apres_reduction"));   
      
        tvfacture.getItems().clear();
        tvfacture.setItems(list);
         FilteredList<Facture> filteredData = new FilteredList<>(list, b -> true);
		
		tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(p -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getAdresse_livraison().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else if (String.valueOf(p.getTotal_apres_reduction()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Facture> sortedData = new SortedList<>(filteredData);
                
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvfacture.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvfacture.setItems(sortedData);
        tvfacture.setRowFactory(tv -> new TableRow<Facture>() {
    @Override
    protected void updateItem(Facture item, boolean empty) {
        
 
        
    }
});
               

               

    }

    @FXML
    private void btnCommande(ActionEvent event) throws IOException {
         Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene); 
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("affichage.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }
      
    
    
}

