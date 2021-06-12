package pfa.demo.model;

import javax.persistence.*;

@Entity
public class EmploiTemps {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String jour;
  private String heure_debut;
  private String heure_fin;
  @ManyToOne
  private Session sessionF;
//    @OneToMany(mappedBy = "emploiTempsP")
//    @JsonIgnore
//    private List<Salle> salleList;

  @ManyToOne
  private Formateur formateur;

  public Session getSessionF() {
    return sessionF;
  }

  public void setSessionF(Session sessionF) {
    this.sessionF = sessionF;
  }

  public Formateur getFormateur() {
    return formateur;
  }

  public void setFormateur(Formateur formateur) {
    this.formateur = formateur;
  }

//    public List<Salle> getSalleList() {
//        return salleList;
//    }
//
//    public void setSalleList(List<Salle> salleList) {
//        this.salleList = salleList;
//    }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getJour() {
    return jour;
  }

  public void setJour(String jour) {
    this.jour = jour;
  }

  public String getHeure_debut() {
    return heure_debut;
  }

  public void setHeure_debut(String heure_debut) {
    this.heure_debut = heure_debut;
  }

  public String getHeure_fin() {
    return heure_fin;
  }

  public void setHeure_fin(String heure_fin) {
    this.heure_fin = heure_fin;
  }

  public EmploiTemps() {
  }

  public EmploiTemps(Long id, String jour, String heure_debut, String heure_fin) {
    this.id = id;
    this.jour = jour;
    this.heure_debut = heure_debut;
    this.heure_fin = heure_fin;
  }
}
