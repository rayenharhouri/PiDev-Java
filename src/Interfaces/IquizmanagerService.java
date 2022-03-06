/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import elaab.model.quiz;
import elaab.model.quizmanager;                     

/**
 *
 * @author Habib
 */
public interface IquizmanagerService {
    public void ajoutezQuizmanager(quizmanager s);
    public List<quizmanager> afficherQuizmanager();
    public void supprimerQuizmanager(int id_qm);
    public void modifierQuizmanager(int id_qm , String email , String password);
}
