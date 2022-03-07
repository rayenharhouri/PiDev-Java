/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_model;

/**
 *
 * @author MSI
 */
public class CommunityManager {
    private int id_cm;
    private String nom_prenom;
    private String mail;
    private String pwd;

    public CommunityManager() {
    }

    public CommunityManager(int id_cm, String nom_prenom, String mail, String pwd) {
        this.id_cm = id_cm;
        this.nom_prenom = nom_prenom;
        this.mail = mail;
        this.pwd = pwd;
    }
    
    public CommunityManager( String nom_prenom, String mail, String pwd) {
        this.nom_prenom = nom_prenom;
        this.mail = mail;
        this.pwd = pwd;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "CommunityManager{" + "id_cm=" + id_cm + ", nom_prenom=" + nom_prenom + ", mail=" + mail + ", pwd=" + pwd + '}';
    }
    
    
    
}
