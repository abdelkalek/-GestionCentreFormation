package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Salle implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String capcite_salle;
  private String nom_salle;
  private String adress_salle;
  @OneToMany(mappedBy = "salle")
  @JsonIgnore
  private List<Session> sessionListS;
  @ManyToOne
  private EmploiTemps emploiTempsP;

  public List<Session> getSessionListS() {
    return sessionListS;
  }

  public void setSessionListS(List<Session> sessionListS) {
    this.sessionListS = sessionListS;
  }

  public EmploiTemps getEmploiTempsP() {
    return emploiTempsP;
  }

  public void setEmploiTempsP(EmploiTemps emploiTempsP) {
    this.emploiTempsP = emploiTempsP;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCapcite_salle() {
    return capcite_salle;
  }

  public void setCapcite_salle(String capcite_salle) {
    this.capcite_salle = capcite_salle;
  }

  public String getNom_salle() {
    return nom_salle;
  }

  public void setNom_salle(String nom_salle) {
    this.nom_salle = nom_salle;
  }

  public String getAdress_salle() {
    return adress_salle;
  }

  public void setAdress_salle(String adress_salle) {
    this.adress_salle = adress_salle;
  }

  public Salle(Long id, String capcite_salle, String nom_salle, String adress_salle) {
    this.id = id;
    this.capcite_salle = capcite_salle;
    this.nom_salle = nom_salle;
    this.adress_salle = adress_salle;
  }

  public Salle() {
  }
}
