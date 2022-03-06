/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.util.List;

import elaab.model.qr;
/**
 *
 * @author Habib
 */
public interface IqrService {
    
    
    public void ajouterqr(qr r);
    public List<qr> afficherqr();
    public void supprimerqr(int id);
    public void modifierqr(int id_question ,String question,String R1,String R2,String R3,String solution);
    
}
