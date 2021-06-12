package pfa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Avis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int raiting;


    @ManyToOne
    private Candidat candidat;
    @ManyToOne
    @JsonIgnore
    private Formateur formateurAvis;
    @ManyToOne
    private Formation formation;

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Avis() {
    }

    public Avis(Long id, int raiting) {
        this.id = id;

        this.raiting = raiting;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Formateur getFormateurAvis() {
        return formateurAvis;
    }

    public void setFormateurAvis(Formateur formateurAvis) {
        this.formateurAvis = formateurAvis;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}


