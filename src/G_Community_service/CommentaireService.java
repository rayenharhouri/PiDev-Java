/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_service;

import G_Community_model.commentaire;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import G_Community_interface.ICommentaireService;

/**
 *
 * @author MSI
 */
public class CommentaireService implements ICommentaireService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void addComment(commentaire c, int id_pub, int id_user) {
        //req
        String query = "INSERT INTO `commentaire`( `comment`,`idu`,`id_pub`) VALUES ('" + c.getCommentaire() + "','" + id_user + "','" + id_pub + "')";
        try {
            Statement st = cnx.createStatement();
            //INSERT
            st.executeUpdate(query);
            System.out.println("COMMENT ADDED !!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String queryy = "UPDATE `publication` AS T1,"
                + "      (SELECT `nbre_commentaires`"
                + "        FROM `publication` "
                + "        WHERE id_pub = " + id_pub + ") AS T2 "
                + "  SET T1.`nbre_commentaires`=T2.`nbre_commentaires` + 1 "
                + "WHERE T1.id_pub =" + id_pub;

        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(queryy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<commentaire> showComments(int id_Pub) {
        List<commentaire> data = new ArrayList<>();
        String query = "SELECT * FROM `commentaire` WHERE id_pub=" + id_Pub;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new commentaire(rs.getInt(1), rs.getInt(3), rs.getInt(2), rs.getString(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("COMMENTAIRE :");
        System.out.println(data);
        return data;
    }

    @Override
    public void deleteComment(int id_Comment, int id_pub) {
        //req
        String query = "DELETE FROM `commentaire` WHERE id_commentaire=" + id_Comment;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("DELETE DONE COMMENT");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String queryy = "UPDATE `publication` AS T1,"
                + "      (SELECT `nbre_commentaires`"
                + "        FROM `publication` "
                + "        WHERE id_pub = " + id_pub + ") AS T2 "
                + "  SET T1.`nbre_commentaires`=T2.`nbre_commentaires` - 1 "
                + "WHERE T1.id_pub =" + id_pub;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(queryy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCommentt(int id_Comment) {
        //req
        String query = "DELETE FROM `commentaire` WHERE id_commentaire=" + id_Comment;
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
        String query = "UPDATE `commentaire` SET `comment`='" + Comment + "' WHERE id_commentaire=" + id_comment;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String ShowCommentsAdvanced(int id_pub) {
        String query = "SELECT `comment` FROM `commentaire` WHERE id_pub=" + id_pub;
        String query1 = "SELECT `topic` FROM `publication` WHERE id_pub=" + id_pub;
        String pub = "";
        List<commentaire> data = new ArrayList<>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                commentaire c = new commentaire();
                c.setCommentaire(rs.getString(1));
                data.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query1);
            rs.first();
            pub = rs.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        String result;
        result = "publication : " + "#" + pub + "# ID_PUB = " + id_pub + "\nComments    :" + data;
        return result;
    }

    @Override
    public List<commentaire> ShowAllComments() {
        List<commentaire> data = new ArrayList<>();
        String query = "SELECT * FROM `commentaire`";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new commentaire(rs.getInt(1), rs.getInt(3), rs.getInt(2), rs.getString(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("COMMENTAIRE :");
        System.out.println(data);
        return data;
    }

   

}
