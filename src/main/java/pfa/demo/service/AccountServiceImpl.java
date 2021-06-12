package pfa.demo.service;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfa.demo.dao.*;
import pfa.demo.model.*;

;import java.util.Date;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
  private Iperson iperson;
  private ICandidat icandidat;
  private IFormateur iformateur;
  private IAdmin iadmin;
  private AppRoleRepository appRoleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public AccountServiceImpl(Iperson ipersonne, ICandidat icandidat, IFormateur iformateur, IAdmin iadmin, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.iperson = ipersonne;
    this.icandidat = icandidat;
    this.iformateur = iformateur;
    this.iadmin = iadmin;
    this.appRoleRepository = appRoleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }


  @Override
  public Candidat savecandidat(Candidat candidat) {
    Person user = iperson.findByUsername(candidat.getUsername());
    if (user != null) throw new RuntimeException("User already exists");
    // if(!admin.getPassword().equals(admin.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");
    Candidat appUser = new Candidat();
    appUser.setUsername(candidat.getUsername());
    appUser.setPassword(bCryptPasswordEncoder.encode(candidat.getPassword()));
    appUser.setNiveaux(candidat.getNiveaux());
    appUser.setPhoto(candidat.getPhoto());
    appUser.setAdress(candidat.getAdress());
    appUser.setEmail(candidat.getEmail());
    appUser.setCin(candidat.getCin());
    appUser.setDateinscription(new Date());
    appUser.setCv(candidat.getCv());
    appUser.setNumeroTel(candidat.getNumeroTel());
    appUser.setPhoto(candidat.getPhoto());
    appUser.setConfirmPassword(candidat.getConfirmPassword());
    appUser.setNom(candidat.getNom());
    appUser.setPrenom(candidat.getPrenom());
    iperson.save(appUser);
    addRoleToUser(candidat.getUsername(), "candidat");
    return appUser;
  }

  @Override
  public Formateur saveformateur(Formateur formateur) {
    Person user = iperson.findByUsername(formateur.getUsername());
    if (user != null) throw new RuntimeException("user already exists");
    Formateur appUser = new Formateur();
    appUser.setUsername(formateur.getUsername());
    appUser.setPassword(bCryptPasswordEncoder.encode(formateur.getPassword()));
    appUser.setSalair(formateur.getSalair());
    appUser.setSpecailite(formateur.getSpecailite());
    appUser.setPhoto(formateur.getPhoto());
    appUser.setAdress(formateur.getAdress());
    appUser.setEmail(formateur.getEmail());
    appUser.setCin(formateur.getCin());
    appUser.setCv(formateur.getCv());
    appUser.setDateinscription(new Date());
    appUser.setNumeroTel(formateur.getNumeroTel());

    appUser.setConfirmPassword(formateur.getConfirmPassword());
    appUser.setPrenom(formateur.getPrenom());
    appUser.setNom(formateur.getNom());
    iperson.save(appUser);
    addRoleToUser(formateur.getUsername(), "formateur");
    return appUser;

  }

  @Override
  public Admin saveadmin(Admin admin) {
    Person user = iperson.findByUsername(admin.getUsername());
    if (user != null) throw new RuntimeException("user already exists");
    Admin appUser = new Admin();
    appUser.setUsername(admin.getUsername());
    appUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
    appUser.setAdress(admin.getAdress());
    appUser.setEmail(admin.getEmail());
    appUser.setCin(admin.getCin());
    appUser.setCv(admin.getCv());
    appUser.setDateinscription(new Date());
    appUser.setNumeroTel(admin.getNumeroTel());
    appUser.setPhoto(admin.getPhoto());
    appUser.setConfirmPassword(admin.getConfirmPassword());
    appUser.setPrenom(admin.getPrenom());
    appUser.setNom(admin.getNom());
    iperson.save(appUser);
    addRoleToUser(admin.getUsername(), "admin");
    return appUser;

  }


  @Override
  public AppRole save(AppRole role) {
    return appRoleRepository.save(role);
  }

  @Override
  public Person loadUserByUsername(String username) {
    return iperson.findByUsername(username);
  }

  @Override
  public void addRoleToUser(String username, String rolename) {
    Person appUser = iperson.findByUsername(username);
    AppRole appRole = appRoleRepository.findByRoleName(rolename);
    appUser.getRoles().add(appRole);
  }
}
