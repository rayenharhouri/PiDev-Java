/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.fournisseur;
import model.produit;
import service.AlertBox;
import service.ServiceFournisseur;
import service.ServiceProduit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class back_controller implements Initializable {

    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<produit> tvProduit;
    @FXML
    private TableColumn<produit, String> colType;
    @FXML
    private TableColumn<produit, Integer> colQuantity;
    @FXML
    private TableColumn<produit, Float> colPrix;
    @FXML
    private TableColumn<produit, fournisseur> colFrounisseur;
    @FXML
    private Label lbIdFournisseur;
    @FXML
    private Label lbidProduit;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfQuantity;
    @FXML
    private TextField tfPrix;
    @FXML
    private ComboBox<String> ComboFournisseur;
    @FXML
    private Button bntAjout;
    @FXML
    private Button btnModif;
    @FXML
    private Button btnSupp;
    @FXML
    private TableView<fournisseur> tvFournisseur;
    @FXML
    private TableColumn<fournisseur, String> colNom;
    @FXML
    private TableColumn<fournisseur, Integer> colNum;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNum;
    @FXML
    private Button bntAjoutFour;
    @FXML
    private Button btnModifFour;
    @FXML
    private Button btnSuppFour;
    @FXML
    private TextField tfSearchFour;
    @FXML
    private Label lbProduit;
    @FXML
    private Label lbFournisseur;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnProduit;
    @FXML
    private Pane pnFournisseur;
    @FXML
    private Label lbIdProd;
    @FXML
    private Label lbIdFour;
    @FXML
    private Button btnPDF;
    @FXML
    private ImageView imageview;
     private String nomImage = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceFournisseur serP=new ServiceFournisseur();
        List<String> listPay=FXCollections.observableArrayList();
        for(int i=0;i<serP.afficher().size();i++){
        listPay.add(serP.afficher().get(i).getNom_fournisseur());
        }
        ObservableList<String> pays=FXCollections.observableArrayList(listPay);
                
        ComboFournisseur.setItems(pays);
        pnProduit.toFront();
        fnShowFournisseur();
        fnShowProduit();
        // TODO
    }    

    @FXML
    private void fnSelected(MouseEvent event) {
        produit p=tvProduit.getSelectionModel().getSelectedItem();
        tfPrix.setText(String.valueOf(p.getPrix()));
        tfQuantity.setText(String.valueOf(p.getQuantite()));
        tfType.setText(p.getType_produit());
        ComboFournisseur.setValue(p.getNom());
        lbIdProd.setText(String.valueOf(p.getId_produit()));
    }

    @FXML
    private void fnAjout(ActionEvent event) {
         try {
            ServiceProduit serP=new ServiceProduit();
        produit p=new produit();
        p.setPrix(Float.parseFloat(tfPrix.getText()));
        p.setQuantite(Integer.parseInt(tfQuantity.getText()));
        p.setType_produit(tfType.getText());
        ServiceFournisseur serF=new ServiceFournisseur();
        fournisseur f=serF.getFournisseurByNom(ComboFournisseur.getValue());
        p.setId_fournisseur(f);
        p.setImage(nomImage);
        serP.ajouter(p);
        fnShowProduit();
        tfQuantity.setText("");
        tfPrix.setText("");
        tfType.setText("");
        ComboFournisseur.setValue(null);
         InputStream inStream = null;
    OutputStream outStream = null;
     try{

            File afile =new File("./src/images/"+nomImage);
            File bfile =new File("C:/wamp64/www/images/"+nomImage);
            

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[]buffer = new byte[1024];

            int length;
           //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

            System.out.println("File is copied successful!");

        }catch(Exception e){
 
        }
        } catch (java.lang.NumberFormatException e) {
            AlertBox.display("Erreur", "Entree une quantitée et un prix valide !!");
        }
    }

    @FXML
    private void fnModif(ActionEvent event) {
        ServiceProduit serP=new ServiceProduit();
        produit p=tvProduit.getSelectionModel().getSelectedItem();
        if(lbIdProd.getText().equals("")){
            AlertBox.display("Erreur", "Choissir un fournisseur !!");
        }else{
            
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {try {
            
        
        p.setPrix(Float.parseFloat(tfPrix.getText()));
        p.setQuantite(Integer.parseInt(tfQuantity.getText()));
        p.setType_produit(tfType.getText());
        ServiceFournisseur serF=new ServiceFournisseur();
        fournisseur f=serF.getFournisseurByNom(ComboFournisseur.getValue());
        p.setId_fournisseur(f);
        serP.modifier(p);
        fnShowProduit();
        tfQuantity.setText("");
        tfPrix.setText("");
        tfType.setText("");
        ComboFournisseur.setValue(null);
        } catch (java.lang.NumberFormatException e) {
            AlertBox.display("Erreur", "Entree une quantitée et un prix valide !!");
        }}else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }}
    }

    @FXML
    private void fnSupp(ActionEvent event) {
        ServiceProduit serP=new ServiceProduit();
        produit p=tvProduit.getSelectionModel().getSelectedItem();
        if(lbIdProd.getText().equals("")){
            AlertBox.display("Erreur", "Choissir un fournisseur !!");
        }else{
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        
        
        serP.supprimer(p.getId_produit());
        fnShowFournisseur();
        fnShowProduit();        
        tfQuantity.setText("");
        tfPrix.setText("");
        tfType.setText("");
        ComboFournisseur.setValue(null);
        }else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }}
    }

    @FXML
    private void fnSelectedFour(MouseEvent event) {
        fournisseur f=tvFournisseur.getSelectionModel().getSelectedItem();
        tfNom.setText(f.getNom_fournisseur());
        tfNum.setText(String.valueOf(f.getNum_tel()));
        lbIdFour.setText(String.valueOf(f.getId_fournisseur()));
    }

    @FXML
    private void fnAjoutFour(ActionEvent event) {
        try {
            ServiceFournisseur serF=new ServiceFournisseur();
        fournisseur f=new fournisseur();
        f.setNom_fournisseur(tfNom.getText());
        f.setNum_tel(Integer.parseInt(tfNum.getText()));
        serF.ajouter(f);
        fnShowFournisseur();
        tfNom.setText("");
        tfNum.setText("");
        } catch (java.lang.NumberFormatException e) {
            AlertBox.display("Erreur", "Entree un numero valide !!");
        }
        
    }

    @FXML
    private void fnModifFour(ActionEvent event) {
        
        fournisseur f=tvFournisseur.getSelectionModel().getSelectedItem();
        if(lbIdFour.getText().equals("")){
            AlertBox.display("Erreur", "Choissir un fournisseur !!");
        }else{
            
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        try{
        ServiceFournisseur serF=new ServiceFournisseur();
        
        f.setNom_fournisseur(tfNom.getText());
        f.setNum_tel(Integer.parseInt(tfNum.getText()));
        serF.modifier(f);
        fnShowFournisseur();
        tfNom.setText("");
        tfNum.setText("");
        } catch (java.lang.NumberFormatException e) {
            AlertBox.display("Erreur", "Entree un numero valide !!");
        }
        }else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }}
        
        
    }

    @FXML
    private void fnSuppFour(ActionEvent event) {
        fournisseur f=tvFournisseur.getSelectionModel().getSelectedItem();
        if(lbIdFour.getText().equals("")){
            AlertBox.display("Erreur", "Choissir un fournisseur !!");
        }else{
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        
        ServiceFournisseur serF=new ServiceFournisseur();
        
        f.setNom_fournisseur(tfNom.getText());
        f.setNum_tel(Integer.parseInt(tfNum.getText()));
        serF.supprimer(f.getId_fournisseur());
        fnShowFournisseur();
        fnShowProduit();
        tfNom.setText("");
        tfNum.setText("");
        }else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }}
        
        
    }

    @FXML
    private void fnProduit(MouseEvent event) {
        pnProduit.toFront();
    }

    @FXML
    private void fnFournisseur(MouseEvent event) {
        pnFournisseur.toFront();
    }

    @FXML
    private void fnRetour(MouseEvent event) throws IOException {
         Stage nouveauStage;
        Parent root = FXMLLoader.load(getClass().getResource("affichage.fxml"));
        nouveauStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        nouveauStage.setScene(scene);
    }
    
    public void fnShowFournisseur(){
        ServiceFournisseur sr= new ServiceFournisseur() {};
        List espaceList = sr.afficher();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colNom.setCellValueFactory(new PropertyValueFactory<>("nom_fournisseur")); 
     colNum.setCellValueFactory(new PropertyValueFactory<>("num_tel"));   
        
        tvFournisseur.setItems(list);
         FilteredList<fournisseur> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearchFour.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(p -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getNom_fournisseur().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else if (String.valueOf(p.getNum_tel()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<fournisseur> sortedData = new SortedList<>(filteredData);
	
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
                
		sortedData.comparatorProperty().bind(tvFournisseur.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvFournisseur.setItems(sortedData);
        tvFournisseur.setRowFactory(tv -> new TableRow<fournisseur>() {
    @Override
    protected void updateItem(fournisseur item, boolean empty) {
        
 
        
    }
});
    }
    // public void
    
    public void fnShowProduit(){
        ServiceProduit sr= new ServiceProduit() {};
        List espaceList = sr.afficher();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colType.setCellValueFactory(new PropertyValueFactory<>("type_produit")); 
     colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));   
      colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantite"));  
      colFrounisseur.setCellValueFactory(new PropertyValueFactory<>("id_fournisseur"));
        
        tvProduit.setItems(list);
         FilteredList<produit> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(p -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getType_produit().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else if (String.valueOf(p.getPrix()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<produit> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvProduit.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvProduit.setItems(sortedData);
        tvProduit.setRowFactory(tv -> new TableRow<produit>() {
    @Override
    protected void updateItem(produit item, boolean empty) {
        
 
        
    }
});
    }

    @FXML
    private void fnPDF(ActionEvent event) throws SQLException, ClassNotFoundException {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.INFORMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Votre rapport est géneré");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        if(lbIdFour.getText().equals("")){
            AlertBox.display("Erreur", "Choissir un fournisseur !!");
        }else{
        ServiceFournisseur serF=new ServiceFournisseur();
        serF.pdf(Integer.parseInt(lbIdFour.getText()),tfNom.getText());}
        
    }

	}

    @FXML
    private void handleDragOver(DragEvent event) {
         if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
          List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageview.setImage(img);
        nomImage = files.get(0).getName();
    }

}
     

