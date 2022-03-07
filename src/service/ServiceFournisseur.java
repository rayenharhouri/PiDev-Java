/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.fournisseur;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MaConnexion;
import interfaces.IService_store;

/**
 *
 * @author HP
 */
public class ServiceFournisseur implements IService_store<fournisseur> {
    Connection cnx;

    public ServiceFournisseur() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(fournisseur t) {
        try {
        String req = "insert into fournisseur (nom_fournisseur,num_tel) "
                + "values"+"('"+t.getNom_fournisseur()+"',"+t.getNum_tel()+")";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @Override
    public List<fournisseur> afficher() {
        List<fournisseur> list =new ArrayList<>();
        try{
            String req ="select * from fournisseur";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        fournisseur r =new fournisseur();
        r.setId_fournisseur(rs.getInt("id_fournisseur"));
        r.setNom_fournisseur(rs.getString("nom_fournisseur"));
        r.setNum_tel(rs.getInt("num_tel"));
        
        
          list.add(r); 
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }

    @Override
    public void modifier(fournisseur t) {
      try {
        String req ="update fournisseur set nom_fournisseur= ? , num_tel= ? where id_fournisseur = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getNom_fournisseur());
        ps.setInt(2, t.getNum_tel());
        ps.setInt(3,t.getId_fournisseur());
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprimer(int id) {
        try {
        String req ="delete from fournisseur where id_fournisseur=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        ServiceProduit serP=new ServiceProduit();
        serP.supprimerByFournisseur(id);
    }  
    }
    
    public fournisseur getFournisseurById(int id){
        fournisseur r =new fournisseur();
        try{
            String req ="select * from fournisseur where id_fournisseur="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId_fournisseur(rs.getInt("id_fournisseur"));
        r.setNom_fournisseur(rs.getString("nom_fournisseur"));
        r.setNum_tel(rs.getInt("num_tel"));
        
        
       
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
    public fournisseur getFournisseurByNom(String nom){
        fournisseur r =new fournisseur();
        try{
            String req ="select * from fournisseur where nom_fournisseur='"+nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId_fournisseur(rs.getInt("id_fournisseur"));
        r.setNom_fournisseur(rs.getString("nom_fournisseur"));
        r.setNum_tel(rs.getInt("num_tel"));
        
        
       
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
    public void pdf(int id ,String nom) throws SQLException, ClassNotFoundException{
        try {
           Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "");
  Statement stmt = con.createStatement();
                    /* Define the SQL query */
                    ResultSet query_set = stmt.executeQuery("SELECT *From produit where id_fournisseur="+id+"");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_"+nom+".pdf"));
                    my_pdf_report.open();            
                    //we have four columns in our table
                    PdfPTable my_report_table = new PdfPTable(4);
                    //create a cell object
                    PdfPCell table_cell;
                    Phrase o3=new Phrase("id");
            Phrase o4=new Phrase("Type");
            Phrase o5=new Phrase("Prix");
            Phrase o6=new Phrase("Quantitée");
           
           
           PdfPCell prx1=new PdfPCell(o3);
           prx1.setBackgroundColor(BaseColor.LIGHT_GRAY);
           PdfPCell prx2=new PdfPCell(o4);
           prx2.setBackgroundColor(BaseColor.LIGHT_GRAY);
           PdfPCell obj=new PdfPCell(o5);
           obj.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
           PdfPCell prx=new PdfPCell(o6);
           prx.setBackgroundColor(BaseColor.LIGHT_GRAY);
           my_report_table.addCell(prx1);
           my_report_table.addCell(prx2);
           my_report_table.addCell(obj);
           my_report_table.addCell(prx);
                    while (query_set.next()) {                
                                    String dept_id = query_set.getString("id_produit");
                                    table_cell=new PdfPCell(new Phrase(dept_id));
                                    my_report_table.addCell(table_cell);
                                    String dept_name=query_set.getString("type_produit");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);
                                    String manager_id=query_set.getString("prix");
                                    table_cell=new PdfPCell(new Phrase(manager_id));
                                    my_report_table.addCell(table_cell);
                                    String location_id=query_set.getString("quantite");
                                    table_cell=new PdfPCell(new Phrase(location_id));
                                    my_report_table.addCell(table_cell);
                                    }
                    /* Attach report table to PDF */
                    my_pdf_report.add(my_report_table);                       
                    my_pdf_report.close();

                    /* Close all DB related objects */
                    query_set.close();
                    stmt.close(); 
                    con.close();               



    } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    } catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }
    
}
