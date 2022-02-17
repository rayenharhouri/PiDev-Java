/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Facture;

/**
 *
 * @author asus
 */
public interface IfactureService {

    //add
    public void AjouterFacture(Facture f, int id_commande);

    //select
    public List<Facture> AfficherFacture();

    public void ModififierFacture(String adresse_livraison, int id_facture);

    public void SupprimerFacture(int id_facture);
    
    public double prixTotFacture(int id_user);

}
