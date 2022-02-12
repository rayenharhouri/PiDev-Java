/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_service;

import G_Community_interface.IcommentaireService;
import G_Community_model.commentaire;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MSI
 */
public class CommentaireService implements IcommentaireService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void addComment(commentaire c, int id_pub , int id_user) { 
        //req
        String query = "INSERT INTO `commentaire`( `comment`,`id_u`,`id_pub`) VALUES ('" + c.getCommentaire() + "','" + id_user + "','" + id_pub + "')";
        try {
            Statement st = cnx.createStatement();
            //INSERT
            st.executeUpdate(query);
            System.out.println("COMMENT ADDED !!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<String> showComments(int id_Pub) {
        List<String> data = new ArrayList<>();
        String query="SELECT * FROM `commentaire` WHERE id_pub="+id_Pub;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                String result = "ID_Commentaire : " + rs.getInt(1) + "\nID_USER : " + rs.getInt(3) + "\nCOMMENT :" + rs.getString(4);
                data.add(result);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(data);
        return data;
    }

    @Override
    public void deleteComment(int id_Comment) {
        //req
        String query="DELETE FROM `commentaire` WHERE id_commentaire="+id_Comment;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("DELETE DONE COMMENT");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyComment(int id_comment, String Comment) {
        String query= "UPDATE `commentaire` SET `comment`='"+Comment+"' WHERE id_commentaire="+id_comment;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
