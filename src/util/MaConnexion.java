/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Habib
 */
public class MaConnexion {
    
       //bd
    final static String URL = "jdbc:mysql://127.0.0.1:3306/e_laab";
    final static String USERNAME = "root";
    final static String PWD="";
   
   
    //att
     Connection cnx;
    //singleton *1
    static MaConnexion instance = null;
   
    //construct
    //singleton *2:private

    private MaConnexion() {
       
        try {
            cnx =  (Connection) DriverManager.getConnection(URL, USERNAME , PWD);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }
    //singleton *3

    public static MaConnexion getInstance() {
        if(instance==null){
       instance= new MaConnexion();
        }
        return instance;
    }
}
