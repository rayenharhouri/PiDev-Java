/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elaab.model;

import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import util.MaConnexion;

/**
 *
 * @author Habib
 */
public class quiz {

    private int id_quiz;
    private int id_qm;
    private String image;
    private String theme;
    private String difficulte;
    private List <List<qr>> qrs  ;
    private int resultat ;  
    

        
    public List<List<qr>> listeQ (String diff, String theme) {
    
         Connection cnx = MaConnexion.getInstance().getCnx();
         ResultSet rs =null;
         PreparedStatement ps=null;
          List<qr> diff_1 = new ArrayList<qr> ();
          List<qr> diff_2 = new ArrayList<qr> ();
          List<qr> diff_3 = new ArrayList<qr> ();
          List<List<qr>> qrs = new ArrayList<List<qr>>();
          
     
        try {
               String req = "SELECT * from `qr` WHERE theme=?";
             ps=cnx.prepareStatement(req) ;
             ps.setString(1,theme);
             rs=ps.executeQuery();
            while (rs.next()) {
                
                
                if(rs.getString("diff").equals("facile"))
                {
                    
                    diff_1.add(new qr(rs.getString("question"), rs.getString("R1"), rs.getString("R2"),rs.getString("R3"),rs.getString("solution"),rs.getString("diff")) );
                    
                }
                
                if(rs.getString("diff").equals("moy"))
                {
                    diff_2.add(new qr(rs.getString("question"), rs.getString("R1"), rs.getString("R2"),rs.getString("R3"),rs.getString("solution"),rs.getString("diff")) );
                }
                
                if(rs.getString("diff").equals("diff"))
                {
                    diff_3.add(new qr(rs.getString("question"), rs.getString("R1"), rs.getString("R2"),rs.getString("R3"),rs.getString("solution"),rs.getString("diff")) );
                }
                
                
            }
                qrs.add(diff_1);
                
                qrs.add(diff_2);
                
                qrs.add(diff_3);
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qrs;
    }

    
        public quiz(String image, String theme, String difficulte) {
        this.image = image;
        this.theme = theme;
        this.difficulte = difficulte;
        this.qrs=listeQ(difficulte,theme);
        this.resultat=0;
        
        //
    }
        
        
        public void afficher_q(qr q){
            Scanner myObj= new Scanner(System.in);
            System.out.println("niveau"+q.getDiff());
            System.out.println("");
            System.out.println("");
            System.out.println("la question"+ q.getQuestion());
            System.out.println("");
            System.out.println(q.getR1());
            System.out.println("");
            System.out.println(q.getR2());
            System.out.println("");
            System.out.println(q.getR3());
            System.out.println("");
            
            System.out.println("entrer R");
            String r=myObj.nextLine();
                   if(r.equals(q.getSolution()))
                   {
                       System.out.println("La rep vrai");
                       this.resultat++;
                   }
                   else
                       System.out.println("la rep faux");
            
            
       
            
            
            
        }
        
        public void start_Quiz (){
            
            Random random = new Random () ;
           int nb;
           int i;
           int j;
               switch(this.difficulte){
   
       case "facile": 
           
          
           
           for (i=1;i<4;i++)
           {
               for(j=1;j<5-i;j++)
               {
                   nb=random.nextInt(this.qrs.get(i-1).size()) ;
                   afficher_q(this.qrs.get(i-1).get(nb));
                   
               }
               
               
           }
           
           System.out.println("resultat= "+this.resultat);
         
           break;
   
       case "moy":
          
           
           for (i=1;i<4;i++)
           {
               for(j=1;j<5-i;j++)
               {
                   nb=random.nextInt(this.qrs.get(i-1).size()) ;
                   afficher_q(this.qrs.get(i-1).get(nb));
                   
               }
               
               
           }
           
            System.out.println("resultat= "+this.resultat);
           break;
   
       case "diff":
           
           
           for (i=1;i<4;i++)
           {
               for(j=1;j<i+1;j++)
               {
                   nb=random.nextInt(this.qrs.get(i-1).size()) ;
                   afficher_q(this.qrs.get(i-1).get(nb));
                   
               }
               
               
           }
            System.out.println("");
            System.out.println("resultat= "+this.resultat);
           break;
       default:
           System.out.println("Choix incorrect");
           break;
   }
        
        
        
        
        
        
        
        
        
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    
    public quiz(int id_quiz, int id_qm, String image, String theme, String difficulte) {
        this.id_quiz = id_quiz;
        this.id_qm = id_qm;
        this.image = image;
        this.theme = theme;
        this.difficulte = difficulte;
        
    }
    

    public quiz() {
    }



    public quiz(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public int getId_qm() {
        return id_qm;
    }

    public void setId_qm(int id_qm) {
        this.id_qm = id_qm;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public String toString() {
        return "quiz{" + "id_quiz=" + id_quiz + ", id_qm=" + id_qm + ", image=" + image + ", theme=" + theme + ", difficulte=" + difficulte + ", qrs=" + qrs + ", resultat=" + resultat + '}';
    }

  
    
     
 
    
}
