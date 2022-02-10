/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class Connexion {

    //BD Credentials
    final static String URL = "jdbc:mysql://127.0.0.1:3306/e_laab";
    final static String USERNAME= "root";
    final static String PWD = "";

    //att
    private Connection cnx;
    //Singleton #1
    static Connexion instanceConnexion = null;
    



    //Constructor 
    //Singleton #2 : private
    private Connexion() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("cnx successsssssss !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Getters Setters
    public Connection getCnx() {
        return this.cnx;
    }
    //Singleton #3
    public static Connexion getInstance() {
        if(instanceConnexion == null){
            instanceConnexion = new Connexion();
        }
        return instanceConnexion;
    }
    

}
