/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author melek
 */
public class Utilisateur {
    private int key=5;
    private int ID;
    private String nom;
    private String prenom;
    private String login;
    private String email;
    private String bestgame;
    private String pwd;
    private int nbrs_jeton;
    private int it;
    private int code;
    private String role;
    private String image;
    
    

    public Utilisateur(String nom, String prenom, String login, String email, String bestgame, String pwd, int nbrs_jeton, int it, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
        this.image = image;
    }

    
    
    
    public Utilisateur(String nom, String prenom, String login, String email, String bestgame, String pwd, int it, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.it = it;
        this.image = image;
    }

    public Utilisateur(int ID, String nom, String prenom, String login, String email, String bestgame, String pwd, int nbrs_jeton, int it, String image) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
        this.image = image;
    }

   

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    
    
    
    
    public Utilisateur(int ID, String nom, String prenom, String login, String email, String bestgame, String pwd, int nbrs_jeton, int it, int code, String role, String image) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
        this.code = code;
        this.role = role;
        this.image = image;
    }
    
    
    

    public Utilisateur(String nom, String prenom, String email, String bestgame, String pwd, int nbrs_jeton, int it) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
    }
    
    
    

    public Utilisateur(String nom, String prenom, String login, String email, String bestgame, String pwd, int nbrs_jeton, int it) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
    }
public Utilisateur(String nom, String prenom, String login, String email, String bestgame, String pwd,  int it) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.it = it;
    }
    public Utilisateur(int ID, String nom, String prenom, String login, String email, String bestgame, String pwd, int nbrs_jeton, int it) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.nbrs_jeton = nbrs_jeton;
        this.it = it;
    }
    
    
    

    public Utilisateur(int ID, String nom, String prenom, String email, String bestgame, String pwd, int it) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.it = it;
    }

    public Utilisateur(String nom, String prenom, String email, String bestgame, String pwd, int it) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.bestgame = bestgame;
        this.pwd = pwd;
        this.it = it;
    }
    
    

    

    public Utilisateur() {
        ID=0;
        nom="";
        prenom="";
        email="";
        login="";
        bestgame="";
        pwd="";
        
      
        
        
        

    }

 
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBestgame() {
        return bestgame;
    }

    public void setBestgame(String bestgame) {
        this.bestgame = bestgame;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public int getNbrs_jeton() {
        return nbrs_jeton;
    }

    public void setNbrs_jeton(int nbrs_jeton) {
        this.nbrs_jeton = nbrs_jeton;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "key=" + key + ", ID=" + ID + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", email=" + email + ", bestgame=" + bestgame + ", pwd=" + pwd + ", nbrs_jeton=" + nbrs_jeton + ", it=" + it + ", code=" + code + ", role=" + role + ", image=" + image + '}';
    }
    
    
    

   
    
    public String encrypt (String text)
    {
        String altern="";
        char[] chars= text.toCharArray();
        for(char c: chars) {
            c+=this.key;
            altern+=c;
        }
        return altern;
    }
    public String decrypt (String text)
    {
                String altern="";

       
        char[] chars= text.toCharArray();
        for(char c: chars) {
            c-=this.key;
            altern+=c;
        }
       
        return altern;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    

    

   

   
    
    
    
    
    
}
