/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Commande;

/**
 *
 * @author asus
 */
public interface IcommandeService {
    
    //add
    public void AjouterCommande(Commande c,int id_u,int id_produit);
    
    //select
    public List<Commande> AfficherCommande();
    public void ModifierCommande(int qte,int id_commande);
    public void SupprimerCommande(int id_commande);
    public double prixTotCommande(int id_commande);
    
}
