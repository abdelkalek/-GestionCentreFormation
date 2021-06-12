package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IBesoinMateril;
import pfa.demo.dao.IMateril;
import pfa.demo.dao.ISession;
import pfa.demo.model.BesoinMateril;
import pfa.demo.model.Materil;
import pfa.demo.model.Session;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Besoin")
public class BesoinMaterilControlleur {
    @Autowired
    private IBesoinMateril iBesoinMateril;
    @Autowired
    private ISession iSession;
    @Autowired
    private IMateril iMateril;
    @PostMapping("/save/{idSession}/{idmateril}")
    private BesoinMateril ajouterbesoin(@RequestBody BesoinMateril besoinMateril, @PathVariable Long idSession, @PathVariable Long idmateril )
    {
        Session session =iSession.getOne(idSession);
        System.out.println(session);

        Materil materil =iMateril.getOne(idmateril);
        System.out.println(materil);
        besoinMateril.setSessiong(session);
        List<Materil> materilList1=besoinMateril.getMaterilList();
        materilList1.add(materil);
            besoinMateril.setMaterilList(materilList1);
        System.out.println(besoinMateril.getMaterilList());
        System.out.println(besoinMateril.toString());
        return this.iBesoinMateril.save(besoinMateril);}
    @PutMapping("/modif/{id}")
    private BesoinMateril modifierbesoin(@RequestBody BesoinMateril besoinMateril, @PathVariable Long id)
    {
        besoinMateril.setId(id);
        return iBesoinMateril.saveAndFlush(besoinMateril);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deletemateril(@PathVariable Long id) {
        HashMap hashMap = new HashMap();
        try {
            iBesoinMateril.deleteById(id);
            hashMap.put("etat", "Besoin supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "Besoin non supprimer");
            return hashMap;
        }
    }
}
