/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_vente;

import interfaces.IcommandeService;
import interfaces.IfactureService;
import java.util.UUID;
import model.Commande;
import model.Facture;
import service.Commandeservice;
import service.FactureService;

/**
 *
 * @author user
 */
public class Gestion_vente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //service
         IcommandeService cs = new Commandeservice();
         IfactureService fs = new FactureService();
         //commande
          Commande c = new Commande(6,3);
          //facture
          Facture f = new Facture("Nabeul",6);
          //insert
          //cs.AjouterCommande(c,6,2);
          //fs.AjouterFacture(f, 5);
          //select
          
         // cs.ModifierCommande(18, 5);
         //fs.ModififierFacture("Sousse", 5);
         //fs.SupprimerFacture(4);
         //cs.SupprimerCommande(7);
         //System.out.println(cs.AfficherCommande());
         //System.out.println(fs.AfficherFacture());
         //cs.prixTotCommande(18);
         //fs.prixTotFacture(7);
    }
   
        
    
    
}