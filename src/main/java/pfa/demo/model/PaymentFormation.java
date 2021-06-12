package pfa.demo.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PaymentFormation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String tranchePayee;
    private String trancheRestant ;
    @ManyToOne
    private Candidat candidat;
    @ManyToOne
    private Session sessionP;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Session getSession() {
        return sessionP;
    }

    public void setSession(Session sessionP) {
        this.sessionP = sessionP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTranchePayee() {
        return tranchePayee;
    }

    public void setTranchePayee(String tranchePayee) {
        this.tranchePayee = tranchePayee;
    }

    public String getTrancheRestant() {
        return trancheRestant;
    }

    public void setTrancheRestant(String trancheRestant) {
        this.trancheRestant = trancheRestant;
    }

    public PaymentFormation() {
    }
}

