package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ICategorieFormation;
import pfa.demo.model.Candidat;
import pfa.demo.model.CategorieFormation;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Categorie")
public class CategorieFormatioControlleur {
    @Autowired
    private ICategorieFormation iCategorieFormationCategorie;
    @GetMapping("/all")
    private List<CategorieFormation> listformation(){
        return this.iCategorieFormationCategorie.findAll();
    }
    @PostMapping("/save")
    private CategorieFormation ajoutformation(@RequestBody CategorieFormation Categorie){
        return this.iCategorieFormationCategorie.save(Categorie);
    }
    @PutMapping("/modif/{id}")
    private CategorieFormation modifierFormation(@RequestBody CategorieFormation Categorie, @PathVariable Long id){
        CategorieFormation categorie1=iCategorieFormationCategorie.getOne(id);
        if(Categorie.getNom_categorie()==null){
            Categorie.setNom_categorie(categorie1.getNom_categorie());
        }
        Categorie.setId_categorie(id);
        return iCategorieFormationCategorie.saveAndFlush(Categorie);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deleteformation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iCategorieFormationCategorie.deleteById(id);
            hashMap.put("etat","formation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","formation non supprimer");
            return hashMap;
        }
    }
}

