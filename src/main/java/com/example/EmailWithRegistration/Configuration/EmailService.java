package com.example.EmailWithRegistration.Configuration;

import com.example.EmailWithRegistration.domain.EmailRegistration;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Map;

import java.util.logging.Logger;
@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;
//@Autowired
//private EmailRegistration emailRegistration;
    @Autowired
    private Logger logger;

    // @RequestMapping(value="/getEmailInfo",method = RequestMethod.POST)

//    public Callable<ResponseEntity<Map<String, Object>>> searchForFirstPageProject() {
//        return () -> {
//
//            EmailRegistration e=new EmailRegistration();
//             System.out.println("hello ");
//            simpleMailMessage.setTo(e.getEmailId());
//            simpleMailMessage.setText("hloooo");
//            simpleMailMessage.setSubject("sub");
//            mailSender.send(simpleMailMessage);
//            logger.info("message send successfully");
//            ResponseEntity<Map<String, Object>> resEntity;
//            resEntity = new ResponseEntity("succss", HttpStatus.OK);
//            return resEntity ;
//        };
//
//    }

    public ResponseEntity<Map<String,Object>> searchForFirstPageProject(String to) {


            EmailRegistration e=new EmailRegistration();
    //    String str=e.getEmailId();
            System.out.println(to);

            simpleMailMessage.setTo(to);
            //simpleMailMessage.setTo(str);
            simpleMailMessage.setText("hloooo");
            simpleMailMessage.setSubject("sub");
            mailSender.send(simpleMailMessage);
            logger.info("message send successfully");
            ResponseEntity<Map<String, Object>> resEntity;
            resEntity = new ResponseEntity("succss", HttpStatus.OK);
            return resEntity ;

    }

    public void demo(){
        System.out.println("demo");

    }
}
