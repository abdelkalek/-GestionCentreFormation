package pfa.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pfa.demo.model.AppRole;
import pfa.demo.service.AccountService;
import pfa.demo.storage.StorageService;

import javax.annotation.Resource;
import java.util.Collections;


@SpringBootApplication

public class DemoApplication  implements CommandLineRunner {
    @Resource
    private StorageService storageService;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "9000"));
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
     // storageService.deleteAll();
     // storageService.init();
    }
    @Bean
    BCryptPasswordEncoder getBCPE (){

        return new BCryptPasswordEncoder();
    }
//    @Bean
//    CommandLineRunner start(AccountService accountService){
//        return args->{
//
//		accountService.save(new AppRole("formateur"));
//			accountService.save(new AppRole("admin"));
//          accountService.save(new AppRole("candidat"));
//            //ream.of("user1").forEach(un->{
//               //ccountService.saveUser(un,"1234","1234","","","","","",
//                     //","","","","","","");
//          };
         //ccountService.addRoleToUser("user1","ResponsableCentre");



       // };
  }


