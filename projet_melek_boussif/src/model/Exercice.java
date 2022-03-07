/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ABDELAZIZ
 */
public class Exercice {
  
    private int id_exercice;
    private String exercice;
    private String corrigé;
   
    //construct

    public Exercice(int id_exercice, String exercice, String corrigé) {
        this.id_exercice = id_exercice;
        this.exercice = exercice;
        this.corrigé = corrigé;
    }

    public Exercice(String exercice, String corrigé) {
        this.exercice = exercice;
        this.corrigé = corrigé;
    }

    public Exercice() {
    }

    public int getId_exercice() {
        return id_exercice;
    }

    public void setId_exercice(int id_exercice) {
        this.id_exercice = id_exercice;
    }

    public String getExercice() {
        return exercice;
    }

    public void setExercice(String exercice) {
        this.exercice = exercice;
    }

    public String getCorrigé() {
        return corrigé;
    }

    public void setCorrigé(String corrigé) {
        this.corrigé = corrigé;
    }

    @Override
    public String toString() {
        return "Exercice{" + "id_exercice=" + id_exercice + ", exercice=" + exercice + ", corrig\u00e9=" + corrigé + '}';
    }
    
}
