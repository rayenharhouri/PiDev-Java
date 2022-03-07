/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Commande;
import util.MaConnexion;
import interfaces.IcommandeService;
import java.sql.PreparedStatement;

/**
 *
 * @author asus
 */
public class Commandeservice implements IcommandeService{

    //var 
    java.sql.Connection cnx = MaConnexion.getInstance().getCnx();
    
    @Override
    public void AjouterCommande(Commande c,int id_u,int id_produit) {
        //request
        String req="INSERT INTO `commande`( `id_produit`, `qte`, `prix_Total`, `idu`) VALUES ('"+id_produit+"','"+c.getQte()+"','"+c.getPrix_Total()+"','"+id_u+"')";
        
        try {
            //insert
            Statement st = cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("commande ajoutee avec succes");
             
        } catch (SQLException ex) {
               ex.printStackTrace();
        }
    }

    @Override
    public List<Commande> AfficherCommande() {
        //var
        List<Commande> commandes = new ArrayList<>();
        //request
        String req = "SELECT * FROM commande";
          
        try {
            //exec
        
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               commandes.add(new Commande(rs.getInt(1), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getInt(2)));
            }    
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
        
        return commandes;
    
    }
      public List<Commande> AfficherCommande_user(int id_u) {
        //var
        List<Commande> commandes = new ArrayList<>();
        //request
        String req = "SELECT * FROM commande where idu="+id_u;
          
        try {
            //exec
        
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               commandes.add(new Commande(rs.getInt(1), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getInt(2)));
            }    
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
        
        return commandes;
    
    }
        public Commande get_Commande_affichage(int id) {
        Commande c = null;
     
        String requete = "SELECT * FROM commande where id_commande="+id;
           try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                
     
                     c=new Commande(rs.getInt(1), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getInt(2));
         
               
                         }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;

    }

    @Override
    public void ModifierCommande(int qte, int id_commande) {
        String query = "UPDATE commande SET `qte`='" + qte + "' WHERE id_commande= " +id_commande;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void SupprimerCommande(int id_commande) {
        String query = "DELETE FROM commande WHERE id_commande=" + id_commande;
try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public double prixTotCommande(int id_commande) {
        String query= "SELECT `qte`,`id_produit` FROM `commande` WHERE id_commande="+id_commande;
        int quantite =0;
        int id_prod=0;
        int prix_unit=0;
        double prix_tot=0;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                quantite=rs.getInt(1);
                id_prod=rs.getInt(2);
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        String queryy = "SELECT `prix` FROM `produit` WHERE id_produit="+id_prod;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(queryy);
            rs.first();
            prix_unit = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        prix_tot = quantite * prix_unit;
        prix_tot=prix_tot-(prix_tot*19)/100;
        String queryyy="UPDATE `commande` SET `prix_Total_commande`='"+prix_tot+"' WHERE id_commande="+id_commande;
        try {
            Statement st =cnx.createStatement();
            st.executeUpdate(queryyy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(prix_tot);
        return prix_tot;
    }
}