/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author melek
 */
public class Equipe {
    private int id_e;
    private String nom_e;
    private int titres;

    public Equipe() {
    }

    public int getId_e() {
        return id_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public String getNom_e() {
        return nom_e;
    }

    public void setNom_e(String nom_e) {
        this.nom_e = nom_e;
    }

    public int getTitres() {
        return titres;
    }

    public void setTitres(int titres) {
        this.titres = titres;
    }

    public Equipe(int id_e, String nom_e, int titres) {
        this.id_e = id_e;
        this.nom_e = nom_e;
        this.titres = titres;
    }

    public Equipe(String nom_e, int titres) {
        this.nom_e = nom_e;
        this.titres = titres;
    }
    
    

    @Override
    public String toString() {
        return "Equipe{" + "id_e=" + id_e + ", nom_e=" + nom_e + ", titres=" + titres + '}';
    }
    
    
    
}
