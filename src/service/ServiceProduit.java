/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.fournisseur;
import model.produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MaConnexion;
import interfaces.IService_store;

/**
 *
 * @author HP
 */
public class ServiceProduit implements IService_store<produit> {
    
    Connection cnx;

    public ServiceProduit() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(produit t) {
       try {
        String req = "insert into produit (type_produit,quantite,prix,id_fournisseur,image) "
                + "values"+"('"+t.getType_produit()+"',"+t.getQuantite()+","+t.getPrix()+","+t.getId_fournisseur().getId_fournisseur()+","+ t.getImage() +")";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<produit> afficher() {
        List<produit> list =new ArrayList<>();
        try{
            String req ="select * from produit";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        produit r =new produit();
        r.setId_produit(rs.getInt("id_produit"));
        r.setPrix(rs.getFloat("prix"));
        r.setQuantite(rs.getInt("quantite"));
        r.setType_produit(rs.getString("type_produit"));
        r.setImage(rs.getString("image"));
        ServiceFournisseur serF=new ServiceFournisseur();
        fournisseur f=serF.getFournisseurById(rs.getInt("id_fournisseur"));
        r.setId_fournisseur(f);
        r.setNom(f.getNom_fournisseur());
       
        
        
          list.add(r); 
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
        public produit get_produit(int id) {
        List<produit> list =new ArrayList<>();
        try{
            String req ="select * from produit where id_produit="+id;
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        produit r =new produit();
        r.setId_produit(rs.getInt("id_produit"));
        r.setPrix(rs.getFloat("prix"));
        r.setQuantite(rs.getInt("quantite"));
        r.setType_produit(rs.getString("type_produit"));
        r.setImage(rs.getString("image"));
        ServiceFournisseur serF=new ServiceFournisseur();
        fournisseur f=serF.getFournisseurById(rs.getInt("id_fournisseur"));
        r.setId_fournisseur(f);
        r.setNom(f.getNom_fournisseur());
       
        
        
         return r;
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public void modifier(produit t) {
        try {
        String req ="update produit set prix= ? , quantite= ?, type_produit= ? , id_fournisseur= ? where id_produit = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setFloat(1,t.getPrix());
        ps.setInt(2, t.getQuantite());
        ps.setString(3,t.getType_produit());
        ps.setInt(4, t.getId_fournisseur().getId_fournisseur());
        ps.setInt(5,t.getId_produit());
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprimer(int id) {
           try {
        String req ="delete from produit where id_produit=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    void supprimerByFournisseur(int id) {
        try {
        String req ="delete from produit where id_fournisseur=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
}
