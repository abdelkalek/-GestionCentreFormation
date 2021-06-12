package pfa.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PayementFormateur implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String conge;
  private String avance;
  private String salaire;
  private String trancheRestant;
  private boolean etat = false;
  @OneToOne(mappedBy = "payementFormateur")
  private Formateur formateurp;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getConge() {
    return conge;
  }

  public void setConge(String conge) {
    this.conge = conge;
  }

  public String getAvance() {
    return avance;
  }

  public void setAvance(String avance) {
    this.avance = avance;
  }

  public String getSalaire() {
    return salaire;
  }

  public void setSalaire(String salaire) {
    this.salaire = salaire;
  }

  public String getTrancheRestant() {
    return trancheRestant;
  }

  public void setTrancheRestant(String trancheRestant) {
    this.trancheRestant = trancheRestant;
  }

  public boolean isEtat() {
    return etat;
  }

  public void setEtat(boolean etat) {
    this.etat = etat;
  }

  public Formateur getFormateurp() {
    return formateurp;
  }

  public void setFormateurp(Formateur formateurp) {
    this.formateurp = formateurp;
  }

  public PayementFormateur(Long id, String conge, String avance, String salaire) {
    this.id = id;
    this.salaire = salaire;
    this.conge = conge;
    this.avance = avance;

  }

  public PayementFormateur() {
  }
}

