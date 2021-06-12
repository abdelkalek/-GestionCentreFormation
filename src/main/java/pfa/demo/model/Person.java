package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Person implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String email;
  @Column(unique = true)
  private String username;
  private String password;
  private String confirmPassword;
  private String nom;
  private String prenom;
  private String adress;
  private String numeroTel;
  private String cv;
  private String photo;
  private String cin;
  private Date dateinscription = new Date();
  @OneToMany(mappedBy = "person")
  @JsonIgnore
  private List<Reclamation> recalamtions;
  @ManyToMany(fetch = FetchType.EAGER)
  private List<AppRole> roles = new ArrayList<>();


  public List<AppRole> getRoles() {
    return roles;
  }

  public void setRoles(List<AppRole> roles) {
    this.roles = roles;
  }

  public List<Reclamation> getRecalamtions() {
    return recalamtions;
  }

  public void setRecalamtions(List<Reclamation> recalamtions) {
    this.recalamtions = recalamtions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getCv() {
    return cv;
  }

  public void setCv(String cv) {
    this.cv = cv;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getNumeroTel() {
    return numeroTel;
  }

  public void setNumeroTel(String numeroTel) {
    this.numeroTel = numeroTel;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getCin() {
    return cin;
  }

  public void setCin(String cin) {
    this.cin = cin;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public Date getDateinscription() {
    return dateinscription;
  }

  public void setDateinscription(Date dateinscription) {
    this.dateinscription = dateinscription;
  }

  public Person() {
  }

  public Person(Long id, String email, String password, String username, String nom, String prenom, String adress, String numeroTel, String cv, String photo, String cin,Date dateinscription, List<Reclamation> recalamtions, List<AppRole> roles, String confirmPassword) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.username = username;
    this.nom = nom;
    this.prenom = prenom;
    this.adress = adress;
    this.numeroTel = numeroTel;
    this.cv = cv;
    this.photo = photo;
    this.cin = cin;
    this.dateinscription=dateinscription;
    this.confirmPassword = confirmPassword;
    this.recalamtions = recalamtions;
    this.roles = roles;
  }
}
