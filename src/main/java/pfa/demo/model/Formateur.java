package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Formateur extends Person {
  private String specailite;
  private String salair;
  private int note;
  @OneToMany(mappedBy = "formateur")
  @JsonIgnore
  private List<Formation> formationList;
  @OneToMany(mappedBy = "formateurAvis")
  @JsonIgnore
  private List<Avis> avisList;
  @OneToOne(cascade = CascadeType.ALL)
  private PayementFormateur payementFormateur;

  public List<Avis> getAvisList() {
    return avisList;
  }

  public void setAvisList(List<Avis> avisList) {
    this.avisList = avisList;
  }

  public List<Formation> getFormationList() {
    return formationList;
  }

  public void setFormationList(List<Formation> formationList) {
    this.formationList = formationList;
  }

  public int getNote() {
    return note;
  }

  public void setNote(int note) {
    this.note = note;
  }

  public String getSpecailite() {
    return specailite;
  }

  public void setSpecailite(String specailite) {
    this.specailite = specailite;
  }

  public String getSalair() {
    return salair;
  }

  public void setSalair(String salair) {
    this.salair = salair;
  }

  public Formateur() {
  }

  public Formateur(Long id, String email, String password, String username, String nom, String prenom, String adress, String numeroTel, String cv, String photo, String cin, Date dateinscription, List<Reclamation> recalamtions, List<AppRole> roles, String specailite, String salair, int note, String confirmPassword) {
    super(id, email, password, username, nom, prenom, adress, numeroTel, cv, photo, cin,dateinscription, recalamtions, roles,confirmPassword);
    this.specailite = specailite;
    this.salair = salair;
    this.note = note;
  }
}
