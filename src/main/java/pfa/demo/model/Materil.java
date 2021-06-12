package pfa.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Materil implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String prix;
  private String labell;
  @ManyToOne
  private BesoinMateril besoinMateril;


  public BesoinMateril getBesoinMateril() {
    return besoinMateril;
  }

  public void setBesoinMateril(BesoinMateril besoinMateril) {
    this.besoinMateril = besoinMateril;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPrix() {
    return prix;
  }

  public void setPrix(String prix) {
    this.prix = prix;
  }

  public String getLabell() {
    return labell;
  }

  public void setLabell(String labell) {
    this.labell = labell;
  }

  public Materil() {
  }

  public Materil(Long id, String prix, String labell) {
    this.id = id;
    this.prix = prix;
    this.labell = labell;
  }
}



