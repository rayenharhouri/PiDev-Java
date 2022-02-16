/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_model;

/**
 *
 * @author MSI
 */
public class annonce {
    private int id_annonce;
    private String annonce;
    private int id_CM;
    
    public annonce() {
    }

    public annonce(String annonce ,int id_CM) {
        this.annonce = annonce;
        this.id_CM = id_CM;
    }

    public annonce(int id_annonce, String annonce,int id_CM) {
        this.id_annonce = id_annonce;
        this.annonce = annonce;
        this.id_CM = id_CM;
    }

    public String getAnnonce() {
        return annonce;
    }

    public void setAnnonce(String annonce) {
        this.annonce = annonce;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_CM() {
        return id_CM;
    }

    public void setId_CM(int id_CM) {
        this.id_CM = id_CM;
    }
    

    @Override
    public String toString() {
        return "annonce{" + "\n Id_annonce= " + id_annonce + "\n Annonce=" + annonce + "\n ID_CM=" + id_CM + "\n}";
    }
    
    
    

    
    
    
    
    
    
}
