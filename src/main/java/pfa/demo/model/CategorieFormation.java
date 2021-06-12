package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategorieFormation implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)

  private Long id_categorie;
  private String nom_categorie;

  @OneToMany(mappedBy = "categorieFormation")
  @JsonIgnore
  private List<Formation> formations;

  public void setId_categorie(Long id_categorie) {
    this.id_categorie = id_categorie;
  }

  public void setFormations(List<Formation> formations) {
    this.formations = formations;
  }

  public Long getId_categorie() {
    return id_categorie;
  }

  public List<Formation> getFormations() {
    return formations;
  }

  public String getNom_categorie() {
    return nom_categorie;
  }

  public void setNom_categorie(String nom_categorie) {
    this.nom_categorie = nom_categorie;
  }



  public CategorieFormation() {
  }

  public CategorieFormation(Long id_categorie, String nom_categorie) {
    this.id_categorie = id_categorie;
    this.nom_categorie = nom_categorie;


  }
}
