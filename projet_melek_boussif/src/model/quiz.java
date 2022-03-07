/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import util.MaConnexion;

/**
 *
 * @author ABDELAZIZ
 */
public class quiz {
     
    //attributs
    private int id_quizs;
  
   private String image;
   private String matiere;
   private String difficulte;

   private int resultat;

    public quiz() {
    }

    public quiz(String image, String matiere, String difficulte, int resultat) {
        this.image = image;
        this.matiere = matiere;
        this.difficulte = difficulte;
        this.resultat = resultat;
    }

    public quiz(String image, String matiere, String difficulte) {
        this.image = image;
        this.matiere = matiere;
        this.difficulte = difficulte;
    }

    public quiz(int id_quizs, String image, String matiere, String difficulte, int resultat) {
        this.id_quizs = id_quizs;
        this.image = image;
        this.matiere = matiere;
        this.difficulte = difficulte;
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "quiz{" + "id_quizs=" + id_quizs + ", image=" + image + ", matiere=" + matiere + ", difficulte=" + difficulte + ", resultat=" + resultat + '}';
    }

    public int getId_quizs() {
        return id_quizs;
    }

    public void setId_quizs(int id_quizs) {
        this.id_quizs = id_quizs;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
  

    

}
