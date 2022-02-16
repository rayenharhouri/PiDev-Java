/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_service;

import G_Community_model.CommunityManager;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import G_Community_interface.ICommunityManagerService;

/**
 *
 * @author MSI
 */
public class CommunityManagerService implements ICommunityManagerService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();



    @Override
    public void deleteCM(int id_cm) {
        //req
        String query = "DELETE FROM `community_manager` WHERE id_CM=" + id_cm;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyCM(int id_cm, String np) {
        //req
        String query = "UPDATE `community_manager` SET `nom_prenom`='" + np + "' WHERE id_CM= " + id_cm;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void addCM(CommunityManager cm) {
        String query = "INSERT INTO `community_manager`( `nom_prenom`, `mail`, `passworld`) VALUES ('" + cm.getNom_prenom() + "','" + cm.getMail() + "','" + cm.getPwd() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public List<CommunityManager> showCM(int id_cm) {
        List<CommunityManager> data = new ArrayList<>();
        String query = "SELECT * FROM `community_manager` WHERE id_CM="+id_cm;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new CommunityManager(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            System.out.println("CM :");
        System.out.println(data);
        return data;
    }

}
