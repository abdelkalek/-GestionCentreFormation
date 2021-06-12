package pfa.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfa.demo.model.Mail;
import pfa.demo.service.MailService;

@CrossOrigin("*")
@RestController
public class MailRestController {
  @Autowired
  private MailService emailService;
  @RequestMapping(value="/sendMail",method= RequestMethod.POST)
  public String sendMail(){
    System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

    Mail mail = new Mail();
    mail.setFrom("fedouaboughamoura@gmail.com");
    mail.setTo("fedouaboughamoura@gmail.com");
    mail.setSubject("Sending Simple Email with JavaMailSender Example");
    mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

    emailService.sendSimpleMessage(mail);
    return "ok";
  }
}
