/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import elaab.model.qr;
import elaab.model.quiz;


/**
 *
 * @author Habib
 */
public interface IquizService {
    

    public ObservableList<quiz> afficherQuiz();
    
    
}
