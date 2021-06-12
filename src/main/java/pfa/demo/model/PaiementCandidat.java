package pfa.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class PaiementCandidat implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Float tranchepayee;
  private Float trancherestant;
  private Date datepaiement;
  private String typepaiement;
  @JsonIgnore
  @ManyToOne
  private Candidat candidat;

  public Candidat getCandidat() {
    return candidat;
  }

  public void setCandidat(Candidat candidat) {
    this.candidat = candidat;
  }

  @ManyToOne
  private Session session;

  public Session getSession() {
    return session;
  }

  public void setSession(Session session) {
    this.session = session;
  }

  public  PaiementCandidat(Long id, Float tranchepayee, Float trancherestant , Date datepaiement , String typepaiement){
    this.id=id;
    this.tranchepayee=tranchepayee;
    this.trancherestant=trancherestant;
    this.datepaiement=datepaiement;
    this.typepaiement=typepaiement;

  }
  public PaiementCandidat() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Float getTranchepayee() {
    return tranchepayee;
  }

  public void setTranchepayee(Float tranchepayee) {
    this.tranchepayee = tranchepayee;
  }

  public Float getTrancherestant() {
    return trancherestant;
  }

  public void setTrancherestant(Float trancherestant) {
    this.trancherestant = trancherestant;
  }

  public Date getDatepaiement() {
    return datepaiement;
  }

  public void setDatepaiement(Date datepaiement) {
    this.datepaiement = datepaiement;
  }

  public String getTypepaiement() {
    return typepaiement;
  }

  public void setTypepaiement(String typepaiement) {
    this.typepaiement = typepaiement;
  }
}
