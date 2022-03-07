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
public class produit {
    
    private int id_produit;
    private String type_produit;
    private int quantite;
    private float prix;
    private fournisseur id_fournisseur;
    private String nom;
    private String image;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    public produit() {
    }

    public produit(int id_produit, String type_produit, int quantite, float prix, fournisseur id_fournisseur) {
        this.id_produit = id_produit;
        this.type_produit = type_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.id_fournisseur = id_fournisseur;
    }

    public produit(String type_produit, int quantite, float prix, fournisseur id_fournisseur) {
        this.type_produit = type_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.id_fournisseur = id_fournisseur;
    }

    

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getType_produit() {
        return type_produit;
    }

    public void setType_produit(String type_produit) {
        this.type_produit = type_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public fournisseur getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(fournisseur id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    
    

    @Override
    public String toString() {
        return "produit{" + "id_produit=" + id_produit + ", type_produit=" + type_produit + ", quantite=" + quantite + ", prix=" + prix + '}';
    }

    
    
    
    
}
