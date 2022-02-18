/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.Connection;
import interfaces.IutilisateurService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Utilisateur;
import util.MaConnexion;

/**
 *
 * @author melek
 */
public class UtilisateurService implements IutilisateurService{
    Connection cnx=MaConnexion.getInstance().getCnx();
    @Override
    public void ajouterUtilisateur(Utilisateur u) {
    String req="INSERT INTO `utilisateur`( `nom`, `prenom`, `email`, `best_game`, `password`,`nbrs_jeton`, `id_e`) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"','"+u.getBestgame()+"','"+u.getPwd()+"',"+u.getNbrs_jeton()+","+u.getIt()+")";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ajout fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }

    @Override
    public List<Utilisateur> afficherUtilisateurs() {
      List<Utilisateur> utilisateurs=new ArrayList<>();
        
        String req = "SELECT * FROM utilisateur";
        
        
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              int x=rs.getString(6).length();
              String f="";
              for(int i=0;i<x;i++){
              f=f+"*";
              }
            utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), f, rs.getInt(7),rs.getInt(8)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    
        return utilisateurs;
    
    
    }

    @Override
    public void supprimerUtilisateurs(int id) {
        
     
    
       String req="DELETE FROM utilisateur WHERE idu="+id;
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("suppression fait avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }

    @Override
    public void modifierUtilisateur(int ID, String nom, String prenom, String email, String bestgame, String pwd,int nbrs_jeton, int it) {
   
    String req="UPDATE `utilisateur` SET `nom`='"+nom+"',`prenom`='"+prenom+"',`email`='"+email+"',`best_game`='"+bestgame+"',`password`='"+pwd+"',`nbrs_jeton`="+nbrs_jeton+",`id_e`="+it+" WHERE `idu`="+ID+" ";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("modif fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   

}
