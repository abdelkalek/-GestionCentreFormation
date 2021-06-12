package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.*;
import pfa.demo.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/session")
public class SessionControlleur {
    @Autowired
    private ISession iSession;
    @Autowired
    private IFormation iFormation;
    @Autowired
    private IFormateur iFormateur;
    @Autowired
    private ICandidat iCandidat;
    @Autowired
    private IAvis iAvis;
    @Autowired
    private ISalle iSalle;

    @GetMapping("/all")
    private List<Session> sessionList() {
        return this.iSession.findAll();
    }

    @PostMapping("/save/{idFormation}/{idsalle}")
    private Session ajoutSession(@RequestBody Session session, @PathVariable Long idFormation, @PathVariable Long idsalle) {
        Formation formation = iFormation.getOne(idFormation);
        Salle salle = iSalle.getOne(idsalle);
        session.setSalle(salle);
        session.setSessionFormation(formation);
        return this.iSession.save(session);
    }


    @PutMapping("/modif/{id}/{idformateur}")
    private Session modifierSession(@RequestBody Session session, @PathVariable Long id, @PathVariable Long idsalle) {
        Session session1 = iSession.getOne(id);
        System.out.println(session1);
        Salle salle = iSalle.getOne(idsalle);
        session.setSalle(salle);
        if (session.getDatedebut() == null) {
            session.setDatedebut(session1.getDatedebut());

        }
        if (session.getChareg() == null) {
            session.setChareg(session1.getChareg());

        }
        if (session.getDatefin() == null) {
            session.setDatefin(session1.getDatefin());

        }
        if (session.getVille() == null) {
            session.setVille(session1.getVille());

        }


        session.setId(id);
        return iSession.saveAndFlush(session);
    }

    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deletesession(@PathVariable Long id) {
        HashMap hashMap = new HashMap();
        try {
            iSession.deleteById(id);
            hashMap.put("etat", "session supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "session non supprimer");
            return hashMap;
        }
    }

    @GetMapping("/getsessionbyformation/{idformation}")
    private List<Session> getbyidcategorie(@PathVariable Long idformation) {
        List<Session> sessionLit = new ArrayList<>();
        for (Session session : iSession.findAll()) {
            if (session.getSessionFormation().getId().equals(idformation)) {
                sessionLit.add(session);
            }

        }
        return sessionLit;
    }


    @GetMapping("affecterauSession/{idsession}/{idcondidat}")
    private Session affecter(@PathVariable Long idsession, @PathVariable Long idcondidat) {
        Session session = iSession.getOne(idsession);
        Candidat candidat = iCandidat.getOne(idcondidat);
        List<Candidat> list = session.getCandidatList();
        if (list.size() == 0) {
            list.add(0, candidat);
        }
        list.add(list.size() + 1, candidat);
        session.setCandidatList(list);
        return iSession.save(session);
    }

    @GetMapping("/getbyid/{id}")
    private Session getone(@PathVariable Long id) {
        return iSession.getOne(id);
    }


    @GetMapping("enprom")
    public List<Session> promooo() {
        List<Session> sessionList = new ArrayList<>();
        for (Session article : iSession.findAll()) {
            if (article.getPrixprom() != 0)
                sessionList.add(article);
        }
        return sessionList;
    }

    //session by id  formateur
    @GetMapping("/getSesion/{idformateur}")
    public List<Session> getsessionbyformateur(@PathVariable Long idformateur) {
        Formateur formateur = iFormateur.getOne(idformateur);
        List<Session> sessionList = new ArrayList<>();
        for (Session session : iSession.findAll()) {
            if (session.getFormateur().getId().equals(idformateur)) {
                sessionList.add(session);
            }
        }
        return sessionList;
    }

}
