package pfa.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BesoinMateril implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)

  private Long id;
  private String materilFor;
  @OneToMany(mappedBy = "besoinMateril")
  private List<Materil> materilList = new ArrayList<>();
  @OneToOne
  private Session sessiong;

  public Session getSessiong() {
    return sessiong;
  }

  public void setSessiong(Session sessiong) {
    this.sessiong = sessiong;
  }

  public List<Materil> getMaterilList() {
    return materilList;
  }

  public void setMaterilList(List<Materil> materilList) {
    this.materilList = materilList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMaterilFor() {
    return materilFor;
  }

  public void setMaterilFor(String materilFor) {
    this.materilFor = materilFor;
  }

  public BesoinMateril() {
  }

  public BesoinMateril(Long id, String materilFor) {
    this.id = id;
    this.materilFor = materilFor;
  }
}
