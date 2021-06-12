package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IEmploi;
import pfa.demo.model.EmploiTemps;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/emploiT")
public class EmploiControlleur {
    @Autowired
    private IEmploi iEmploi;
    @GetMapping("/all")
    private List<EmploiTemps> listEmploi(){
        return this.iEmploi.findAll();
    }
    @PostMapping("/save")
    private EmploiTemps ajoutpaymentFormation(@RequestBody EmploiTemps  emploiTemps){
        return this.iEmploi.save(emploiTemps);
    }
    @PutMapping("/modif/{id}")
    private EmploiTemps modifierEmploi(@RequestBody EmploiTemps emploiTemps, @PathVariable Long id){
        emploiTemps.setId(id);
        return iEmploi.saveAndFlush(emploiTemps);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deletepaymentFormation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iEmploi.deleteById(id);
            hashMap.put("etat","paymentFormation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","paymentFormation non supprimer");
            return hashMap;
        }
    }
}
