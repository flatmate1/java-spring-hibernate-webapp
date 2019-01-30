package pl.miki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.miki.dao.AccountPasswordResetTokenDao;
import pl.miki.entity.Account;
import pl.miki.entity.AccountToken;
import pl.miki.model.PasswordForgot;
import pl.miki.service.AccountService;
import pl.miki.service.EmailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class PasswordForgotController {

	
	
    private final AccountService accountService;

    private final AccountPasswordResetTokenDao accountPassowrdResetDao;
    
    private final EmailService emailService;

	private ModelAndView mav;
	
	@Autowired
	public PasswordForgotController(AccountService accountService,
								    AccountPasswordResetTokenDao accountPassowrdResetDao,
								    EmailService emailService) {
		
		this.accountService = accountService;
		this.accountPassowrdResetDao = accountPassowrdResetDao;
		this.emailService = emailService;
	}
	
    @GetMapping(value = "/forgot-password")
    public ModelAndView ForgotPasswordForm( HttpServletResponse response,
                                            HttpServletRequest request) {
    	mav = new ModelAndView("forgot-password");
    	mav.addObject("forgotPassword", new PasswordForgot());
    	
    	return mav;
    	
        }
    
    @PostMapping(value = "/forgot-passwordProcess")
    public ModelAndView loginProcess(HttpServletRequest request, 
    								 HttpServletResponse response,
    								 @ModelAttribute("forgotPassword") PasswordForgot forgotPassword) {
      
    	mav = null;
    	
        Account account = accountService.findAccountByEmail(forgotPassword.getEmail());
        if (account == null){
            mav = new ModelAndView("forgot-password");
            mav.addObject("message", "Username or Password is wrong!!");
        } else {
        	
        mav = new ModelAndView("login");
        
        AccountToken token = new AccountToken();
        token.setToken(UUID.randomUUID().toString());
        token.setAccount(account.getUsername());
        token.setExpiryDate(30);
        accountPassowrdResetDao.save(token);

        emailService.sendSimpleMessage("mikolajkrzeszowiec@gmail.com","test","test");
       
        }
      
        return mav;
        
   }

}