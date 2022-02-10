package G_Community_model;

import java.util.Date;

public class publication {

    private int id_pub;
    private int reactions;
    private Date date_pub;
    private int nbre_commentaire;
    private String topic;
    private int id_u;

    //default constructor
    public publication() {
    }

    //constuctor with params without ID_pub&user
    public publication(int reactions, int nbre_commentaire, String topic) {
        this.reactions = reactions;
        this.nbre_commentaire = nbre_commentaire;
        this.topic = topic;
    }

    //getters and setters
    public int getId_pub() {
        return this.id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public int getReactions() {
        return this.reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }

    public int getNbre_commentaire() {
        return this.nbre_commentaire;
    }

    public void setNbre_commentaire(int nbre_commentaire) {
        this.nbre_commentaire = nbre_commentaire;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId_u() {
        return this.id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public Date getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(Date date_pub) {
        this.date_pub = date_pub;
    }
    

    //toString

    @Override
    public String toString() {
        return "publication{" + "id_pub=" + id_pub + ", reactions=" + reactions + ", ddate_pub=" + date_pub + ", nbre_commentaire=" + nbre_commentaire + ", topic=" + topic + ", id_u=" + id_u + '}';
    }
   

}
