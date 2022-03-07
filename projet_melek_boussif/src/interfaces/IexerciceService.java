/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import model.Exercice;
import model.quiz;

/**
 *
 * @author ABDELAZIZ
 */
public interface IexerciceService {
    
    //add
    public void AjouterExercice(Exercice E);
    //select
    public void ModifierExercice(String Ex,String Co ,int ide);
    public void SupprimerExercice(int id);
    public List<Exercice> afficherExercice();
}

