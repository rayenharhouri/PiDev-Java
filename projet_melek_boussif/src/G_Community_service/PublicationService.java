package G_Community_service;

import java.util.List;

import G_Community_interface.*;
import G_Community_model.publication;
import G_Community_util.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PublicationService implements IPublicationService {

    //var
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void ajouterPublication(publication p, int id_user) {
        //req
        String query = "INSERT INTO `publication`(`idu`,`reactions`, `nbre_commentaires`, `topic`) VALUES (" + id_user + "," + p.getReactions() + "," + p.getNbre_commentaire() + ",'" + p.getTopic() + "')";

        try {
            //INSERT
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Ajout avec secces !!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<publication> afficherPubs(int id_user) {
        List<publication> data = new ArrayList<>();
        String query = "SELECT * FROM `publication` where id_u="+id_user;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new publication(rs.getInt(1), rs.getInt(4), rs.getDate(3), rs.getInt(5), rs.getString(6), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("PUBLICATION :");
        System.out.println(data);
        return data;
    }
      @Override
    public List<publication> afficherPub() {
        List<publication> data = new ArrayList<>();
        String query = "SELECT * FROM `publication` ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new publication(rs.getInt(1), rs.getInt(4), rs.getDate(3), rs.getInt(5), rs.getString(6), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("PUBLICATION :");
        System.out.println(data);
        return data;
    }

    @Override
    public void deletePub(int id) {

        //req
        String query = "DELETE FROM `publication` WHERE id_pub=" + id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyPub(int id, String topic) {
        //req
        String query = "UPDATE `publication` SET `topic`='" + topic + "' WHERE id_pub= " + id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Modify Done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> CountUserPub(int id_user) {
        String query = "SELECT `topic`,`id_pub` FROM `publication` WHERE idu=" + id_user;
        String query1 = "SELECT  `nom`,`prenom` FROM `utilisateur` WHERE idu=" + id_user;
        List<String> data = new ArrayList<>();
        long Tot = 0;
        String nom_u = "";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(rs.getInt("id_pub")+rs.getString("topic"));
            }
            Tot = data.stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement st1 = cnx.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            rs1.first();
            nom_u = rs1.getString(1) + " " + rs1.getString(2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("L'utilisateur D'ID = " + id_user + " et Son NOM&PRENOM = " + nom_u + " a publier " + Tot + " Publications");
        return data;
    }

    @Override
    public void addLike(int id_pub) {

        //req
        String query = "UPDATE `publication` AS T1,"
                + "      (SELECT `reactions`"
                + "        FROM `publication` "
                + "        WHERE id_pub = " + id_pub + ") AS T2 "
                + "  SET T1.`reactions`=T2.`reactions` + 1 "
                + "WHERE T1.id_pub =" + id_pub;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("I LIKE :D");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void disLike(int id_pub) {

        //req
        String query = "UPDATE `publication` AS T1,"
                + "      (SELECT `reactions`"
                + "        FROM `publication` "
                + "        WHERE id_pub = " + id_pub + ") AS T2 "
                + "  SET T1.`reactions`=T2.`reactions` - 1 "
                + "WHERE T1.id_pub =" + id_pub;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("I DONT\'T LIKE :");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> trieSelonUsers() {
        List<String> test = new ArrayList<>();
        List<String> L = new ArrayList<>();
        Set<String> dataIdUser = new TreeSet<>((a, b) -> a.compareTo(b));
        int id_user = 0;
        String query = "SELECT * FROM `publication` ";
        String nomP = "";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dataIdUser.add(rs.getString("id_u"));
                test = dataIdUser.stream()
                        .collect(Collectors.toList());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < test.size(); i++) {
            id_user = Integer.parseInt(test.get(i));
            String queryy = "SELECT `reactions`, `nbre_commentaires`, `topic` FROM `publication` WHERE idu=" + id_user;
            String queryyy = "SELECT  `nom`,`prenom` FROM `utilisateur` WHERE idu=" + id_user;
            try {
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(queryy);
                Statement st1 = cnx.createStatement();
                ResultSet rs1 = st1.executeQuery(queryyy);
                while (rs1.next()) {
                    nomP = "ツ " + rs1.getString(1) + " " + rs1.getString(2) + " ツ ";
                }
                while (rs.next()) {
                    System.out.println(nomP + "\n" + rs.getString(3) + "\n" + " Comments = " + rs.getInt(2) + " | " + " " + "Likes = " + rs.getInt(1));
                    L.add(rs.getString(3) + "\n" + "\n");
                    System.out.println("---------------------------------------------------------------");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return L;
    }

    @Override
    public List<String> trieSelonUser() {
        List<String> test = new ArrayList<>();
        List<String> L = new ArrayList<>();
        Set<String> dataIdUser = new TreeSet<>((a, b) -> a.compareTo(b));
        int id_user = 0;
        String query = "SELECT * FROM `publication` ";
        String nomP = "";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dataIdUser.add(rs.getString("idu"));
                test = dataIdUser.stream()
                        .collect(Collectors.toList());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < test.size(); i++) {
            id_user = Integer.parseInt(test.get(i));
            String queryyy = "SELECT  `nom`,`prenom` FROM `utilisateur` WHERE idu=" + id_user;
            try {
                Statement st1 = cnx.createStatement();
                ResultSet rs1 = st1.executeQuery(queryyy);
                while (rs1.next()) {
                    nomP = "ツ " + rs1.getString(1) + " " + rs1.getString(2) + " ツ " + "\n" + "\n";
                    L.add(nomP);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return L;
    }

    @Override
    public String afficherPubID(int id) {
        // List<publication> data = new ArrayList<>();
        String s = "";
        String query = "SELECT `topic` FROM `publication` where idpub=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.first();
            s = rs.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(s);
        return s;
    }

    @Override
    public List<String> iduser() {
             List<String> test = new ArrayList<>();
        List<String> L = new ArrayList<>();
        Set<String> dataIdUser = new TreeSet<>((a, b) -> a.compareTo(b));
        int id_user = 0;
        String query = "SELECT * FROM `publication` ";
        String nomP = "";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dataIdUser.add(rs.getString("idu"));
                test = dataIdUser.stream()
                        .collect(Collectors.toList());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < test.size(); i++) {
            id_user = Integer.parseInt(test.get(i));
            String queryyy = "SELECT  `nom`,`prenom` FROM `utilisateur` WHERE idu=" + id_user;
            try {
                Statement st1 = cnx.createStatement();
                ResultSet rs1 = st1.executeQuery(queryyy);
                while (rs1.next()) {
                    nomP = "ツ " + rs1.getString(1) + " " + rs1.getString(2) + " ツ " + "\n" + "\n";
                    L.add(nomP);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(dataIdUser);
        return test;
    }
}
