package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IPromotion;
import pfa.demo.dao.ISession;
import pfa.demo.model.Promotion;
import pfa.demo.model.Session;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promotion")
public class PromotionControlleur {
  @Autowired
  private IPromotion ipromotion;
  @Autowired
  private ISession iSession;
  @PostMapping("/add/{idsession}")
  public Promotion addpromo(@RequestBody Promotion promotion, @PathVariable Long idsession ){
    Session session= iSession.getOne(idsession);
    promotion.setSession(session);
    iSession.saveAndFlush(session);
    return ipromotion.saveAndFlush(promotion);
  }
  @GetMapping("/all")
  public List<Promotion> allpromo()
  {
    return ipromotion.findAll();
  }
  @DeleteMapping("/delete/{id}/{idsession}")
  public HashMap supprimer(@PathVariable Long id, @PathVariable Long idsession){
    HashMap<String, String> hashMap = new HashMap<>();
    try{
      Session session = iSession.getOne(idsession);

      session.setPrixprom(0);
      iSession.saveAndFlush(session);
      ipromotion.deleteById(id);
      hashMap.put("state","yes");
      return hashMap;
    }catch (Exception e){
      hashMap.put("state","no");
      return hashMap;
    }
  }
  @GetMapping("/getbyid/{id}")
  private Promotion getone(@PathVariable Long id) {
    return ipromotion.getOne(id);


  }


}

