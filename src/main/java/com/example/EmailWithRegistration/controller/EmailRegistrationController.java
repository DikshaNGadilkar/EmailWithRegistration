package com.example.EmailWithRegistration.controller;

import com.example.EmailWithRegistration.Configuration.EmailService;
import com.example.EmailWithRegistration.domain.EmailRegistration;

import com.example.EmailWithRegistration.domain.Emails;
import com.example.EmailWithRegistration.repos.EmailRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api")
public class EmailRegistrationController {

    @Autowired
    private EmailRepos emailRepos;

    @Autowired
    private MongoTemplate mongoTemplate;

@Autowired
private EmailService emailService;


    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private Logger logger;

//    @Autowired
//    private Emails emails;



//    @RequestMapping(value = "/saveEmailInfo",method= RequestMethod.POST)
//    public ResponseEntity<?> saveEmailInfo(@RequestBody EmailRegistration emailRegistration) {
//        emailRepos.save(emailRegistration);
//        // return entity;below return stmt is standard format but that time itis necessory to write @RequestMpping and method=
//        return ResponseEntity.ok(emailRegistration);
//    }

    @RequestMapping(value = "/saveEmailInfo",method= RequestMethod.POST)
    public ResponseEntity<?> saveEmailInfo(@RequestBody(required = false) EmailRegistration emailRegistration) {
        emailRepos.save(emailRegistration);
        emailRegistration.getEmailId();
emailService.searchForFirstPageProject(emailRegistration.getEmailId());

    emailService.demo();
   // System.out.println(emailRegistration.getEmailId());
        return ResponseEntity.ok(emailRegistration);
    }

    @RequestMapping(value = "updateEmailInfo/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmailInfo(@RequestParam String id, @RequestBody EmailRegistration emailRegistration){
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findOne(query,EmailRegistration.class);
        emailRepos.save(emailRegistration);
        return ResponseEntity.ok(emailRegistration);

    }

    @RequestMapping(value="/deleteEmailInfo/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> deleteEmailInfo(@PathVariable String id){
        EmailRegistration emailRegistration=new EmailRegistration();
        mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)),EmailRegistration .class);

        return ResponseEntity.ok(emailRegistration);
    }



}
