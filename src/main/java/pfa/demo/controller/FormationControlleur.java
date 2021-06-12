package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ICategorieFormation;
import pfa.demo.dao.ICandidat;
import pfa.demo.dao.IFormateur;
import pfa.demo.dao.IFormation;
import pfa.demo.model.CategorieFormation;
import pfa.demo.model.Candidat;
import pfa.demo.model.Formateur;
import pfa.demo.model.Formation;
import pfa.demo.storage.StorageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/formation")
    public class FormationControlleur {
    @Autowired
    private StorageService storageService;
    @Autowired
    private IFormation iFormation;
    @Autowired
    private ICategorieFormation iCategorieFormation;
    @Autowired
    private IFormateur iFormateur;
    @Autowired
    private ICandidat iCandidat;

    @GetMapping("/all")
    private List<Formation> listFormation(){
        return this.iFormation.findAll();
    }

    @PostMapping("/save/{idcategorie}/{idformateur}")
    private Formation ajoutFormation(@RequestBody Formation formation, @PathVariable Long idcategorie, @PathVariable Long idformateur){
        CategorieFormation categorieFormation=iCategorieFormation.getOne(idcategorie);
        Formateur formateur=iFormateur.getOne(idformateur);
        formation.setFormateur(formateur);
        formation.setCategorieFormation(categorieFormation);
        return this.iFormation.save(formation);
    }
//@PostMapping("/save/{idcategorie}")
//private Formation ajoutFormation(String prix, MultipartFile file , @PathVariable Long idcategorie){
//    CategorieFormation categorieFormation=iCategorieFormation.getOne(idcategorie);
//    Formation formation=new Formation();
//    formation.setPrix(prix);
//    storageService.store(file);
//    formation.setSupportCours(file.getOriginalFilename());
//    formation.setCategorieFormation(categorieFormation);
//    return this.iFormation.save(formation);
//}
    @PutMapping("/modif/{id}/{idformateur}")
    private Formation modifierformation(@RequestBody Formation formation, @PathVariable Long id, @PathVariable Long idformateur){
        Formation formation0=iFormation.getOne(id);
        Formateur formateur=iFormateur.getOne(idformateur);
        formation.setFormateur(formateur);

        if(formation.getDescription()== ""){
            formation.setDescription(formation0.getDescription());

        }
        if(formation.getMotcle()==null){
            formation.setMotcle(formation0.getMotcle());

        }
        if(formation.getCharge()== ""){
            formation.setCharge(formation0.getCharge());

        } if(formation.getDateFin()==null){
            formation.setDateFin(formation0.getDateFin());

        } if(formation.getHoraire()== ""){
            formation.setHoraire(formation0.getHoraire());

        } if(formation.getPrix()== ""){
            formation.setPrix(formation0.getPrix());

        }
        formation.setCategorieFormation(formation0.getCategorieFormation());
        formation.setId(id);
        return iFormation.saveAndFlush(formation);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deleteFormation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iFormation.deleteById(id);
            hashMap.put("etat","Formation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","Formation non supprimer");
            return hashMap;
        }
    }
    @GetMapping("/getformationbycategorie/{idcategorie}")
    private List<Formation> getbyidcategorie(@PathVariable Long idcategorie){
List<Formation> formationList=new ArrayList<>();
for( Formation formation:iFormation.findAll()){
    if(formation.getCategorieFormation().getId_categorie().equals(idcategorie)){
    formationList.add(formation);}

}
        return formationList;
}
    @GetMapping("/getformationbyformateur/{idformateur}")
    private List<Formation> getbyidformateur(@PathVariable Long idformateur){
        List<Formation> formationList=new ArrayList<>();
        for( Formation formation:iFormation.findAll()){
            if(formation.getFormateur().getId().equals(idformateur)){
                formationList.add(formation);}

        }
        return formationList;
    }
    @GetMapping("affecterauformation/{idformation}/{idcondiday}")
    private Formation affecter(@PathVariable Long idformation, @PathVariable Long idcondiday)
    {
        Formation formation =iFormation.getOne(idformation);
        Candidat candidat = iCandidat.getOne(idcondiday);
        List<Candidat> list=formation.getCandidatList();

        list.add(list.size(), candidat);
        formation.setCandidatList(list);
          return iFormation.save(formation);
    }
  @GetMapping("/getbyid/{id}")
  private Formation getone(@PathVariable Long id) {
    return iFormation.getOne(id);


  }
    //formation by id  formateur
    @GetMapping("/getformation/{idformateur}")
    public List<Formation> getFormationbyformateur(@PathVariable Long idformateur)
    {
        Formateur formateur = iFormateur.getOne(idformateur);
        List<Formation> formationList = new ArrayList<>();
        for (Formation formation : iFormation.findAll()) {
            if (formation.getFormateur().getId().equals(idformateur)) {
                formationList.add(formation);
            }
        }
        return formationList;
    }
    @GetMapping("/getformationbycandidat/{idcandidat}")
    public List<Formation> getformationbycandidat(@PathVariable Long idcandidat)
    {
        Formateur formateur = iFormateur.getOne(idcandidat);
        List<Formation> formationList = new ArrayList<>();
        for (Formation formation : iFormation.findAll()) {
            for (Candidat candidat :formation.getCandidatList()){
            if (candidat.getId().equals(idcandidat)) {
                formationList.add(formation);
            }}
        }
        return formationList;
    }
}
