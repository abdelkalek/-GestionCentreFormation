package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Candidat extends Person {
    private String niveaux;
    private String travail;
    private String presence ;

      public Candidat(Long id, String email, String password, String username, String nom, String prenom, String adress, String numeroTel, String cv, String photo, String cin, Date dateinscription, List<Reclamation> recalamtions, List<AppRole> roles, String confirmPassword, String niveaux, String travail, String presence) {
    super(id, email, password, username, nom, prenom, adress, numeroTel, cv, photo, cin, dateinscription, recalamtions, roles, confirmPassword);
    this.niveaux = niveaux;
    this.travail = travail;
    this.presence = presence;
  }

  @OneToMany(mappedBy = "candidat")
    private List<PaiementCandidat> paiementCandidats;


    @OneToMany(mappedBy = "candidat")

    private List<Commentaire> commentaireList;


    @OneToMany(mappedBy = "candidat")
    @JsonIgnore
    private List<Avis> avisList;

    @JsonIgnore
    @ManyToOne
    private FichePresence fichePresence;
    @JsonIgnore

    @ManyToMany(mappedBy = "candidatList")
    private List<Formation> formationList;

  public String getPresence() {
    return presence;
  }

  public void setPresence(String presence) {
    this.presence = presence;
  }

  public String getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(String niveaux) {
        this.niveaux = niveaux;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }


    public List<PaiementCandidat> getPaiementCandidats() {
        return paiementCandidats;
    }

    public void setPaiementCandidats(List<PaiementCandidat> paiementCandidats) {
        this.paiementCandidats = paiementCandidats;
    }

    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    public List<Avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }

    public FichePresence getFichePresence() {
        return fichePresence;
    }

    public void setFichePresence(FichePresence fichePresence) {
        this.fichePresence = fichePresence;
    }

    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }


  public Candidat() {
    }
}
