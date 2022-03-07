/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import model.fournisseur;
import java.util.List;

/**
 *
 * @author HP
 * @param <T>
 */
public interface IService_store <T>{
    public void  ajouter(T t);
   public List<T> afficher();
   public void modifier(T t);
   public void supprimer(int id);
    
}
