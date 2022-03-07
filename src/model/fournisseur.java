/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class fournisseur {
    private int id_fournisseur ;
    private String nom_fournisseur ;
    private int num_tel ;

    public fournisseur(int id_fournisseur, String nom_fournisseur, int num_tel) {
        this.id_fournisseur = id_fournisseur;
        this.nom_fournisseur = nom_fournisseur;
        this.num_tel = num_tel;
    }

    public fournisseur() {
    }
    

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return ""+ nom_fournisseur ;
    }
    
}
