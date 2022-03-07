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
public class Salle_jeu {
    private int id_salleJ;
    private String nomSalleJ;
    private String gouvernorat;

    public int getId_salleJ() {
        return id_salleJ;
    }

    public void setId_salleJ(int id_salleJ) {
        this.id_salleJ = id_salleJ;
    }

    public String getNomSalleJ() {
        return nomSalleJ;
    }

    public void setNomSalleJ(String nomSalleJ) {
        this.nomSalleJ = nomSalleJ;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public Salle_jeu() {
    }

    public Salle_jeu(int id_salleJ, String nomSalleJ, String gouvernorat) {
        this.id_salleJ = id_salleJ;
        this.nomSalleJ = nomSalleJ;
        this.gouvernorat = gouvernorat;
    }

    public Salle_jeu(String nomSalleJ, String gouvernorat) {
        this.nomSalleJ = nomSalleJ;
        this.gouvernorat = gouvernorat;
    }

    @Override
    public String toString() {
        return "Salle_jeu{" + "nomSalleJ=" + nomSalleJ + ", gouvernorat=" + gouvernorat + '}';
    }
    
    
    
}
