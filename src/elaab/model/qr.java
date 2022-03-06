/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elaab.model;

import java.util.logging.Logger;

/**
 *
 * @author Habib
 */
public class qr {
 
    
   private int id_question;
   private String question ;
   private String theme ;

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }
   private String R1;
   private String R2;
   private String R3;
   private String solution ;
   private String diff;

    public String getDiff() {
        return diff;
    }
   

    
    public qr(int id_question, String question, String theme, String R1, String R2, String R3, String solution, String diff) {
        this.id_question = id_question;
        this.question = question;
        this.theme = theme;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.solution = solution;
        this.diff = diff;
    }

    public qr(String question, String R1, String R2, String R3, String solution,String diff) {
        this.question = question;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.solution = solution;
        this.diff=diff;
    }
  
    


    

    public qr() {
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getR1() {
        return R1;
    }

    public void setR1(String R1) {
        this.R1 = R1;
    }

    public String getR2() {
        return R2;
    }

    public void setR2(String R2) {
        this.R2 = R2;
    }

    public String getR3() {
        return R3;
    }

    public void setR3(String R3) {
        this.R3 = R3;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "qr{" + "id_question=" + id_question + ", question=" + question + ", theme=" + theme + ", R1=" + R1 + ", R2=" + R2 + ", R3=" + R3 + ", solution=" + solution + ", diff=" + diff + '}';
    }

    


}

       
   
