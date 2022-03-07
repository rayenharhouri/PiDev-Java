/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.question;

/**
 *
 * @author ABDELAZIZ
 */
public interface IquestionService {
    public void Ajouterquest(question qu);
    public List<question> afficherquest();
    public void Supprimerquest (int id);
    public void Modifierquest(int id_question, question q);
}
