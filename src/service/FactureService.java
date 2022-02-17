/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IfactureService;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Facture;
import util.MaConnexion;

/**
 *
 * @author asus
 */
public class FactureService implements IfactureService {

    //var 
    java.sql.Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void AjouterFacture(Facture f, int id_commande) {
        //request
        String req = "INSERT INTO `facture`( `id_commande`, `adress_livraison`, `total_apres_reduction`) VALUES ('" + id_commande + "','" + f.getAdresse_livraison() + "','" + f.getTotal_apres_reduction() + "')";

        try {
            //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("facture ajoutee avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(FactureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Facture> AfficherFacture() {

        //var
        List<Facture> factures = new ArrayList<>();
        //request
        String req = "SELECT * FROM facture";

        try {
            //exec

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                factures.add(new Facture(rs.getInt(1), rs.getString(3), rs.getInt(4), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return factures;

    }

    @Override
    public void ModififierFacture(String adresse_livraison, int id_facture) {
        String query = "UPDATE `facture` SET `adress_livraison`='" + adresse_livraison + "' WHERE id_facture= " + id_facture;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void SupprimerFacture(int id_facture) {
        String query = "DELETE FROM facture WHERE id_facture=" + id_facture;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public double prixTotFacture(int id_user) {
        
        List<String> data = new ArrayList<>();
        List<String> data1 = new ArrayList<>();
        double prix_totttt=0;
        int nbre_commande = 0;
        String queryy = "SELECT `id_commande` FROM `commande` WHERE id_u=" + id_user;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(queryy);
            while (rs.next()) {
                data1.add(rs.getString("id_commande"));
                nbre_commande = (int) data1.stream()
                        .count();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String query = "SELECT `prix_Total_commande` FROM `commande` WHERE id_u=" + id_user;
        int prix_tot = 0;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                data.add(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nbre_commande);
        for (int i = 0; i <= nbre_commande-1; i++) {           
                    prix_totttt = parseInt(data.get(i))+prix_totttt;
                }
        System.out.println(prix_totttt);
        
        
        String queryyy="UPDATE `facture` SET `prix_total`='"+prix_totttt+"' WHERE id_user="+id_user;
        try {
            Statement st =cnx.createStatement();
            st.executeUpdate(queryyy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prix_totttt;
    }

}
