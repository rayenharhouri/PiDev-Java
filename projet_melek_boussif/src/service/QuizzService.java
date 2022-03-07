/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.sql.Connection;
import java.util.List;
import model.quiz;
import util.MaConnexion;
import interfaces.IquizzService;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.imageio.ImageIO;
import model.question;


/**
 *
 * @author ABDELAZIZ
 */
public class QuizzService implements IquizzService{
//var
    Connection cnx = MaConnexion.getInstance().getCnx();
public  String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    @Override
    public void AjouterQuizz(quiz q) {
         String code = getMd5(q.getMatiere());
         q.setImage(code+".png");
       String req = "INSERT INTO `quizs`(`image`,`matiere`, `difficulte`,`resultat`) VALUES ('"+q.getImage()+"','"+q.getMatiere()+"','"+q.getDifficulte()+"','"+q.getResultat()+"')";
        try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
           QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
            String data = "Quiz matiere : "+q.getMatiere()+"<br>  difficulte : "+ q.getDifficulte();

            int width = 300;
            int height = 300;
            
            BufferedImage bufferedImage = null;
            try {
                BitMatrix byteMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                bufferedImage.createGraphics();
                
                Graphics2D image = (Graphics2D) bufferedImage.getGraphics();
                image.setColor(Color.WHITE);
                image.fillRect(0, 0, width, height);
                image.setColor(Color.BLACK);
                
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (byteMatrix.get(i, j)) {
                            image.fillRect(i, j, 1, 1);
                        }
                    }
                }
                if (ImageIO.write(bufferedImage, "png", new File("C://wamp/www/img"+code+".png")))
            {
                System.out.println("-- saved");
            }
                System.out.println("QR created successfully....");
                
            } catch (WriterException ex) {
              System.out.println(ex); 
            } catch (IOException ex) {
                System.out.println(ex);   }
        
        
        
        
    }

    @Override
    public ObservableList<quiz> afficherQuizz() {
     ObservableList<quiz> quiz= FXCollections.observableArrayList();
     String req="SELECT * FROM `quizs` ";
      try {
            Statement st= cnx.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                
                quiz.add(new quiz (rs.getInt("id_quizs"),rs.getString("image"),rs.getString("matiere"),rs.getString("difficulte"),rs.getInt("resultat")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return quiz;
        
    }
        public quiz getQuiz(int id) {
        String req= "SELECT * FROM `quizs` where `id_quizs`= "+id;
         try {
            Statement st= cnx.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                
                return new quiz (rs.getInt("id_quizs"),rs.getString("image"),rs.getString("matiere"),rs.getString("difficulte"),rs.getInt("resultat"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return null;
        
    }
    public ObservableList<quiz> afficherQuizz_diff(String diff) {
     ObservableList<quiz> quiz= FXCollections.observableArrayList();
     String req="SELECT * FROM `quizs` where difficulte = "+diff;
      try {
            Statement st= cnx.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                
                quiz.add(new quiz (rs.getInt("id_quizs"),rs.getString("image"),rs.getString("matiere"),rs.getString("difficulte"),rs.getInt("resultat")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return quiz;
    }
        public void ModifierQuizz_resultat() {
        String req="UPDATE `quizs` SET `resultat`='0'";
        try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
        
    }
        

    @Override
    public void ModifierQuizz(quiz q,int id ) {
        String req="UPDATE (`quizs`) SET `image`= '"+ q.getImage()+"',`difficulte`='"+q.getDifficulte()+"',`matiere`='"+q.getMatiere()+"' WHERE `id_quizs`="+id ;
        try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("modification avec succes");
        
    }

    @Override
    public void SupprimerQuizz(int id) {
        String req= "DELETE FROM `quizs` WHERE `id_quizs`= "+id;
        try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("suppression avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
 public quiz get_quiz_affichage(int i) {
        quiz q = null;
        int nombre = 0;
        String requete = "SELECT * FROM `quizs` ";
           try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (i == nombre) {
     
                   
               q=new quiz (rs.getInt("id_quizs"),rs.getString("image"),rs.getString("matiere"),rs.getString("difficulte"),rs.getInt("resultat"));
                
                }
                nombre++;
                         }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return q;

    }
  /*  @Override
public List<List<question>> listeQ (String difficulte, String matiere){
    Connection cnx = MaConnexion.getInstance().getCnx();
    ResultSet rs=null;
    PreparedStatement ps= null;
    List<question> diff_1 = new ArrayList<question>();
    List<question> diff_2 = new ArrayList<question>();
    List<question> diff_3 = new ArrayList<question>();
        List<List <question>> questions= new ArrayList<List<question>>(); 
        
         try {
             String req= "SELECT * FROM `question` WHERE matiere=?";
             ps= cnx.prepareStatement(req);
             ps.setString(1, matiere);
             rs=ps.executeQuery();
             
            while(rs.next()){
                
                if(rs.getString("difficulte").equals("facile"))
                {
                    diff_1.add(new question (rs.getString("question"), rs.getString("R1"), rs.getString("R2"), rs.getString("R3"), rs.getString("solution"), rs.getString("difficulte")) );
                }
                if(rs.getString("difficulte").equals("moyen"))
                {
                    diff_2.add(new question (rs.getString("question"),rs.getString("R1"),rs.getString("R2"),rs.getString("R3"),rs.getString("solution"),rs.getString("difficulte")) );
                }
                if(rs.getString("difficulte").equals("difficile"))
                {
                    diff_3.add(new question (rs.getString("question"),rs.getString("R1"),rs.getString("R2"),rs.getString("R3"),rs.getString("solution"),rs.getString("difficulte")) );
                }
            }
                questions.add(diff_1);
                questions.add(diff_2);
                questions.add(diff_3);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return questions;
    }
    /*
    @Override
     public void afficher_q(question q) {
        Scanner myObj= new Scanner(System.in);
        System.out.println("niveau"+q.getDifficulte());
        System.out.println("");
        System.out.println("");
        System.out.println("la question est: "+q.getQuestion());
        System.out.println("");
        System.out.println(q.getR1());
        System.out.println("");
        System.out.println(q.getR2());
        System.out.println("");
        System.out.println(q.getR3());
        System.out.println("");
        System.out.println("Veuillez entrez votre reponse:");
        String r= myObj.nextLine();
                   if(r.equals(q.getSolution())){
                       System.out.println("La reponse est correcte");
                       this.resultat++;
                   }else
                       System.out.println("La reponse est incorrecte");
        
    }
    
    @Override
    public void Start_Quiz(){
         Random random = new Random ();
           int nb;
           int i;
           int j ;
            switch(this.difficulte){
   
    case "facile": 
          
           for(i=1; i<4;i++){
               for(j=1;j<5-i;j++)
               {
                   
                   nb=random.nextInt(this.questions.get(i-1).size());
                   afficher_q(this.questions.get(i-1).get(nb));
                   
               }
                    
           }
           System.out.println("Le resultat est : "+this.resultat);
           break;
   
    case "moyen":
           for(i=1; i<4;i++){
               for(j=1;j<5-i;j++)
               {
                   
                   nb=random.nextInt(this.questions.get(i-1).size());
                   afficher_q(this.questions.get(i-1).get(nb));
                   
               }
                
           }
           System.out.println("Le resultat est : "+this.resultat);
           break;
   
       case "difficile":
            for(i=1; i<4;i++){
               for(j=1;j<i+1;j++)
               {
                   
                   nb=random.nextInt(this.questions.get(i-1).size());
                   afficher_q(this.questions.get(i-1).get(nb));
                   
               }
           }
            System.out.println("");
            System.out.println("Le resultat est :" +this.resultat);
           break;
       default:
           System.out.println("Choix incorrect");
           break;
   }
*/
    
    }

