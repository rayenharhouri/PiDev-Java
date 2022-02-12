package G_Community_service;

import java.util.List;

import G_Community_interface.*;
import G_Community_model.publication;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class PublicationService implements IpublicationService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void ajouterPublication(publication p,int id_user) {
        //req
        String query = "INSERT INTO `publication`(`id_u`,`reactions`, `nbre_commentaires`, `topic`) VALUES (" + id_user + "," + p.getReactions() + "," + p.getNbre_commentaire() + ",'" + p.getTopic() + "')";

        try {
            //INSERT
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Ajout avec secces !!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> afficherPubs() {
        List<String> data = new ArrayList<>();
        String query = "SELECT * FROM `publication`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String result = "ID_PUB : " + rs.getInt(1)+" ID_U : " + rs.getInt(2) + " DATE_PUB : " +  rs.getString(3) + " LIKES : " + rs.getInt(4)+ " FEEDBACK : " +  rs.getInt(5)+" PUBLICATION : " +  rs.getString(6) + "\n";
                data.add(result);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(data);
        return data;
    }

    @Override
    public void deletePub(int id) {

        //req
        String query = "DELETE FROM `publication` WHERE id_pub=" + id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyPub(int id,String topic) {
        //req
        String query="UPDATE `publication` SET `topic`='"+topic+"' WHERE id_pub= "+id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    

}
