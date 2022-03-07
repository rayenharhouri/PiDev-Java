/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IService;

import model.Salle_jeu;
import model.tournoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.MaConnexion;

/**
 *
 * @author HP
 */
public class tournoi_service  implements IService<tournoi> {



Connection c = MaConnexion.getInstance().getCnx();

    @Override
    public void Ajouter(tournoi u) throws SQLException {
      PreparedStatement ps;
        
        
        String query = "INSERT INTO `tournoi`(`nombre_equipe`, `date`, `type_jeu`, `prix`, `id_salle`) VALUES (?,?,?,?,?)";
        try {
            ps = c.prepareStatement(query);
             ps.setInt(1, u.getNombre_equipre());
             ps.setDate(2, u.getDate());
          ps.setString(3, u.getType_jeu());
          ps.setFloat(4, u.getPrix());
          ps.setInt(5, u.getId_salle());
            ps.execute();    
            System.out.println(u);
        } catch (Exception e) { 
            System.out.println(e);
        } 
    

    }

    @Override
    public void Supprimer(int id) throws SQLException {
   
        PreparedStatement ps;

        String query = "DELETE FROM `tournoi` WHERE `id_tournoi`=?  ";
  
        try {
            ps = c.prepareStatement(query);

            ps.setInt(1, id);

            ps.execute();

            System.out.println("suppression de salle_jeu");
        } catch (Exception e) {
            System.out.println(e);
        } 
    
    }

    @Override
    public void Modifier(tournoi u, int id) throws SQLException {
       PreparedStatement ps;
        String query = "UPDATE `tournoi` SET `nombre_equipe`=?,`date`=?,`type_jeu`=?,`prix`=?,`id_salle`=? WHERE `id_tournoi`=?";
       try {
            
            ps = c.prepareStatement(query);
        ps.setInt(1, u.getNombre_equipre());
             ps.setDate(2, u.getDate());
          ps.setString(3, u.getType_jeu());
          ps.setFloat(4, u.getPrix());
          ps.setInt(5, u.getId_salle());

       
            ps.setInt(6, id);
            ps.execute();
   

        } catch (Exception e) {
        } 
    
    
    }
       public ObservableList<tournoi> serach(String cas) throws SQLException {
        ObservableList<tournoi> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `tournoi` t inner JOIN salle_jeu s  ON t.id_salle = s.id_salleJ and ( nombre_equipe LIKE '%" + cas + "%'or  date LIKE '%" + cas  + "%'or  type_jeu LIKE '%" + cas + "%'or  prix LIKE '%" + cas + "%' or  nomSalleJ LIKE '%" + cas + "%' ) ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                  list.add(new tournoi(rs.getInt("id_tournoi"), rs.getInt("nombre_equipe"), rs.getDate("date"), rs.getString("type_jeu"), rs.getFloat("prix"), rs.getInt("id_salle"),rs.getString("nomSalleJ")));
  }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public ObservableList<tournoi> Affichertout() throws SQLException {
        ObservableList<tournoi> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `tournoi` t inner JOIN salle_jeu s  ON t.id_salle = s.id_salleJ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add(new tournoi(rs.getInt("id_tournoi"), rs.getInt("nombre_equipe"), rs.getDate("date"), rs.getString("type_jeu"), rs.getFloat("prix"), rs.getInt("id_salle"),rs.getString("nomSalleJ")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    
        public List<tournoi> Affichertout_salle(int id_salle) throws SQLException {
        List<tournoi> list = FXCollections.observableArrayList();
            ;
        String requete = "SELECT * FROM `tournoi` where  id_salle="+id_salle;
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add(new tournoi(rs.getInt("id_tournoi"), rs.getInt("nombre_equipe"), rs.getDate("date"), rs.getString("type_jeu"), rs.getFloat("prix"), rs.getInt("id_salle"),""));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    public tournoi get_tournoi_affichage(int i) {
        tournoi p = null;
    
        String requete = "SELECT * FROM `tournoi` where id_tournoi="+i;
           try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             
     
                    p = new tournoi(rs.getInt("id_tournoi"), rs.getInt("nombre_equipe"), rs.getDate("date"), rs.getString("type_jeu"), rs.getFloat("prix"), rs.getInt("id_salle"),"");
                
           
                         }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;

    }
}
