package pfa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.IPayementFormation;
import pfa.demo.model.PaymentFormation;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/payment")
public class PaymentFormationControlleur {
    @Autowired
    private IPayementFormation iPaymentFormation;
    @GetMapping("/all")
    private List<PaymentFormation> listpayement(){
        return this.iPaymentFormation.findAll();
    }
    @PostMapping("/save")
    private PaymentFormation ajoutpaymentFormation(@RequestBody PaymentFormation  paymentFormation){
        return this.iPaymentFormation.save(paymentFormation);
    }
    @PutMapping("/modif/{id}")
    private PaymentFormation modifierpaymentFormation(@RequestBody PaymentFormation paymentFormation, @PathVariable Long id){
        paymentFormation.setId(id);
        return iPaymentFormation.saveAndFlush(paymentFormation);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deletepaymentFormation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iPaymentFormation.deleteById(id);
            hashMap.put("etat","paymentFormation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","paymentFormation non supprimer");
            return hashMap;
        }
    }
}
