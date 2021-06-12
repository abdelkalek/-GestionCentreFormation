package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ISupportFor;
import pfa.demo.model.SupportFor;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/support")
public class SupportForControlleur {
    @Autowired
    private ISupportFor iSupportFor;


    @GetMapping("/all")
    private List<SupportFor> supportForList() {
        return this.iSupportFor.findAll();
    }
    @PostMapping("/save")
    private SupportFor ajoutSupport(@RequestBody SupportFor supportFor){
        return this.iSupportFor.save(supportFor);
    }
    @PutMapping("/modif/{id}")
    private SupportFor modifierSipport(@RequestBody SupportFor supportFor, @PathVariable Long id){
        supportFor.setId(id);
        return iSupportFor.saveAndFlush(supportFor);
    }

    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deleteFormation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iSupportFor.deleteById(id);
            hashMap.put("etat","supportsupprime supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","support non supprimer");
            return hashMap;
        }
    }



}
