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
import G_Community_interface.IAnnonceService;
import G_Community_interface.ICommentaireService;
import G_Community_interface.ICommunityManagerService;
import G_Community_interface.IPublicationService;
import java.net.MalformedURLException;



import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * p
 *
 * @author RAYEN HARHOURI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static HttpURLConnection HttpRequest;

    ;
    public static void main(String[] args) throws MalformedURLException, IOException {
        Connection cnx = Connexion.getInstance().getCnx();

        //##############################################################
        //##############################################################
        //####################PUBLICATION###############################
        //##############################################################
        //##############################################################
        //Service
        IPublicationService ps = new PublicationService();
        //publication
        publication p = new publication(100, 0, "aaaaaaaaaaaaaaaaaaaa !!");

        ps.iduser();
        // ps.CountUserPub(6);
        //ps.CountUserPub(12);
        //INSERT Pub
        //ps.ajouterPublication(p,6);
        //Delete Pub
        //ps.deletePub(12);
        //modify Pub
        //ps.modifyPub(11, "HOPE IT WORKS !!!!!");
        //ShowAll Pubs
        //ps.afficherPubs();
        //ps.addLike(5);
        //ps.deletePub(9);
        //ps.afficherPubID(7);
        //ps.trieSelonUsers();
        //##############################################################
        //##############################################################
        //####################COMMENTAIRE###############################
        //##############################################################
        //##############################################################
        //Service Commentaire
        ICommentaireService cs = new CommentaireService();
        //Commentaire
        commentaire c1 = new commentaire("Cest joliii !!");
        // cs.ShowCommentsAdvanced(5);
        //AddComment
        //cs.addComment(c1, 9, 6);
        //DeleteComment
        //cs.deleteComment(13, 9);
        //modifyComment
        //cs.modifyComment(1, "hello world");
        //ShowAcomment
        //cs.showComments(7);

        //##############################################################
        //##############################################################
        //##########################ANNONCE#############################
        //##############################################################
        //##############################################################
        //Annonce
        //Annonce Service
        IAnnonceService as = new AnnonceService();
        //Annonce
        annonce a = new annonce("This is my First annoncement !!", 1);

        //ADDing new Annoncement
        //as.addAnnonce(a, 1);
        //SHOWannonce
        //as.showAnnonce(9);
        //DeleteAnnonce
        //as.deleteAnnonce(8);
        //modifyAnnoncement
        //as.modifyAnnonce(9, "Annoncement");
        //##############################################################
        //##############################################################
        //####################COMMUNITY MANAGER#########################
        //##############################################################
        //##############################################################
        //ADDCommunity manager
        CommunityManager cm = new CommunityManager("rayenn", "rayen@raef", "1212312");
        ICommunityManagerService css = new CommunityManagerService();

        //ADD CM
        //css.addCM(cm);
        //ShowCm
        //css.showCM(1);
        //Delete CM
        //css.deleteCM(6);
        //modify CM
        //css.modifyCM(4, "RiNo");
        

    }
}
