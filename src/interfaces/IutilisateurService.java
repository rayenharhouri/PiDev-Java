/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import model.Utilisateur;
import java.util.List;
        

/**
 *
 * @author melek
 */
public interface IutilisateurService {
    
    public void ajouterUtilisateur(Utilisateur u);
    
    
    public List<Utilisateur> afficherUtilisateurs();
    
        public void supprimerUtilisateurs(int ID);
        
    
    public void modifierUtilisateur(int ID, String nom, String prenom, String email, String bestgame, String pwd,int nbrs_jeton, int it);

        
        

    
}
