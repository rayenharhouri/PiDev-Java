/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class tournoi {
    private int id_tournoi;
    private int nombre_equipre;
    private Date date;
    private String type_jeu;
    private float prix;
    private int id_salle;
    private String nom_salle;

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public int getNombre_equipre() {
        return nombre_equipre;
    }

    public void setNombre_equipre(int nombre_equipre) {
        this.nombre_equipre = nombre_equipre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType_jeu() {
        return type_jeu;
    }

    public void setType_jeu(String type_jeu) {
        this.type_jeu = type_jeu;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    public tournoi() {
    }

    public tournoi(int id_tournoi, int nombre_equipre, Date date, String type_jeu, float prix, int id_salle, String nom_salle) {
        this.id_tournoi = id_tournoi;
        this.nombre_equipre = nombre_equipre;
        this.date = date;
        this.type_jeu = type_jeu;
        this.prix = prix;
        this.id_salle = id_salle;
        this.nom_salle = nom_salle;
    }

    public tournoi(int nombre_equipre, Date date, String type_jeu, float prix, int id_salle, String nom_salle) {
        this.nombre_equipre = nombre_equipre;
        this.date = date;
        this.type_jeu = type_jeu;
        this.prix = prix;
        this.id_salle = id_salle;
        this.nom_salle = nom_salle;
    }

    public tournoi(int nombre_equipre, Date date, String type_jeu, float prix, int id_salle) {
        this.nombre_equipre = nombre_equipre;
        this.date = date;
        this.type_jeu = type_jeu;
        this.prix = prix;
        this.id_salle = id_salle;
    }

    @Override
    public String toString() {
        return "tournoi{" + "id_tournoi=" + id_tournoi + ", nombre_equipre=" + nombre_equipre + ", date=" + date + ", type_jeu=" + type_jeu + ", prix=" + prix + ", id_salle=" + id_salle + ", nom_salle=" + nom_salle + '}';
    }
    
    
}
