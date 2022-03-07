/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_melek_boussif;

import interfaces.IequipeService;
import java.sql.Connection;
import java.sql.SQLException;
import model.Equipe;
import model.Utilisateur;
import service.EquipeService;
import service.UtilisateurService;
import util.MaConnexion;
import util.mail;

/**
 *
 * @author melek
 */
public class Projet_melek_boussif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        
        UtilisateurService us=new UtilisateurService();
        IequipeService es=new EquipeService();
        
        Utilisateur u= new Utilisateur( "boussif"," kamel", "kamelesprit", "fifa", "ssss", 22);
        Utilisateur u1= new Utilisateur( "habib"," touati", "habibesprit", "valorant", "sdf", 22);
        Utilisateur u2= new Utilisateur( "habib "," daoud", "habibesprit", "counter strike", "sssdfss", 25);
        Utilisateur u3= new Utilisateur( "souha "," jaidi", "souhaesprit", "fifa", "4sdf", 29);
                Utilisateur u4= new Utilisateur( "souha "," jaidi", "souhaesprit", "rien", "4sdf", 29);
             Utilisateur u5= new Utilisateur( "souha "," jaidi", "souhaesprit", "fifa", "4s6df", 11);
                          Utilisateur u6= new Utilisateur( "aziz ","mahjoub","tatotu" ,"souhaesprit", "fifa", "4s6ddffmswxcdsf",3, 11);
//us.supprimerUtilisateurs(8);
  //  us.ajouterUtilisateur(u6);
        Equipe e=new Equipe("tobe_yes",5);
        //es.ajouterEquipe(e);
        System.out.println(us.afficherUtilisateurs());
       // us.ajouterUtilisateur(u6);
        //us.ajouterUtilisateur(u2);
        //us.ajouterUtilisateur(u3);
       // es.supprimerEquipe(8);
  //      System.out.println(us.chercherUtilisateursid("",0,"melek.boussif@esprit.tn","",0));
      //  System.out.println(us.chercherUtilisateursid("aziz"));
     
  // System.out.println(us.trierUtilisateursid());
     //  es.modifierEquipe(2, "la banda", 7);
              //  System.out.println(es.afficherEquipe());
              
              if (us.login("tatotu", "4s6ddffmswxcdsf")){
                  System.out.println("welcome")
                          ;}
             else System.out.println("falseeeeeee");
              
              
              Utilisateur uverif=new Utilisateur();
              uverif=us.verification("malik");
              if(uverif.getEmail()!=""){
                 // int code=us.generer(uverif.getID());
                //  System.out.println(code);
                 // System.out.println(uverif.getEmail());
                 // mail.sendMail(uverif.getEmail(), code);
         
              }
              
              

        
        
        
        //System.out.println(us.afficherUtilisateurs());
       // us.modifierUtilisateur(1, "harhouri", "rayen", "mailing", "fifa", "qhsdqsd", 5);
             //   System.out.println(us.afficherUtilisateurs());

        Connection cnx = MaConnexion.getInstance().getCnx();
         //us.supprimerUtilisateurs(2);
          // us.modifierUtilisateur(3,"habib" , "benali", "habibtouati", "fifa", "1110dx0", 11);
       
         
       // us.modifierUtilisateur(4,"rayen" , "harhouri", "harouri@esprit", "fifa", "11558dx0", 13);
       // System.out.println(us.afficherUtilisateurs());

        
    }
    
}
