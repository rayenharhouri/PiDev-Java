/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.Connection;
import interfaces.IutilisateurService;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Utilisateur;
import static sun.security.jgss.GSSUtil.login;
import util.MaConnexion;

/**
 *
 * @author melek
 */
public class UtilisateurService implements IutilisateurService{
    Connection cnx=MaConnexion.getInstance().getCnx();
    @Override
    public void ajouterUtilisateur(Utilisateur u) {
        
      
    String req="INSERT INTO `utilisateur`( `nom`, `prenom`,`login`, `email`, `best_game`, `password`,`nbrs_jeton`, `id_e`,`image`,`role`) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getLogin()+"','"+u.getEmail()+"','"+u.getBestgame()+"','"+u.getPwd()+"',"+u.getNbrs_jeton()+","+u.getIt()+",'"+u.getImage()+"','client')";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ajout fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }

    @Override
    public ObservableList<Utilisateur> afficherUtilisateurs() {
      ObservableList<Utilisateur> utilisateurs=FXCollections.observableArrayList();
        
        String req = "SELECT * FROM utilisateur";
        
        
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              int x=rs.getString(7).length();
              String f="";
              for(int i=0;i<x;i++){
              f=f+"*";
              }
            utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), f, rs.getInt(8),rs.getInt(9)));
        
             
           
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
    public void modifierUtilisateur(int ID, String nom, String prenom,String login, String email, String bestgame, String pwd,int nbrs_jeton, int it) {
   
    String req="UPDATE `utilisateur` SET `nom`='"+nom+"',`prenom`='"+prenom+"',`login`='"+login+"',`email`='"+email+"',`best_game`='"+bestgame+"',`password`='"+pwd+"',`nbrs_jeton`="+nbrs_jeton+",`id_e`="+it+" WHERE `idu`="+ID+" ";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("modif fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean login(String login, String pwd) {
       
           
        
         List<Utilisateur> utilisateurs=new ArrayList<>();
        
        String req = "SELECT * FROM utilisateur WHERE (login='"+login+"'AND password='"+pwd+"')";
        
        
      
     try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              
              
            utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),rs.getInt(9)));
        }
          if(utilisateurs.isEmpty()){
              return false;}
          else {return true;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     return false;}

    @Override
    public int generer(int ID) throws SQLException {
        Random rand = new Random();
        int code = rand.nextInt((9999 - 1000) + 1) + 1000;
        
        String req="UPDATE utilisateur SET `CODE`="+code+" WHERE idu="+ID+"";
            
            try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("affectation done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return code;
        
        
    }

    @Override
    public Utilisateur verification(String login) {
        String req="SELECT *  FROM utilisateur where (login='"+login+"' )";
      Utilisateur u=new Utilisateur();
      try {
             //exec
             Statement st=cnx.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
             {
                 
                 u.setEmail(rs.getString(5));
                 u.setID(rs.getInt(1));
                 
             }
              
         } catch (SQLException ex) {
            ex.printStackTrace();
         }

return u;
    }

    @Override
    //public List<Utilisateur> chercherUtilisateursid(String nom,int id,String email,String bestgame,int it) {
            public ObservableList<Utilisateur> chercherUtilisateursid(String email) {

      ObservableList<Utilisateur> utilisateurs=FXCollections.observableArrayList();
        
        //String req = "SELECT * FROM utilisateur WHERE nom='"+nom+"' OR idu="+id+" OR email='"+email+"'or best_game='"+bestgame+"' or id_e="+it+" ";
        String req = "SELECT * FROM utilisateur WHERE nom='"+email+"' OR email='"+email+"'or best_game='"+email+"'or login='"+email+"'or prenom='"+email+"'";
        
        
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              int x=rs.getString(7).length();
              String f="";
              for(int i=0;i<x;i++){
              f=f+"*";
              }
            utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), f, rs.getInt(8),rs.getInt(9)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return utilisateurs;
        
    }

    @Override
    public ObservableList<Utilisateur> trierUtilisateursid() {
    ObservableList<Utilisateur> utilisateurs=FXCollections.observableArrayList();
        
        String req = "SELECT * FROM utilisateur ORDER BY nom,prenom ";
        
        
      
        try {
         Statement st = cnx.createStatement(); 
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
              int x=rs.getString(7).length();
              String f="";
              for(int i=0;i<x;i++){
              f=f+"*";
              }
            utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), f, rs.getInt(8),rs.getInt(9)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return utilisateurs;    }

    @Override
    public Utilisateur code(int code) {
 String req="SELECT *  FROM utilisateur where (login='"+code+"' )";
      Utilisateur u=new Utilisateur();
      try {
             //exec
             Statement st=cnx.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
             {
                 
                 u.setCode(rs.getInt(10));
                
                 
             }
              
         } catch (SQLException ex) {
            ex.printStackTrace();
         }

return u;
    }    

    @Override
    public void modifierUtilisateurss(int code, String pwd) {
 String req="UPDATE `utilisateur` SET `password`='"+pwd+"' WHERE `code`="+code+" ";
    
        try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("modif pwd fait succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public Utilisateur getUtilisateur(String login, String pwd) {
Utilisateur u=new Utilisateur();
      String req="SELECT * FROM UTILISATEUR where (login='"+login+"' AND password='"+pwd+"')";
      try {
             //exec
             Statement st=cnx.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
             {
                  u.setID(rs.getInt(1));
                  u.setNom(rs.getString(2));
                  u.setPrenom(rs.getString(3));
                  u.setLogin(rs.getString(4));
                  u.setEmail(rs.getString(5));
                  u.setBestgame(rs.getString(6));
                  u.setPwd(rs.getString(7));
                  u.setNbrs_jeton(rs.getInt(8));
                  u.setIt(rs.getInt(9));
                  u.setRole(rs.getString(11));
             }
                 
             
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
return u;        }

    @Override
    public Utilisateur getUtilisateur(int ID_UTILISATEUR) {
        Utilisateur u=new Utilisateur();
      String req="SELECT * FROM UTILISATEUR where idu="+ID_UTILISATEUR;
      try {
             //exec
             Statement st=cnx.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
             {
                u.setID(rs.getInt(1));
                  u.setNom(rs.getString(2));
                  u.setPrenom(rs.getString(3));
                  u.setLogin(rs.getString(4));
                  u.setEmail(rs.getString(5));
                  u.setBestgame(rs.getString(6));
                  u.setPwd(rs.getString(7));
                  u.setNbrs_jeton(rs.getInt(8));
                  u.setIt(rs.getInt(9));
                  u.setRole(rs.getString(11));
             }
                 
             
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
return u; 

    }

    @Override
    public void modifierUtilisateur1(int id, Utilisateur u) {
String req="UPDATE utilisateur SET `nom`='"+u.getNom()+"',`prenom`='"+u.getPrenom()+"',`email`='"+u.getEmail()+"',`best_game`='"+u.getBestgame()+"' where idu="+id;
         try 
         {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("utilisateur modifieé avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }

    }

   
    }

    
    
    
    
    

   


