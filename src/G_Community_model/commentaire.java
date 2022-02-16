/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_model;

/**
 *
 * @author MSI
 */
public class commentaire {
    //VAR
    private int id_commentaire;
    private int id_user;
    private int id_pub;
    private String commentaire;
    
    //constructor

    public commentaire() {
    }

    public commentaire(int id_commentaire, int id_user, int id_pub, String commentaire) {
        this.id_commentaire = id_commentaire;
        this.id_user = id_user;
        this.id_pub = id_pub;
        this.commentaire = commentaire;
    }
    

    public commentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "commentaire{" + "id_commentaire=" + id_commentaire + ", id_user=" + id_user + ", id_pub=" + id_pub + ", commentaire=" + commentaire + '}';
    }
    

}
