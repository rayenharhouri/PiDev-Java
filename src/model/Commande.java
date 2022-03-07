/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Commande {
    
    //att
    public int id_commande;
    private int qte;
    private double prix_Total;
    private int id_u;
    private int id_produit;
 
    
    //constructor

    public Commande( int qte, int prix_Total) {
        
        this.qte = qte;
        this.prix_Total = prix_Total;
    }

    public Commande(int id_commande, int qte, int prix_Total, int id_u, int id_produit) {
        this.id_commande = id_commande;
        this.qte = qte;
        this.prix_Total = prix_Total;
        this.id_u = id_u;
        this.id_produit = id_produit;
    }


  
    
    //constructor_pardefaut
    public Commande(){
        
    }
    
    //getters&setters

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getPrix_Total() {
        return prix_Total;
    }

    public void setPrix_Total(double prix_Total) {
        this.prix_Total = prix_Total;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

  
    
    //afficher

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", qte=" + qte + ", prix_Total=" + prix_Total + ", id_u=" + id_u + ", id_produit=" + id_produit + '}';
    }

   
  
    
}