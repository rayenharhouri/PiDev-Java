/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ABDELAZIZ
 */
public class question {
    private int id_question;
    private String question;
    private String matiere;
    private String R1;
    private String R2;
    private String R3;
    private String solution;
    private String difficulte;
    private int id_quizs;

    public question() {
    }

    public question(int id_question, String question, String matiere, String R1, String R2, String R3, String solution, String difficulte, int id_quizs) {
        this.id_question = id_question;
        this.question = question;
        this.matiere = matiere;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.solution = solution;
        this.difficulte = difficulte;
        this.id_quizs = id_quizs;
    }

    @Override
    public String toString() {
        return "question{" + "id_question=" + id_question + ", question=" + question + ", matiere=" + matiere + ", R1=" + R1 + ", R2=" + R2 + ", R3=" + R3 +", difficulte=" + difficulte + ", id_quizs=" + id_quizs + '}';
    }

    public question(String question, String matiere, String R1, String R2, String R3, String solution, String difficulte, int id_quizs) {
        this.question = question;
        this.matiere = matiere;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.solution = solution;
        this.difficulte = difficulte;
        this.id_quizs = id_quizs;
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

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
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

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public int getId_quizs() {
        return id_quizs;
    }

    public void setId_quizs(int id_quizs) {
        this.id_quizs = id_quizs;
    }

  
    
    
}
