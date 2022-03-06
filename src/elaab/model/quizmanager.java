/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elaab.model;

/**
 *
 * @author Habib
 */
public class quizmanager {
    private int id_qm ;
    private String email ;
    private String password ;

    public int getId_qm() {
        return id_qm;
    }

    public void setId_qm(int id_qm) {
        this.id_qm = id_qm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "quizmanager{" + "id_qm=" + id_qm + ", email=" + email + ", password=" + password + '}';
    }

    public quizmanager() {
    }

    public quizmanager(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public quizmanager(int id_qm, String email, String password) {
        this.id_qm = id_qm;
        this.email = email;
        this.password = password;
    }

    public String getemail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getpassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
