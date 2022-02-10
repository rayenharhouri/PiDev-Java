/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_interface;

import java.util.List;

import G_Community_model.publication;

/**
 *  
 * @author MSI
 */
public interface IpublicationService {
    
    //Add Pub
    public void ajouterPublication(publication p);

    //Show Pubs
    public List<publication> afficherPubs();
}
