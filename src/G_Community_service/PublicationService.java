package G_Community_service;

import java.util.List;

import G_Community_interface.*;
import G_Community_model.publication;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class PublicationService implements IpublicationService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void ajouterPublication(publication p) {
        //req
        String query = "INSERT INTO `publication`(`id_u`,`reactions`, `nbre_commentaires`, `topic`) VALUES ("+6+","+p.getReactions()+","+p.getNbre_commentaire()+",'"+p.getTopic()+"')";
        
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
    public List<publication> afficherPubs() {
        return null;
    }

}
