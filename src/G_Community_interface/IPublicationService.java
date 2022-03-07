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
public interface IPublicationService {

    //Add Pub
    public void ajouterPublication(publication p, int id_user);

    //Show Pubs
    public List<publication> afficherPubs(int id_user);

    //delete pub
    public void deletePub(int id);

    //Modify pub
    public void modifyPub(int id, String topic);

    //Calculer Nombre de publication par utilisateur
    public List<String> CountUserPub(int id_user);

    //ADD LIKE TO PUB
    public void addLike(int id_pub);

    public String afficherPubID(int id);

    //REMOVE LIKE FROM PUB
    public void disLike(int id_pub);

    //IT CAN BE NEEDED IN PROFILE SECTION OR SOMETHING LIKE THAT
    public List<String> trieSelonUsers();

    public List<String> trieSelonUser();

    public List<String> iduser();

    public List<publication> afficherPub();

}
