package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Commentaire {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String contenu;
  private Date datecomentaire;
  @ManyToOne
  private Candidat candidat;

  public Commentaire(Long id, String contenu, Date datecomentaire, Candidat candidat, Formation formation) {
    this.id = id;
    this.contenu = contenu;
    this.datecomentaire = datecomentaire;
    this.candidat = candidat;
    this.formation = formation;
  }

  @ManyToOne
  @JsonIgnore
  private Formation formation;

  public Candidat getCandidat() {
    return candidat;
  }

  public void setCandidat(Candidat candidat) {
    this.candidat = candidat;
  }

  public Formation getFormation() {
    return formation;
  }

  public void setFormation(Formation formation) {
    this.formation = formation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContenu() {
    return contenu;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  public Date getDatecomentaire() {
    return datecomentaire;
  }

  public void setDatecomentaire(Date datecomentaire) {
    this.datecomentaire = datecomentaire;
  }

  public Commentaire() {
  }

}
