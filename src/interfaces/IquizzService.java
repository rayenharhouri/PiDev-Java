/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import model.quiz;

/**
 *
 * @author ABDELAZIZ
 */
public interface IquizzService {
    //add
    public void AjouterQuizz(quiz p);
    //select
    public List<quiz> afficherQuizz();
    
    public void ModifierQuizz(quiz q,int id);
    public void SupprimerQuizz(int id);
   // public List<question> listeQ (String difficulte, String matiere);
  //  public List<List<question>> listeQ(String difficulte, String matiere);
   // public void afficher_q(question q);
    // public void Start_Quiz();
}
