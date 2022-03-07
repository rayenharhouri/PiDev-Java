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
public interface ICommentaireService {
    //Add comment

    public void addComment(commentaire c, int id_user, int id_pub);

    //Show comment
    public List<commentaire> showComments(int id_Pub);

    //delete comment
    public void deleteComment(int id_Comment, int id_pub);

    //Modify comment
    public void modifyComment(int id, String Comment);

    //Voir tous les commentaire Sur une Pub
    public String ShowCommentsAdvanced(int id_pub);

    public  List<commentaire> ShowAllComments();
    
    public void deleteCommentt(int id_Comment);

}
