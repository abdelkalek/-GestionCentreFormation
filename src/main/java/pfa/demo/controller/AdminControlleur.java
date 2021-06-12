package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IAdmin;
import pfa.demo.dao.Iperson;
import pfa.demo.model.Admin;
import pfa.demo.model.Person;
import pfa.demo.service.AccountService;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminControlleur {
    @Autowired
    private AccountService accountService;
  @Autowired
  private Iperson iperson ;

  @Autowired
    private IAdmin iadmin;
    //Affichage
    @GetMapping("/all")
    private List<Admin> adminList(){
        return this.iadmin.findAll();
    }

    //Ajouter
    @PostMapping("/save")
    private Admin ajouteradmin(@RequestBody Admin admin)
    {
        return this.accountService.saveadmin(admin);
    }
    //Modifier
    @PutMapping("/modif/{id}")
    private Admin modifieradmin (@RequestBody Admin admin , @PathVariable Long id ){
        Admin admin1=iadmin.getOne(id);
        if(admin.getNom()==null){
            admin.setNom(admin1.getNom());
        }
        if(admin.getPrenom()==null){
            admin.setPrenom(admin1.getPrenom());
        }

        if(admin.getCin()==null){
            admin.setCin(admin1.getCin());
        }
        if(admin.getAdress()==null){
            admin.setAdress(admin1.getAdress());
        }

        if(admin.getEmail()==null){
            admin.setEmail(admin1.getEmail());
        }

        if(admin.getUsername()==null){
            admin.setUsername(admin1.getUsername());
        }
        if(admin.getPassword()==null){
            admin.setPassword(admin1.getPassword());
        }

        admin.setId(id);
        return iadmin.saveAndFlush(admin);
    }
    @GetMapping("/getprofile")
    public Person getUser(Principal principal){
        Person appUser = iperson.findByUsername(principal.getName());
        return appUser ;
    }
    @GetMapping("/byId")
    public Person findUserByIdUser(Long idUser) {

        return iperson.getOne(idUser);
    }
}






