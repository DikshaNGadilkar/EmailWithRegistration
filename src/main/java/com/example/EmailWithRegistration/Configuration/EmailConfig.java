package com.example.EmailWithRegistration.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    private Properties getProperty(){

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return props;
    }
    @Bean
    public MailSender mailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties properties = getProperty();

        mailSender.setJavaMailProperties(properties);
        mailSender.setUsername("dikshag2801@gmail.com");
        mailSender.setPassword("Luckfactor11**");


        return mailSender;
    }
    @Bean
    public SimpleMailMessage message() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dikshag2801@gmail.com");

        return message;
    }
}
