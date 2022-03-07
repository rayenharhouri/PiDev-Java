/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_interface;


import G_Community_model.annonce;
import java.util.List;

/**
 *
 * @author MSI
 */
public interface IAnnonceService {
          //Add Pub
    public void addAnnonce(annonce a,int id_CM);

    //Show Pubs
    public List<annonce> showAnnonce(int id_annonce);
    
    //delete pub
    public void deleteAnnonce(int id_annonce);
    
    //Modify pub
    public void modifyAnnonce(int id_annonce,String annonce);  
}
