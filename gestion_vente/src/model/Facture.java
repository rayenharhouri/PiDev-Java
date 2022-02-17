/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
public class Facture {
    
    //att
    public int id_facture;
    private String adresse_livraison;
    private int total_apres_reduction;
    private int id_user;
    
    //constructeur

    public Facture( String adresse_livraison, int total_apres_reduction) {
        
        this.adresse_livraison = adresse_livraison;
        this.total_apres_reduction = total_apres_reduction;
    }

    public Facture(int id_facture, String adresse_livraison, int total_apres_reduction,int id_user) {
        this.id_facture = id_facture;
        this.id_user= id_user;
        this.adresse_livraison = adresse_livraison;
        this.total_apres_reduction = total_apres_reduction;
    }
    
    //constructeur par defaut
    public Facture(){
    }
    //gatterssetters

   
    
 

  

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public int getTotal_apres_reduction() {
        return total_apres_reduction;
    }

    public void setTotal_apres_reduction(int total_apres_reduction) {
        this.total_apres_reduction = total_apres_reduction;
    }
    //afficher

    @Override
    public String toString() {
        return "Facture{" + "id_facture=" + id_facture + ", adresse_livraison=" + adresse_livraison + ", total_apres_reduction=" + total_apres_reduction + ", id_user=" + id_user + '}';
    }

    
    
    
    
}
