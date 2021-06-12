package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ICommentaire;
import pfa.demo.dao.ICandidat;
import pfa.demo.dao.IFormation;
import pfa.demo.model.Commentaire;
import pfa.demo.model.Candidat;
import pfa.demo.model.Formation;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireControleur {
    @Autowired
    private ICommentaire iCommentaire;
    @Autowired
    private IFormation iFormation;
    @Autowired
    private ICandidat iCandidat;
    @GetMapping("/all")
    private List<Commentaire> listCommentaire(){
        return this.iCommentaire.findAll();
    }
    @PostMapping("/save/{idcondidat}/{idformation}")
    private Commentaire savecommentaire (@RequestBody Commentaire commentaire, @PathVariable Long idcondidat, @PathVariable Long idformation){
        Formation formation=iFormation.getOne(idformation);
        Candidat candidat = iCandidat.getOne(idcondidat);
       commentaire.setCandidat(candidat);
       commentaire.setFormation(formation);
        return this.iCommentaire.save(commentaire);
    }
    @PutMapping("/modif/{idcommentaire}")
    private Commentaire modifcommentaire (@RequestBody Commentaire commentaire, @PathVariable Long idcommentaire){
       commentaire.setId(idcommentaire);
        return this.iCommentaire.save(commentaire);
    }
    @DeleteMapping("/delete/{idcommentaire}")
    private HashMap<String, String> deletecommentaire(@PathVariable Long idcommentaire){
        HashMap hashMap=new HashMap();
        try {
            iCommentaire.deleteById(idcommentaire);
            hashMap.put("etat","commentaire supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","commentaire non supprimer");
            return hashMap;
        }
    }
}
