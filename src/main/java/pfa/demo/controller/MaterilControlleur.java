package pfa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IMateril;
import pfa.demo.model.Materil;

import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/Materil")
public class MaterilControlleur {



    @Autowired
    private IMateril iMateril;
    @PostMapping("/save")
    private Materil ajoutermateril(@RequestBody Materil materiel)
    { return this.iMateril.save(materiel);}
    @PutMapping("/modif/{id}")
    private Materil modifiermateril(@RequestBody Materil materiel, @PathVariable Long id)
    {
        materiel.setId(id);
        return iMateril.saveAndFlush(materiel);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deletemateril(@PathVariable Long id) {
        HashMap hashMap = new HashMap();
        try {
            iMateril.deleteById(id);
            hashMap.put("etat", "session supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "session non supprimer");
            return hashMap;
        }
    }
}

