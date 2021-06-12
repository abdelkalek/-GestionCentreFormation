package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity

public class Formation implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String supportCours;
  private Date dateDebut ;
  private String nom;
  private String description;

  private String photo;

  private Date dateFin;
  private String motcle;
  private String horaire;
  private String charge;
  private String prix;
  private int note;
  @ManyToMany
  private List<Candidat> candidatList;
  @ManyToOne
  private Formateur formateur;
  @ManyToOne
  private CategorieFormation categorieFormation;
  @ManyToMany
  private List<SupportFor> supportForList;
  @OneToMany(mappedBy = "formation")
  private List<Commentaire> commentaireList;
  @JsonIgnore
  @OneToOne(mappedBy = "formation")
  private FichePresence fichedepresence;
  @OneToMany(mappedBy = "formation")
  @JsonIgnore

  private List<Avis> avisList;
  @OneToMany(mappedBy = "sessionFormation")
  @JsonIgnore
  private List<Session> sessionList;

  public List<Session> getSessionList() {
    return sessionList;
  }

  public void setSessionList(List<Session> sessionList) {
    this.sessionList = sessionList;
  }

  public FichePresence getFichedepresence() {
    return fichedepresence;
  }

  public void setFichedepresence(FichePresence fichedepresence) {
    this.fichedepresence = fichedepresence;
  }

  public List<Avis> getAvisList() {
    return avisList;
  }

  public void setAvisList(List<Avis> avisList) {
    this.avisList = avisList;
  }

  public List<Commentaire> getCommentaireList() {
    return commentaireList;
  }

  public void setCommentaireList(List<Commentaire> commentaireList) {
    this.commentaireList = commentaireList;
  }

  public Formateur getFormateur() {
    return formateur;
  }

  public void setFormateur(Formateur formateur) {
    this.formateur = formateur;
  }

  public List<Candidat> getCandidatList() {
    return candidatList;
  }

  public void setCandidatList(List<Candidat> candidatList) {
    this.candidatList = candidatList;
  }

  public List<SupportFor> getSupportForList() {
    return supportForList;
  }

  public void setSupportForList(List<SupportFor> supportForList) {
    this.supportForList = supportForList;
  }

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public CategorieFormation getCategorieFormation() {
    return categorieFormation;
  }

  public void setCategorieFormation(CategorieFormation categorieFormation) {
    this.categorieFormation = categorieFormation;
  }

  public Date getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String getMotcle() {
    return motcle;
  }

  public void setMotcle(String motcle) {
    this.motcle = motcle;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getCharge() {
    return charge;
  }

  public void setCharge(String charge) {
    this.charge = charge;
  }


  public String getHoraire() {
    return horaire;
  }

  public void setHoraire(String horaire) {
    this.horaire = horaire;
  }

  public String getPrix() {
    return prix;
  }

  public void setPrix(String prix) {
    this.prix = prix;
  }

  public String getSupportCours() {
    return supportCours;
  }

  public void setSupportCours(String supportCours) {
    this.supportCours = supportCours;
  }

  public int getNote() {
    return note;
  }

  public void setNote(int note) {
    this.note = note;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Formation() {
  }

  public Formation(Long id, String supportCours, String photo, String description, Date dateDebut, String  nom , Date dateFin, String motcle, String horaire, String charge, String prix, CategorieFormation categorieFormation) {
    this.id = id;
    this.supportCours = supportCours;
       this.dateDebut = dateDebut;
       this.nom=nom;

    this.dateFin = dateFin;
    this.motcle = motcle;
    this.photo = photo;
    this.description = description;
    this.horaire = horaire;
    this.charge = charge;
    this.prix = prix;
    this.categorieFormation = categorieFormation;
  }
}
