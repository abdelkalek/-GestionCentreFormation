package pfa.demo.model;

import javax.persistence.Entity;
import java.util.Collection;

import java.util.Date;
import java.util.List;

@Entity
public class Admin extends Person {

  public Admin(Long id, String email, String password, String username, String nom, String prenom, String adress, String numeroTel, String cv, String photo, String cin, Date dateinscription, List<Reclamation> recalamtions, List<AppRole> roles, String confirmPassword) {
    super(id, email, password, username, nom, prenom, adress, numeroTel, cv, photo, cin, dateinscription, recalamtions, roles,confirmPassword);
  }

  public Admin() {
  }
}
