import java.util.List;
import model.publication;

public interface IpublicationService {

    //Add new Publication 
    public void ajouterPublication(publication p);

    //Afficher les publications
    public List<publication> afficherPublications();




}

