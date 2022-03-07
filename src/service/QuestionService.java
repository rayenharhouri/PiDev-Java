/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IquestionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.question;
import model.quiz;
import util.MaConnexion;

/**
 *
 * @author ABDELAZIZ
 */
public class QuestionService implements IquestionService{
    Connection cnx=MaConnexion.getInstance().getCnx();

    @Override
    public void Ajouterquest(question qu) {
        String req= "INSERT INTO `question`(`question`,`matiere`, `R1`, `R2`, `R3`, `solution`, `difficulte`,`id_quizs`) VALUES ('"+qu.getQuestion()+"','"+qu.getMatiere()+"','"+qu.getR1()+"','"+qu.getR2()+"','"+qu.getR3()+"','"+qu.getSolution()+"','"+qu.getDifficulte()+"','"+qu.getId_quizs()+"')";
       try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("ajout avec succes");
    
    
    }

 
   @Override
    public ObservableList<question> afficherquest() {
    
       String req ="SELECT * FROM `question`";
        ObservableList<question> questions=FXCollections.observableArrayList();
        try {
         Statement st = cnx.createStatement();
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
            questions.add(new question(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                System.out.println(questions);
                return questions;
    
    
    }
      public List<question> start_quiz(int id_quiz)  {
          QuizzService qs = new QuizzService();
          quiz q = qs.getQuiz(id_quiz);
    
         List<question> list1=FXCollections.observableArrayList();
         List<question> list2=FXCollections.observableArrayList();
          List<question> list3=FXCollections.observableArrayList();
             List<question> allList12=FXCollections.observableArrayList();
                List<question> allList=FXCollections.observableArrayList();
         //quiz facile  
         // 3 f; 2 moy ; 1 diff
        //quiz moy
        //3moy;2diff;1f
        //quiz diff
        //3diff;2moy;1 f
        String matiere = q.getMatiere();

         
        if (q.getDifficulte().equals("difficile"))
        {
             list1=question_diff_random(id_quiz,"difficile",matiere,3);
             System.out.println("oui"+list1.size());
              list2=question_diff_random(id_quiz,"moyen",matiere,2);
               list3=question_diff_random(id_quiz,"facile",matiere,1);
               allList12= Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
               allList= Stream.concat(allList12.stream(), list3.stream()).collect(Collectors.toList());
        }   else if (q.getDifficulte().equals("facile"))
        {
             list1=question_diff_random(id_quiz,"difficile",matiere,1);
              list2=question_diff_random(id_quiz,"moyen",matiere,2);
               list3=question_diff_random(id_quiz,"facile",matiere,3);
               allList12= Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
               allList= Stream.concat(allList12.stream(), list3.stream()).collect(Collectors.toList()); 
        }
        else
        {
               list1=question_diff_random(id_quiz,"difficile",matiere,2);
              list2=question_diff_random(id_quiz,"moyen",matiere,3);
               list3=question_diff_random(id_quiz,"facile",matiere,1);
               allList12= Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
               allList= Stream.concat(allList12.stream(), list3.stream()).collect(Collectors.toList()); 
        }
         
      
        
              
                return allList;
    
    
    }
      
       public ObservableList<question> question_diff_random(int id_quiz,String diff,String matiere,int limit)  {
          
          String req="SELECT * FROM `question` q where ( q.id_quizs=?  and matiere = ? and difficulte=? ) ORDER BY RAND() LIMIT "+ limit;
           
        ObservableList<question> questions=FXCollections.observableArrayList();
        try {
               PreparedStatement stm = cnx.prepareStatement(req);
               stm.setInt(1, id_quiz);
stm.setString(2, matiere);
 stm.setString(3, diff);      
         ResultSet rs=stm.executeQuery();
          while(rs.next()){
            questions.add(new question(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
              
                return questions;
    
    
    }
    public ObservableList<question> afficherquest_Quiz(int id_quiz) {
    
       String req ="SELECT * FROM `question` where id_quizs = "+id_quiz;
        ObservableList<question> questions=FXCollections.observableArrayList();
        try {
         Statement st = cnx.createStatement();
         ResultSet rs=st.executeQuery(req);
          while(rs.next()){
            questions.add(new question(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9)));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                System.out.println(questions);
                return questions;
    
    
    }

    @Override
    public void Supprimerquest(int id) {
     String req="DELETE FROM `question` WHERE id_question="+id;
         try {
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("suppression fait avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void Modifierquest(int id_question,question q) {
    String req  ="UPDATE `question` SET `question`='"+q.getQuestion()+"',`matiere`='"+q.getMatiere()+"',`R1`='"+q.getR1()+"',`R2`='"+q.getR2()+"',`R3`='"+q.getR3()+"',`solution`='"+q.getSolution()+"' WHERE id_question="+q.getId_question();
     try {
             Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("modification fait avec succes");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
     
    
    }
     public question get_question_affichage(int id) {
        question q = null;
       
        String requete = "SELECT * FROM `question` where id_question="+id;
           try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

            
     
                   
                   q=new question(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9));
         
                         }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return q;

    }
    
}
