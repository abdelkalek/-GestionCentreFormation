package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IAvis;
import pfa.demo.dao.ICandidat;
import pfa.demo.dao.IFormateur;
import pfa.demo.dao.IFormation;
import pfa.demo.model.Avis;
import pfa.demo.model.Candidat;
import pfa.demo.model.Formateur;
import pfa.demo.model.Formation;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Avis")
public class AvisControlleur {
    @Autowired
    IAvis iAvis;


    @Autowired
    private IFormateur iFormateur;
    @Autowired
    private ICandidat iCandidat;
    @Autowired
    private IFormation iFormation;
    @GetMapping("/all")
    private List<Avis> listAvis() {
        return this.iAvis.findAll();
    }

    @PostMapping("/addavisFormateur/{idcondidat}/{id}")
    private Avis saveAvisformateur(@RequestBody Avis avis, @PathVariable Long idcondidat, @PathVariable Long id) {



        if (iFormateur.getOne(id) != null) {
            Formateur formateur = iFormateur.getOne(id);
            avis.setFormateurAvis(formateur);
            if (formateur.getNote() == 0) {
                formateur.setNote(avis.getRaiting());
            }
        }

        Candidat candidat = iCandidat.getOne(idcondidat);

        avis.setCandidat(candidat);

        return this.iAvis.save(avis);
    }
    @PostMapping("/addavisFormation/{idcondidat}/{id}")
    private Avis saveAvisformation(@RequestBody Avis avis, @PathVariable Long idcondidat, @PathVariable Long id) {



        if (iFormation.getOne(id) != null) {
            Formation formation = iFormation.getOne(id);
            avis.setFormation(formation);
            if (formation.getNote() == 0) {
                formation.setNote(avis.getRaiting());
            }
        }

        Candidat candidat = iCandidat.getOne(idcondidat);

        avis.setCandidat(candidat);

        return this.iAvis.save(avis);
    }
   /* @PostMapping("/addavisFormation/{idf}")
    public Avis addavis(@PathVariable Long idf, @RequestBody Avis avis) {

        Formateur formateur = iFormateur.getOne(idf);

        formateur.setId(idf);
        avis.setFormateurAvis(formateur);

        if (formateur.getNote() == 0) {
            formateur.setNote(avis.getRaiting());
        }
        iFormateur.save(formateur);

        return this.iAvis.save(avis);
    }*/

    @PutMapping("/modifAvisFormateur/{id}/{idC}/{idf}")
    public Avis editavisFormateur(@RequestBody Avis avis, @PathVariable Long id, @PathVariable Long idC, @PathVariable Long idf) {

        avis.setId(id);
        avis.setFormateurAvis(iFormateur.getOne(idf));
        avis.setCandidat(iCandidat.getOne(idC));

        return iAvis.save(avis);
       /* avis.setId(id);
        if (iFormateur.getOne(id) != null) {
            Formateur formateur = iFormateur.getOne(id);
            avis.setFormateurAvis(formateur);

        }


        avis.setCondidat(iCondidat.getOne(idC));

        return this.iAvis.save(avis);*/

    }



    @PutMapping("/modifAvisFormaton/{id}/{idC}/{idf}")
    public Avis editavisFormation(@RequestBody Avis avis, @PathVariable Long id, @PathVariable Long idC, @PathVariable Long idf) {

        avis.setId(id);
        avis.setFormation(iFormation.getOne(idf));
        avis.setCandidat(iCandidat.getOne(idC));

        return iAvis.save(avis);

      /*  avis.setId(id);
        if (iFormation.getOne(id) != null) {
            Formation formation = iFormation.getOne(id);
            avis.setFormation(formation);

        }


        avis.setCondidat(iCondidat.getOne(idC));

        return this.iAvis.save(avis);*/

    }
    @DeleteMapping("/delete/{idavis}")
    private HashMap<String, String> deleteAvs(@PathVariable Long idavis) {
        HashMap hashMap = new HashMap();
        try {
            iAvis.deleteById(idavis);
            hashMap.put("etat", "avis supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "avis non supprimer");
            return hashMap;
        }
    }
    @GetMapping("/aviscondidat/{idC}")
    public List<Avis> getAviscondidat (@PathVariable Long idC){
        return iAvis.findAvisByFormateur(idC);
    }
}

