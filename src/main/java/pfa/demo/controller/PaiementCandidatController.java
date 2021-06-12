package pfa.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ICandidat;
import pfa.demo.dao.IPaiementCandidat;
import pfa.demo.dao.ISession;
import pfa.demo.model.Candidat;
import pfa.demo.model.PaiementCandidat;
import pfa.demo.model.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/paiementcandidat")
public class PaiementCandidatController {
  @Autowired
  private ICandidat icandidat;
  @Autowired
  private ISession isession;
  @Autowired
  private IPaiementCandidat ipaiementcandidat;


  @GetMapping("/all")
  private List<PaiementCandidat> paiementCandidatList() {
    return this.ipaiementcandidat.findAll();
  }

  @PostMapping("/save/{idsession}/{idcandidat}")
  private PaiementCandidat ajoutpaiement(@RequestBody PaiementCandidat paiementCandidat, @PathVariable Long idsession, @PathVariable Long idcandidat) {
    Session session = isession.getOne(idsession);
   Candidat candidat = icandidat.getOne(idcandidat);
    paiementCandidat.setSession(session);
    paiementCandidat.setCandidat(candidat);
    return this.ipaiementcandidat.save(paiementCandidat);
  }

  @PutMapping("/modif/{id}/{idsession}")
  private PaiementCandidat modiferpaiement(@RequestBody PaiementCandidat paiementCandidat, @PathVariable Long id, @PathVariable Long idsession) {
    Session session = isession.getOne(idsession);
    paiementCandidat.setSession(session);
    PaiementCandidat paiementCandidat1 = ipaiementcandidat.getOne(id);
    if (paiementCandidat.getTranchepayee() == null) {
      paiementCandidat.setTranchepayee(paiementCandidat1.getTranchepayee());
    }
    if (paiementCandidat.getTrancherestant() == null) {
      paiementCandidat.setTrancherestant(paiementCandidat1.getTrancherestant());
    }
    if (paiementCandidat.getDatepaiement() == null) {
      paiementCandidat.setDatepaiement(paiementCandidat1.getDatepaiement());
    }
    if (paiementCandidat.getTypepaiement() == null) {
      paiementCandidat.setTypepaiement(paiementCandidat1.getTypepaiement());
    }


    paiementCandidat.setId(id);
    return ipaiementcandidat.saveAndFlush(paiementCandidat);
  }

  @GetMapping("/getpaiementbysession/{idsession}")
  private List<PaiementCandidat> getpaiementbysession(@PathVariable Long idsession) {
    List<PaiementCandidat> paiementCandidats = new ArrayList<>();
    for (PaiementCandidat paiementCandidat : ipaiementcandidat.findAll()) {
      if (paiementCandidat.getSession().getId().equals(idsession)) {
        paiementCandidats.add(paiementCandidat);
      }
    }
    return paiementCandidats;
  }

  @GetMapping("/getpaiementbycandidat/{idcandidat}")
  private List<PaiementCandidat> getpaiementbycandidat(@PathVariable Long idcandidat) {
    List<PaiementCandidat> paiementCandidats = new ArrayList<>();
    for (PaiementCandidat paiementCandidat : ipaiementcandidat.findAll()) {
      if (paiementCandidat.getSession().getId().equals(idcandidat)) {
        paiementCandidats.add(paiementCandidat);
      }
    }
    return paiementCandidats;
  }

  @DeleteMapping("/delete/{id}")
  private HashMap<String, String> deletepaiement(@PathVariable Long id) {
    HashMap hashMap = new HashMap();
    try {
      ipaiementcandidat.deleteById(id);
      hashMap.put("etat", "paiement supprimer");
      return hashMap;
    } catch (Exception e) {
      hashMap.put("etat", "paiement non supprimer");
      return hashMap;
    }


  }
}
