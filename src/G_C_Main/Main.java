/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_C_Main;

import G_Community_model.publication;
import G_Community_service.PublicationService;
import java.sql.Connection;

import G_Community_util.Connexion;


/**p
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
        publication p = new publication(0, 0, "this is my first try and my first pub");
        //INSERT
        ps.ajouterPublication(p);
    }
}
