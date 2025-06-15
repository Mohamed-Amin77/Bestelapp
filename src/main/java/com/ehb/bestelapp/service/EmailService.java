
package com.ehb.bestelapp.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private final String DOEL_EMAIL = "magazijn@aquafin.be";
    public void sendContactMail(String vanEmail, String categorie, String bericht) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(DOEL_EMAIL);
        helper.setSubject("Nieuw contactformulier (" + categorie + ")");
        helper.setText("Van: " + vanEmail + "\n\nBericht:\n" + bericht, false);

        mailSender.send(mimeMessage);
    }
}