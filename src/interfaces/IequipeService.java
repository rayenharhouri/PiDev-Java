/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import model.Equipe;


/**
 *
 * @author melek
 */
public interface IequipeService {
    
    
    public void ajouterEquipe(Equipe e);
    public List<Equipe> afficherEquipe();
    public void supprimerEquipe(int id_e);
    public void modifierEquipe(int id_e,String nom_e,int titres);
    public ObservableList<Equipe> trierequipe();
     public ObservableList<Equipe> chercherequipe(String email) ;
}
