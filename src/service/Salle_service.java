/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import model.Salle_jeu;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.imageio.ImageIO;
import util.MaConnexion;

/**
 *
 * @author HP
 */
public class Salle_service implements IService<Salle_jeu> {



    Connection c = MaConnexion.getInstance().getCnx();


    @Override
    public void Ajouter(Salle_jeu u) throws SQLException {
     PreparedStatement ps;
     
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
           String data = "nom salle : "+u.getNomSalleJ()+"<br>  gouvernorat : "+ u.getGouvernorat()+"<br> Merci pour votre confiance &#128525;";
 BufferedImage bufferedImage = null;
            int width = 300;
            int height = 300;
                     
        try {
           BitMatrix byteMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
              bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                bufferedImage.createGraphics();
                
                Graphics2D image = (Graphics2D) bufferedImage.getGraphics();
                image.setColor(Color.WHITE);
                image.fillRect(0, 0, width, height);
                image.setColor(Color.BLACK);
                
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (byteMatrix.get(i, j)) {
                            image.fillRect(i, j, 1, 1);
                        }
                    }
                }
                 if (ImageIO.write(bufferedImage, "png", new File("C:/wamp64/www/img"+u.getNomSalleJ()+".png")))
            {
                System.out.println("-- saved");
            }
                System.out.println("QR created successfully....");
        } catch (WriterException ex) {
        } catch (IOException ex) {
            Logger.getLogger(Salle_service.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
        
        String query = "INSERT INTO `salle_jeu`( `nomSalleJ`, `gouvernorat`) VALUES (?,?)";
        try {
            ps = c.prepareStatement(query);
             ps.setString(1, u.getNomSalleJ());
             ps.setString(2, u.getGouvernorat());
         
            ps.execute();    
            System.out.println(u);
        } catch (Exception e) { 
            System.out.println(e);
        } 
    
    
    
    
    
    }

    @Override
    public void Supprimer(int id) throws SQLException {
    PreparedStatement ps;

        String query = "DELETE FROM `salle_jeu` WHERE `id_salleJ`=?  ";
  
        try {
            ps = c.prepareStatement(query);

            ps.setInt(1, id);

            ps.execute();

            System.out.println("suppression de salle_jeu");
        } catch (Exception e) {
            System.out.println(e);
        } 
    
    
    }
    
      public Salle_jeu get_Salle_jeu_affichage(int i) {
        Salle_jeu p = null;
        int nombre = 0;
        String requete = "SELECT * FROM  salle_jeu ";
           try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (i == nombre) {
     
                    p = new Salle_jeu(rs.getInt("id_salleJ"),rs.getString("nomSalleJ"),rs.getString("gouvernorat"));
                            }
                nombre++;
                         }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;

    }

    @Override
    public void Modifier(Salle_jeu u, int id) throws SQLException {
           PreparedStatement ps;
        String query = "UPDATE `salle_jeu` SET `nomSalleJ`=?,`gouvernorat`=? WHERE `id_salleJ`=?";
       try {
            
            ps = c.prepareStatement(query);
            ps.setString(1, u.getNomSalleJ());
            ps.setString(2, u.getGouvernorat());

       
            ps.setInt(3, id);
            ps.execute();
   

        } catch (Exception e) {
        } 
    }

        public ObservableList<Salle_jeu> serach(String cas) throws SQLException {
        ObservableList<Salle_jeu> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `salle_jeu` where nomSalleJ LIKE '%" + cas + "%' or  gouvernorat LIKE '%" + cas + "%'  ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

        list.add(new Salle_jeu(rs.getInt("id_salleJ"),rs.getString("nomSalleJ"),rs.getString("gouvernorat")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

     
    public ObservableList<Salle_jeu> Affichertout() throws SQLException {
    
           ObservableList<Salle_jeu> list = FXCollections.observableArrayList();
        String requete = "select * from salle_jeu  ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

              list.add(new Salle_jeu(rs.getInt("id_salleJ"),rs.getString("nomSalleJ"),rs.getString("gouvernorat")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;


    }
    
    
    
      public ObservableList<Integer> get_ids_salle_jeux() {
        ObservableList<Integer> list = FXCollections.observableArrayList();

        String requete = "SELECT * FROM `salle_jeu` ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("id_salleJ"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
