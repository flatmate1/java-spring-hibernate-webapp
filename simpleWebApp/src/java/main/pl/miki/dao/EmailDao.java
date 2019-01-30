package pl.miki.dao;

public interface EmailDao {
	
    //public void sendEmail(Mail mail);
  
    public void sendSimpleMessage(String to, String subject, String text);
}

