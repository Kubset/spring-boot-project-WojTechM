package com.codecool.controller;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;

@Controller
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmailWithoutTemplating(String title, String body) {
        try {
        final it.ozimov.springboot.mail.model.Email email = DefaultEmail.builder()
                .from(new InternetAddress("kopanie.rest12@gmail.com", "warning"))
                .to(Lists.newArrayList(new InternetAddress("kopanie.rest12@gmail.com", "warning")))
                .subject(title)
                .body(body)
                .encoding("UTF-8").build();

            emailService.send(email);
        } catch(Exception e) {
            System.err.println("can't send an email" + e );
        }

    }
}
