package G_Community_service;

import java.util.List;

import G_Community_interface.*;
import G_Community_model.publication;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PublicationService implements IPublicationService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void ajouterPublication(publication p, int id_user) {
        //req
        String query = "INSERT INTO `publication`(`id_u`,`reactions`, `nbre_commentaires`, `topic`) VALUES (" + id_user + "," + p.getReactions() + "," + p.getNbre_commentaire() + ",'" + p.getTopic() + "')";

        try {
            //INSERT
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Ajout avec secces !!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<publication> afficherPubs() {
        List<publication> data = new ArrayList<>();
        String query = "SELECT * FROM `publication`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new publication(rs.getInt(1), rs.getInt(4), rs.getDate(3), rs.getInt(5), rs.getString(6), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("PUBLICATION :");
        System.out.println(data);
        return data;
    }

    @Override
    public void deletePub(int id) {

        //req
        String query = "DELETE FROM `publication` WHERE id_pub=" + id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyPub(int id, String topic) {
        //req
        String query = "UPDATE `publication` SET `topic`='" + topic + "' WHERE id_pub= " + id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int CountUserPub(int id_user) {
        String query = "SELECT `topic` FROM `publication` WHERE id_u=" + id_user;
        String query1 = "SELECT  `nom_u`,`prenom_u` FROM `utilisateur` WHERE id_u=" + id_user;
        List<String> data = new ArrayList<>();
        long Tot = 0;
        String nom_u = "";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(rs.getString("topic"));
            }
            Tot = data.stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement st1 = cnx.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            rs1.first();
            nom_u = rs1.getString(1)+" "+rs1.getString(2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("L'utilisateur D'ID = " + id_user + " et Son NOM&PRENOM = " + nom_u + " a publier " + Tot + " Publications");
        return (int) Tot;
    }

}
