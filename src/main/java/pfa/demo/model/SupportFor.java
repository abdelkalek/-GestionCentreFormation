package pfa.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SupportFor implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String nom;
  private String Type;


  @ManyToMany
  private List<Formation> formationList;

  public List<Formation> getFormationList() {
    return formationList;
  }

  public void setFormationList(List<Formation> formationList) {
    this.formationList = formationList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getType() {
    return Type;
  }

  public void setType(String type) {
    Type = type;
  }

  public SupportFor() {
  }

  public SupportFor(Long id, String nom, String type) {
    this.id = id;
    this.nom = nom;
    Type = type;
  }
}
