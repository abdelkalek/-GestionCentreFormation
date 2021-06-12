package pfa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ICandidat;
import pfa.demo.model.Candidat;

import pfa.demo.service.AccountService;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/candidat")
public class CandidatControlleur {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ICandidat icandidat;

    @GetMapping("/all")
    private List<Candidat> candidatList(){
        return this.icandidat.findAll();
    }
    @PostMapping("/save")
    private Candidat ajoutercandidat(@RequestBody Candidat candidat){

        return this.accountService.savecandidat(candidat);
    }
    @PutMapping("/modif/{id}")
    private Candidat modifercandidat(@RequestBody Candidat candidat , @PathVariable Long id){
        Candidat candidat1=icandidat.getOne(id);
        candidat.setId(id);
        if(candidat.getNom() == ""){
            candidat.setNom(candidat1.getNom());
       }
       if(candidat.getPrenom() == ""){
          candidat.setPrenom(candidat1.getPrenom());
        }

       if(candidat.getCin() == ""){
           candidat.setCin(candidat1.getCin());
       }
       if(candidat.getAdress() == ""){
           candidat.setAdress(candidat1.getAdress());
       }
        if(candidat.getEmail() ==" "){
            candidat.setEmail(candidat1.getEmail());
       }


        if(candidat.getUsername() == ""){
            candidat.setUsername(candidat1.getUsername());
        }
        if(candidat.getPassword() == ""){
            candidat.setPassword(candidat1.getPassword());
        }

        if(candidat.getNiveaux() ==" "){
            candidat.setNiveaux(candidat1.getNiveaux());
      }
        if (candidat.getPhoto() == "") {
            candidat.setPhoto(candidat1.getPhoto());
        }

       candidat.setRoles(candidat1.getRoles());

        return this.icandidat.saveAndFlush(candidat);
    }
    @DeleteMapping("delete/{id}")
    private HashMap<String, String> deletecandidat(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try{
            icandidat.deleteById(id);
            hashMap.put("etat","candidat supprimer");
            return  hashMap;
        }
        catch (Exception e){
            hashMap.put("etat","candidat non supprimer");
            return hashMap;
        }
    }
    @GetMapping("/byId/{idUser}")
    public Candidat findUserByIdUser(@PathVariable Long idUser) {

        return icandidat.getOne(idUser);
    }
    @GetMapping("/getbyid/{id}")
    private Candidat getone(@PathVariable Long id) {
        return icandidat.getOne(id);
    }
}
