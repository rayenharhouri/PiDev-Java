/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import model.Facture;
import service.FactureService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Front_FactureCrontroller implements Initializable {

    @FXML
    private Pane pnl_facture;
    @FXML
    private TableView<Facture> tab;
    @FXML
    private TableColumn<Facture, String> col_Adress;
    @FXML
    private TableColumn<Facture, Integer> col_Total;
    @FXML
    private Button btn_capture;
    @FXML
    private Button btn_Commande;
    @FXML
    private ImageView image_user;
    @FXML
    private Label username;
    FactureService FS = new FactureService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tab.setEditable(true);
        Modifier();
        try {
            refreche();
        } catch (SQLException ex) {
          }
    }    

     public void refreche() throws SQLException {

        col_Adress.setCellValueFactory(new PropertyValueFactory<>("adresse_livraison"));
          col_Adress.setCellFactory(TextFieldTableCell.<Facture> forTableColumn());
      
        col_Total.setCellValueFactory(new PropertyValueFactory<>("total_apres_reduction"));
       

        tab.getItems().clear();

        tab.setItems( FS.AfficherFacture());

    }
     public void Modifier()
    {

                col_Adress.setOnEditCommit((TableColumn.CellEditEvent<Facture, String> event) -> {
            TablePosition<Facture, String> pos = event.getTablePosition();
                
            String adress = event.getNewValue();
                 
            int row = pos.getRow();
            Facture f = event.getTableView().getItems().get(row);
           
  
            f.setAdresse_livraison(adress);
                    try {
                        FS.ModififierFacture(adress,f.getId_facture());
                    } catch (Exception ex) {
                    }
        });
    }
    @FXML
    private void Capture(ActionEvent event) {
        try {
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(180,0,1000,600);
            BufferedImage image = robot.createScreenCapture(rectangle);
            Image myImage = SwingFXUtils.toFXImage(image, null);
            ImageIO.write(image, "jpg", new File("facture.jpg"));
            System.out.println("capture");
        } catch (Exception e) {
        }
    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
             if (event.getSource() == btn_Commande) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Front_Commande.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }
    
}
