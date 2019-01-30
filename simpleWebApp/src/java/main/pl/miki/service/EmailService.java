package pl.miki.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {


    //public void sendEmail(Mail mail);
    public void sendSimpleMessage(String to, String subject, String text);
}