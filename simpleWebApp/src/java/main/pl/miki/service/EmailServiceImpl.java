package pl.miki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.miki.dao.EmailDao;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailDao emailDao;
    
    
//    public void sendEmail(Mail mail) {
//    	emailDao.sendEmail(mail);
//    }
    public void sendSimpleMessage(String to, String subject, String text) {
    	emailDao.sendSimpleMessage(to, subject, text);
    }
}