package pfa.demo.service;


import pfa.demo.model.*;

public interface AccountService {
    Candidat savecandidat(Candidat candidat);
    Formateur saveformateur(Formateur formateur);
    Admin saveadmin(Admin admin);

    // Utilisateur saveAdmin(Admin admin);
    //Utilisateur saveCenter(CentreForma centreForma);
    // Utilisateur savesociete(Societe societe);

    AppRole save(AppRole role);
    Person loadUserByUsername(String username);
    void addRoleToUser(String username, String rolename);

}
