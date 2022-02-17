/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author user
 */
public class MaConnexion {
 
    //BD Credentials
    final static String URL ="jdbc:mysql://127.0.0.1:3306/pi";
    final static String USERNAME = "root";
    final static String PWD = "";
    
    //att
    private Connection cnx;
    
    //singleton
    static MaConnexion instance = null;
    
    
    //constructor
     //singleton #2
    private MaConnexion() {
    
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("connexion etablie avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //getters&setters
    public Connection getCnx() {
        return cnx;
    }

      
     //singleton #3

    public static MaConnexion getInstance() {
        if(instance == null){
            instance = new MaConnexion();
        }
        return instance;
    }
    
}
