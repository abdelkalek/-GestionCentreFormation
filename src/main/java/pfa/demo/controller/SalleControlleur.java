package pfa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ISalle;
import pfa.demo.model.Candidat;
import pfa.demo.model.Salle;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/salle")
public class SalleControlleur {
    @Autowired
    private ISalle iSalle;


    @GetMapping("/all")
    private List<Salle> sessionList() {
        return this.iSalle.findAll();
    }

    @PostMapping("/save")
    private Salle ajoutSalle(@RequestBody Salle salle){
        return this.iSalle.save(salle);
    }
    @PutMapping("/modif/{id}")
    private Salle modifiersalle(@RequestBody Salle salle, @PathVariable Long id){
        Salle salle1=iSalle.getOne(id);
        if(salle.getNom_salle()== ""){
            salle.setNom_salle(salle1.getNom_salle());
        }
        if(salle.getAdress_salle()== ""){
            salle.setAdress_salle(salle1.getAdress_salle());
        }
        if(salle.getCapcite_salle()== ""){
            salle.setAdress_salle(salle1.getCapcite_salle());
        }

        salle.setId(id);
        return iSalle.saveAndFlush(salle);
    }





    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deletesalle(@PathVariable Long id) {
        HashMap hashMap = new HashMap();
        try {
            iSalle.deleteById(id);
            hashMap.put("etat", "session supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "session non supprimer");
            return hashMap;
        }
    }
}
