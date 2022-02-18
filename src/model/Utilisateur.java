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
public class Utilisateur {
    private int ID;
    private String nom;
    private String prenom;
    private String email;
    private String bestgame;
    private String pwd;
    private int nbrs_jeton;

    private int it;

    public Utilisateur(String nom, String prenom, String email, String bestgame, String pwd, int nbrs_jeton, int it) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
    }
    

    public Utilisateur(int ID, String nom, String prenom, String email, String bestgame, String pwd, int it) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.it = it;
    }

    public Utilisateur(String nom, String prenom, String email, String bestgame, String pwd, int it) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.it = it;
    }

    public Utilisateur(int ID, String nom, String prenom, String email, String bestgame, String pwd, int nbrs_jeton, int it) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
    }

    public Utilisateur() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBestgame() {
        return bestgame;
    }

    public void setBestgame(String bestgame) {
        this.bestgame = bestgame;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public int getNbrs_jeton() {
        return nbrs_jeton;
    }

    public void setNbrs_jeton(int nbrs_jeton) {
        this.nbrs_jeton = nbrs_jeton;
    }
    

    @Override
    public String toString() {
        return "Utilisateur{" + "ID=" + ID + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", bestgame=" + bestgame + ", pwd=" + pwd + ", nbrs_jeton=" + nbrs_jeton + ", it=" + it + '}';
    }

   
    
    
    
    
    
}
