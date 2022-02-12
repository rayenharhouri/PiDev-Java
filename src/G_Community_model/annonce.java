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
    
    public annonce() {
    }

    public annonce(String annonce) {
        this.annonce = annonce;
    }

    public String getAnnonce() {
        return annonce;
    }

    public void setAnnonce(String annonce) {
        this.annonce = annonce;
    }

    @Override
    public String toString() {
        return "annonce{" + "id_annonce=" + id_annonce + ", annonce=" + annonce + '}';
    }
    
    
    

    
    
    
    
    
    
}
