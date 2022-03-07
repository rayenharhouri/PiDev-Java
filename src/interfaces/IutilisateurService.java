/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.sql.SQLException;
import model.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;
        

/**
 *
 * @author melek
 */
public interface IutilisateurService {
    
    public void ajouterUtilisateur(Utilisateur u);
    
    
    public ObservableList<Utilisateur> afficherUtilisateurs();
    
        public void supprimerUtilisateurs(int ID);
        
    
    public void modifierUtilisateur(int ID, String nom, String prenom,String login, String email, String bestgame, String pwd,int nbrs_jeton, int it);
    
    public boolean login(String login,String pwd) throws SQLException;
    public int generer(int ID)throws SQLException;
    public Utilisateur verification(String login);
        public ObservableList<Utilisateur> chercherUtilisateursid(String email);
        
                //public List<Utilisateur> chercherUtilisateursid(String nom,int id,String email,String bestgame,int it);
public ObservableList<Utilisateur> trierUtilisateursid();
    public Utilisateur code(int code);
    public void modifierUtilisateurss(int code,String pwd);
    public Utilisateur getUtilisateur(String login,String pwd);
    public Utilisateur getUtilisateur(int ID_UTILISATEUR);
    public void modifierUtilisateur1(int id,Utilisateur u);
  


    

        
        

    
}
