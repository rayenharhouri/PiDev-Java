/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Community_interface;

import G_Community_model.CommunityManager;
import java.util.List;

/**
 *
 * @author MSI
 */
public interface IcommunityManagerService {
          //Add comment
    public void addCM(CommunityManager cm);

    //Show comment
    public List<String> showCM(int id_cm);
    
    //delete comment
    public void deleteCM(int id_cm);
    
    //Modify comment
    public void modifyCM(int id_cm,String np);  
}
