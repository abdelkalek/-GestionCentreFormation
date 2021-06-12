package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IFichePrecence;
import pfa.demo.dao.IFormation;
import pfa.demo.model.FichePresence;
import pfa.demo.model.Formation;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/fichedepresence")
public class FicheControlleur {


        @Autowired
        private IFichePrecence iFichePrecence;
        @Autowired
        private IFormation iformation;

        @GetMapping("/all")
        private List<FichePresence> fichedepresenceList() {
            return this.iFichePrecence.findAll();
        }

        @PostMapping("/save/{idformation}")
        private FichePresence ajoutfiche(@RequestBody FichePresence fichedepresence, @PathVariable Long idformation) {
            Formation formation=iformation.getOne(idformation);
            fichedepresence.setFormation(formation);
//            fichedepresence.setCandidatList(formation.getCandidatList());
            return this.iFichePrecence.save(fichedepresence);
        }

        @PutMapping("/modif/{id}/{idformation}")
        private FichePresence modifierfiche(@RequestBody FichePresence fichedepresence, @PathVariable Long id, @PathVariable Long idformation) {
            Formation formation = iformation.getOne(idformation);
            fichedepresence.setFormation(formation);
            FichePresence fichedepresence1 = iFichePrecence.getOne(id);
            if (fichedepresence.getDate() == null) {
                fichedepresence.setDate(fichedepresence1.getDate());
            }
            if (fichedepresence.getTotalpresence() == null) {
                fichedepresence.setTotalpresence(fichedepresence1.getTotalpresence());
            }
            fichedepresence.setId(id);
            return iFichePrecence.saveAndFlush(fichedepresence);
        }


        @GetMapping("/getfichebyformation/{idformation}")
        private FichePresence getfichebyformation(@PathVariable Long idformation){
            FichePresence fichedepresenc=new FichePresence();
            for(FichePresence fichedepresence1:iFichePrecence.findAll()){
                if(fichedepresence1.getFormation().getId().equals(idformation)){
                    fichedepresenc=fichedepresence1;
                }
            }
            return fichedepresenc;


        }

        @DeleteMapping("/delete/{id}")
        private HashMap<String, String> deletefiche(@PathVariable Long id) {
            HashMap hashMap = new HashMap();
            try {
                iFichePrecence.deleteById(id);
                hashMap.put("etat", "fiche supprimer");
                return hashMap;
            } catch (Exception e) {
                hashMap.put("etat", "fiche non supprimer");
                return hashMap;
            }
        }
    }

