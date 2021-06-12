package pfa.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reclamation implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titre;
  private String sujet;


  public Reclamation() {
  }


  public String getSujet() {
    return sujet;
  }

  public void setSujet(String sujet) {
    this.sujet = sujet;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }


  @ManyToOne


  private Person person;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Reclamation(Long id, String titre, String sujet, Person person) {
    this.id = id;
    this.titre = titre;
    this.sujet = sujet;
    this.person = person;
  }
}
