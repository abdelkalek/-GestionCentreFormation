package pfa.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class Promotion implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date date_debut;
  private Date date_fin;
  private String nom_session;
  private String photo;
  private int Prix;
  @ManyToOne
private Session session;

  public void setId(Long id) {
    this.id = id;
  }

  public void setDate_debut(Date date_debut) {
    this.date_debut = date_debut;
  }

  public void setDate_fin(Date date_fin) {
    this.date_fin = date_fin;
  }

  public void setSession(Session session) {
    this.session = session;
  }

  public String getNom_session() {
    return nom_session;
  }

  public void setNom_session(String nom_session) {
    this.nom_session = nom_session;
  }

  public int getPrix() {
    return Prix;
  }

  public void setPrix(int prix) {
    Prix = prix;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Promotion() {
  }

  public Promotion(Long id, Date date_debut, Date date_fin, String nom_session, String photo, int prix) {
    this.id = id;
    this.date_debut = date_debut;
    this.date_fin = date_fin;
    this.nom_session = nom_session;
    this.photo = photo;
    Prix = prix;
  }
}
