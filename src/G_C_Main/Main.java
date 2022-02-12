/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_C_Main;

import G_Community_model.CommunityManager;
import G_Community_model.annonce;
import G_Community_model.commentaire;
import G_Community_model.publication;
import G_Community_service.AnnonceService;
import G_Community_service.CommentaireService;
import G_Community_service.CommunityManagerService;
import G_Community_service.PublicationService;
import java.sql.Connection;

import G_Community_util.Connexion;

/**
 * p
 *
 * @author RAYEN HARHOURI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cnx = Connexion.getInstance().getCnx();

        //Service
        PublicationService ps = new PublicationService();

        //publication
        publication p = new publication(0, 0, "HELLO IM STILL TESTING MY CODE");
        
        //INSERT Pub
        //ps.ajouterPublication(p,8);
        
        //Delete Pub
        //ps.deletePub(4);
        
        //modify Pub
        //ps.modifyPub(6, "HOPE IT WORKS");
        
        //ShowAll Pubs
        //ps.afficherPubs();
        
        //Service Commentaire
        CommentaireService cs = new CommentaireService();
        //Commentaire
        commentaire c = new commentaire("YES BRO");
        
        //AddComment
        //c.addComment(c1, 5, 8);
        
        //DeleteComment
        //cs.deleteComment(4);
        
        //modifyComment
        //cs.modifyComment(1, "hello world");
        
        //ShowAcomment
        //cs.showComments(7);
        
        //Annonce
        //Annonce Service
        AnnonceService as = new AnnonceService();
        //Annonce
        annonce a = new annonce("This is my First annoncement !!");
        
        //ADDing new Annoncement
        //as.addAnnonce(a, 1);
        
        //ADDannonce
        //as.showAnnonce(7);
        
        //DeleteAnnonce
        //as.deleteAnnonce(8);
        
        //modifyAnnoncement
        //as.modifyAnnonce(9, "Annoncement");
        
        //ADDCommunity manager
        CommunityManager cm = new CommunityManager("rayenn", "rayen@raef", "1212312");
        CommunityManagerService css= new CommunityManagerService();
        
        //ADD CM
        //css.addCM(cm);
        
        //ShowCm
        css.showCM(1);
        
        //Delete CM
        //css.deleteCM(6);
        
        //modify CM
        //css.modifyCM(4, "RiNo");
 
    }
}
