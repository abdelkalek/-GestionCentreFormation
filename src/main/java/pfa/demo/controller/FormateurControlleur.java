package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IAvis;
import pfa.demo.dao.IFormateur;
import pfa.demo.model.Avis;
import pfa.demo.model.Formateur;
import pfa.demo.service.AccountService;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/formateur")

public class FormateurControlleur {
    @Autowired
    private AccountService accountService;
    @Autowired
    private IAvis iAvis;
    @Autowired
    private IFormateur iformateur;

    @GetMapping("/all")
    private List<Formateur> formateurList() {
        return this.iformateur.findAll();
    }

    @PostMapping("/save")
    private Formateur ajouterformateur(@RequestBody Formateur formateur) {
        return this.accountService.saveformateur(formateur);
    }

    @PutMapping("/modif/{id}")
    private Formateur modiferformateur(@RequestBody Formateur formateur, @PathVariable Long id) {
        Formateur formateur1 = iformateur.getOne(id);
        formateur.setId(id);
        if (formateur.getNom() == "") {
            formateur.setNom(formateur1.getNom());
        }
        if (formateur.getPhoto() == "") {
            formateur.setPhoto(formateur1.getPhoto());
        }
        if (formateur.getPrenom() == "") {
            formateur.setPrenom(formateur1.getPrenom());
        }

        if (formateur.getCin() == "") {
            formateur.setCin(formateur1.getCin());
        }
        if (formateur.getAdress() == "") {
            formateur.setAdress(formateur1.getAdress());
        }

        if (formateur.getEmail() == "") {
            formateur.setEmail(formateur1.getEmail());
        }
        if (formateur.getSalair() == "") {
            formateur.setSalair(formateur1.getSalair());
        }
        if (formateur.getNumeroTel() == "") {
            formateur.setNumeroTel(formateur1.getNumeroTel());
        }
        if (formateur.getDateinscription()== null) {
            formateur.setDateinscription(formateur1.getDateinscription());
        }


        if(formateur.getUsername() == ""){
            formateur.setUsername(formateur1.getUsername());
        }
        if(formateur.getPassword() == ""){
            formateur.setPassword(formateur1.getPassword());
        }


        if (formateur.getSpecailite() == "") {
            formateur.setSpecailite(formateur1.getSpecailite());
        }
//        if (formateur.getSalaire() == 0) {
//            formateur.setSalaire(formateur1.getSalaire());
//        }
        if (formateur.getCv() == "") {
            formateur.setCv(formateur1.getCv());
        }

        formateur.setRoles(formateur1.getRoles());

        return iformateur.saveAndFlush(formateur);
    }

    @GetMapping("/listetavis/{id}")
    public Formateur avisformateur(@PathVariable Long id) {
        Formateur formateur;
        List<Avis> avisList = iAvis.findAvisByFormateur(id);
        int nb = avisList.size();
        int somme = 0;
        int notes = 0;

        for (Avis avis : iAvis.findAvisByFormateur(id)) {
            somme = somme + avis.getRaiting();

        }
        notes = somme / nb;
        formateur = iformateur.getOne(id);
        formateur.setNote(notes);
        return this.iformateur.save(formateur);
    }

    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deleteformateur(@PathVariable Long id) {
        HashMap hashMap = new HashMap();
        try {
            iformateur.deleteById(id);
            hashMap.put("etat", "formateur supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "formateur non supprimer");
            return hashMap;
        }
    }

    @GetMapping("/getbyid/{id}")
    private Formateur getone(@PathVariable Long id) {
        return iformateur.getOne(id);
    }
}
