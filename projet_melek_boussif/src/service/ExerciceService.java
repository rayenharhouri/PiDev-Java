/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IexerciceService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Exercice;

import util.MaConnexion;

/**
 *
 * @author ABDELAZIZ
 */
public class ExerciceService implements IexerciceService{

    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void AjouterExercice(Exercice E) {
        String req="INSERT INTO `exercices`(`exercice`, `corrige`) VALUES ('"+E.getExercice()+"','"+E.getCorrigé()+"')";
        try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }System.out.println("ajout avec succes");
    }

    @Override
    public void ModifierExercice(String Ex, String Co, int ide) {
        String req="UPDATE `exercices` SET `exercice`='"+Ex+"',`corrige`='"+Co+"' WHERE `id_exercices`= "+ide;
         try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("modification avec succes");
    }

    @Override
    public void SupprimerExercice(int id) {
         String req= "DELETE FROM `exercices` WHERE `id_exercices` = "+id;
        try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("suppression avec succes");
    }

    @Override
    public List<Exercice> afficherExercice() {
        List<Exercice> LE= new ArrayList<>(); 
     String req="SELECT * FROM `exercices` ";
      try {
            Statement st= cnx.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                LE.add (new Exercice (rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("affichage avec succes");
        System.out.println(LE);
        return LE;
        
    }
    

    
    
}
