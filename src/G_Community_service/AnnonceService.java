/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_service;

import G_Community_model.annonce;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import G_Community_interface.IAnnonceService;

/**
 *
 * @author MSI
 */
public class AnnonceService implements IAnnonceService {

    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void addAnnonce(annonce a, int id_CM) {
        //req
        String query = "INSERT INTO `annonce`(`id_CM`, `annonce`) VALUES ('" + id_CM + "','" + a.getAnnonce() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Annoncement Added !!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<annonce> showAnnonce(int id_annonce) {
        String query = "SELECT * FROM `annonce` WHERE id_annonce="+id_annonce;
        List<annonce> data = new ArrayList<>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                data.add(new annonce(rs.getInt(1),rs.getString(3),rs.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ANNONCE :");
        System.out.println(data);
        return data;
    }

    @Override
    public void deleteAnnonce(int id_annonce) {
         //req
        String query="DELETE FROM `annonce` WHERE id_annonce="+id_annonce;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("DELETE DONE Annonce");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyAnnonce(int id_annonce, String annonce) {
        String query= "UPDATE `annonce` SET `annonce`='"+annonce+"' WHERE id_annonce="+id_annonce;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
