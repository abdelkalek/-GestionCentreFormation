package pfa.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.demo.dao.ICandidat;
import pfa.demo.dao.IFormateur;
import pfa.demo.dao.IReclamation;
import pfa.demo.model.*;
import pfa.demo.service.MailService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/reclamation")
public class ReclamationRestController {


    @Autowired
    private IReclamation iReclamation;

    @Autowired
    private IFormateur iFormateur;

    @Autowired
    private ICandidat iCandidat;

    @Autowired
    private MailService mailService;

    @GetMapping("/all")
    public List<Reclamation> getAll(){
        return (List<Reclamation>) iReclamation.findAll();
    }

    @PostMapping("/add/{idU}")
    public Reclamation addreclamation(@RequestBody Reclamation r, @PathVariable Long idU)
    {
        for(Formateur formateur:iFormateur.findAll()) {
            if (formateur.getId().equals(idU)) {
                r.setPerson(formateur);
            }
        }

        for(Candidat candidat : iCandidat.findAll()) {
            if (candidat.getId().equals(idU)) {
                r.setPerson(candidat);
            }
        }

        return this.iReclamation.save(r);
    }
    @PutMapping("/update/{id}/{idU}")

    public Reclamation updatereclamtion(@RequestBody Reclamation r, @PathVariable Long id, @PathVariable Long idU){
        r.setId(id);
        for(Formateur formateur:iFormateur.findAll()) {
            if (formateur.getId().equals(idU)) {
                r.setPerson(formateur);
            }
        }

        for(Candidat candidat : iCandidat.findAll()) {
            if (candidat.getId().equals(idU)) {
                r.setPerson(candidat);
            }
        }

        return iReclamation.save(r);}

    @GetMapping("/reponse/{id}")
    public Response reponse (@PathVariable Long id){
        Response rs= new Response();
        try {
            Reclamation reclamation;
            reclamation = iReclamation.getOne(id);

            iReclamation.save(reclamation);
            rs.setState("ok");
            return rs;
        }
        catch (Exception e){
            rs.setState("non");
            return rs;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable Long id){

        Response res = new Response();
        System.out.println("id=" +id);
        try {
            iReclamation.deleteById(id);
            res.setState("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setState("non");
        }
        return res ;
    }
    @GetMapping("/one/{id}")
    public Reclamation getOne(@PathVariable Long id){

        return iReclamation.getOne(id);
    }

    @PostMapping(value="/sendMail/{idreclamation}")
    public Response sendMail(@RequestBody Mail mail, @PathVariable Long idreclamation)


    {
        Response rs=new Response();


        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        mail.setFrom("krbsirine@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject("Reponse pour votre Reclamation");
        mail.setContent(mail.getContent());
        mailService.sendSimpleMessage(mail);



        rs.setState("email ok");
        return rs;

    }

}
