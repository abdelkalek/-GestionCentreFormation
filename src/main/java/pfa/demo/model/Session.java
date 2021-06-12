package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date datedebut;
  private Date datefin;
  private String ville;
  private String photo;
  private String description;
  private int prixprom;

  private String chareg;
  private String motcle;

  @OneToOne
  private BesoinMateril besoinMateril;

  @ManyToMany
  @JsonIgnore
  private List<Candidat> candidatList;
  @OneToMany(mappedBy = "sessionF", cascade = CascadeType.ALL)
  private List<EmploiTemps> emploiTemps;


  @ManyToOne
  private Formation sessionFormation;
  @ManyToOne
  private Formateur formateur;

  @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<PaiementCandidat> paymentFormationList;


  @ManyToOne
  private Salle salle;

  @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Promotion> promotions;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDatedebut() {
    return datedebut;
  }

  public void setDatedebut(Date datedebut) {
    this.datedebut = datedebut;
  }

  public Date getDatefin() {
    return datefin;
  }

  public void setDatefin(Date datefin) {
    this.datefin = datefin;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getChareg() {
    return chareg;
  }

  public void setChareg(String chareg) {
    this.chareg = chareg;
  }

  public String getMotcle() {
    return motcle;
  }

  public void setMotcle(String motcle) {
    this.motcle = motcle;
  }

  public BesoinMateril getBesoinMateril() {
    return besoinMateril;
  }

  public void setBesoinMateril(BesoinMateril besoinMateril) {
    this.besoinMateril = besoinMateril;
  }

  public List<Candidat> getCandidatList() {
    return candidatList;
  }

  public void setCandidatList(List<Candidat> candidatList) {
    this.candidatList = candidatList;
  }

  public List<EmploiTemps> getEmploiTemps() {
    return emploiTemps;
  }

  public void setEmploiTemps(List<EmploiTemps> emploiTemps) {
    this.emploiTemps = emploiTemps;
  }

  public Formation getSessionFormation() {
    return sessionFormation;
  }

  public void setSessionFormation(Formation sessionFormation) {
    this.sessionFormation = sessionFormation;
  }

  public int getPrixprom() {
    return prixprom;
  }

  public void setPrixprom(int prixprom) {
    this.prixprom = prixprom;
  }

  public Formateur getFormateur() {
    return formateur;
  }

  public void setFormateur(Formateur formateur) {
    this.formateur = formateur;
  }

  public List<PaiementCandidat> getPaymentFormationList() {
    return paymentFormationList;
  }

  public void setPaymentFormationList(List<PaiementCandidat> paymentFormationList) {
    this.paymentFormationList = paymentFormationList;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Salle getSalle() {
    return salle;
  }

  public void setSalle(Salle salle) {
    this.salle = salle;
  }

  public List<Promotion> getPromotions() {
    return promotions;
  }

  public void setPromotions(List<Promotion> promotions) {
    this.promotions = promotions;
  }
  public Session(Long id, String ville, String photo, String description , Date dateDebut, Date dateFin, String motcle, String emploidetemps, String charge, String prix, CategorieFormation categorieFormation) {
    this.id = id;
    this.ville = ville;
    this.photo = photo;
    this.description = description;
    this.datedebut = dateDebut;
    this.datefin = dateFin;
    this.motcle = motcle;
    this.chareg = charge;

  } public Session() {
  }
}
