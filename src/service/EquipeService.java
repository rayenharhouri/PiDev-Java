/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.Connection;
import interfaces.IequipeService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Equipe;
import model.Utilisateur;
import util.MaConnexion;

/**
 *
 * @author melek
 */
public class EquipeService implements IequipeService{
    Connection cnx=MaConnexion.getInstance().getCnx();

    @Override
    public void ajouterEquipe(Equipe e) {
        
        String req="INSERT INTO `equipe`(  `nom_e`, `titres`) VALUES ('"+e.getNom_e()+"',"+e.getTitres()+")";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ajout fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }

    @Override
    public ObservableList<Equipe> afficherEquipe() {
         ObservableList<Equipe> equipes=FXCollections.observableArrayList();
        
        String req = "SELECT * FROM equipe";
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
            equipes.add(new Equipe(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    
        return equipes;
    
    
    }

    @Override
    public void supprimerEquipe(int id_e) {
        
         String req="DELETE FROM equipe WHERE id_e="+id_e;
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("suppression fait avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifierEquipe(int id_e, String nom_e, int titres) {
        
        
        String req="UPDATE `equipe` SET `nom_e`='"+nom_e+"',`titres`="+titres+" WHERE `id_e`="+id_e+" ";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("modif fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 @Override
    //public List<Utilisateur> chercherUtilisateursid(String nom,int id,String email,String bestgame,int it) {
            public ObservableList<Equipe> chercherequipe(String email) {

      ObservableList<Equipe> utilisateurs=FXCollections.observableArrayList();
        
        //String req = "SELECT * FROM utilisateur WHERE nom='"+nom+"' OR idu="+id+" OR email='"+email+"'or best_game='"+bestgame+"' or id_e="+it+" ";
        String req = "SELECT * FROM equipe WHERE nom_e='"+email+"'";
        
        
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
             
            utilisateurs.add(new Equipe(rs.getString(2), rs.getInt(3)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return utilisateurs;
        
    }

    @Override
    public ObservableList<Equipe> trierequipe() {
    ObservableList<Equipe> utilisateurs=FXCollections.observableArrayList();
        
        String req = "SELECT * FROM equipe ORDER BY nom_e,titres ";
        
        
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              
            utilisateurs.add(new Equipe(rs.getInt(1),rs.getString(2), rs.getInt(3)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return utilisateurs;    }

    
    
    
}
