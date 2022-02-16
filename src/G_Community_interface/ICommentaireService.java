/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_interface;

import G_Community_model.commentaire;
import java.util.List;

/**
 *
 * @author MSI
 */
public interface IcommentaireService {
      //Add comment
    public void addComment(commentaire c,int id_user,int id_pub);

    //Show comment
    public List<String> showComments(int id_Pub);
    
    //delete comment
    public void deleteComment(int id_Comment);
    
    //Modify comment
    public void modifyComment(int id,String Comment);  
}
