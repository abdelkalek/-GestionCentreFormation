package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IFormateur;
import pfa.demo.dao.IPayementFormateur;
import pfa.demo.model.Formateur;
import pfa.demo.model.PayementFormateur;
import pfa.demo.model.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

@CrossOrigin("*")
@RestController
@RequestMapping("/paymentFormateur")
public class PayementFormateurControlleur {
  @Autowired
  private IPayementFormateur iPayementFormateur;
  @Autowired
  private IFormateur iFormateur;

  @GetMapping("/all")
  private List<PayementFormateur> listpayement() {
    return this.iPayementFormateur.findAll();
  }

  @PostMapping("/save/{idformateur}")
  private PayementFormateur ajoutpaymentFormateur(@RequestBody PayementFormateur payementFormateur, @PathVariable Long idformateur) {
    Formateur formateur = iFormateur.getOne(idformateur);
    payementFormateur.setFormateurp(formateur);
    int Avance = parseInt(payementFormateur.getAvance());
    int salaire = parseInt(payementFormateur.getSalaire());
    int rest = salaire - Avance;
    payementFormateur.setTrancheRestant(String.valueOf(rest));
    return this.iPayementFormateur.save(payementFormateur);

  }

  @PutMapping("/modif/{id}")
  private PayementFormateur modifierpaymentFormateur(@RequestBody PayementFormateur paymentFormateur, @PathVariable Long id) {
    paymentFormateur.setId(id);
    return iPayementFormateur.saveAndFlush(paymentFormateur);
  }

  @DeleteMapping("/delete/{id}")
  private HashMap<String, String> deletepaymentFormateur(@PathVariable Long id) {
    HashMap hashMap = new HashMap();
    try {
      iPayementFormateur.deleteById(id);
      hashMap.put("etat", "paymentFormateur supprimer");
      return hashMap;
    } catch (Exception e) {
      hashMap.put("etat", "paymentFormateur non supprimer");
      return hashMap;
    }
  }
  @PutMapping("/modif/{id}/{montant}")
  private PayementFormateur terminerpayment(@PathVariable Long id, @PathVariable String montant)
  {
    PayementFormateur payementFormateur = iPayementFormateur.getOne(id);
    int M = parseInt(montant);
    int A = parseInt(payementFormateur.getAvance());
    int T = parseInt(payementFormateur.getSalaire());

    if ((M + A) == T) {
      payementFormateur.setEtat(true);
      payementFormateur.setTrancheRestant("0");
    } else {
      payementFormateur.setEtat(false);
      payementFormateur.setAvance(String.valueOf(M+A));
      payementFormateur.setTrancheRestant(String.valueOf(T - (A + M)));
    }

    return iPayementFormateur.saveAndFlush(payementFormateur);

  }
  @GetMapping("/getpaiementbyid/{id}")
  private PayementFormateur getone(@PathVariable Long id) {
    return iPayementFormateur.getOne(id);
  }

  @GetMapping("/getpaiement/{idformateur}")
  public List<PayementFormateur> getpaiementbyformateur(@PathVariable Long idformateur) {
    Formateur formateur = iFormateur.getOne(idformateur);
    List<PayementFormateur> payementFormateurs = new ArrayList<>();
    for (PayementFormateur payementFormateur : iPayementFormateur.findAll()) {
      if (payementFormateur.getFormateurp().getId().equals(idformateur)) {
        payementFormateurs.add(payementFormateur);
      }
    }
    return payementFormateurs;
  }}
