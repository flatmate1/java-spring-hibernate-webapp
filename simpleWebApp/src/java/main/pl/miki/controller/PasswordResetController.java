package pl.miki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import pl.miki.dao.AccountPasswordResetTokenDao;
import pl.miki.entity.AccountToken;
import pl.miki.model.PasswordReset;
import pl.miki.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PasswordResetController {


    private final AccountService accountService;
    
    private final AccountPasswordResetTokenDao accountPassowrdResetDao;
    
    private ModelAndView mav;
    
    @Autowired
    public PasswordResetController(AccountService accountService, 
    							   AccountPasswordResetTokenDao accountPassowrdResetDao) {
    	
    	this.accountService = accountService;
    	this.accountPassowrdResetDao = accountPassowrdResetDao;
	}
    
    @GetMapping(value = "/a={token}")
    public ModelAndView ForgotPasswordForm( @PathVariable String token,
    										HttpServletResponse response,
                                            HttpServletRequest request) {
    	mav = new ModelAndView("reset-password");
    	AccountToken resetToken = accountPassowrdResetDao.findByToken(token);
    	mav.addObject("passwordReset", new PasswordReset());
    	if(resetToken == null) {
    		
    		mav = new ModelAndView("reset-password");
    		mav.addObject("error", "Could not find password reset token.");
    		mav.addObject("token", token);
        }
		return mav;
    }
    @PostMapping(value = "/a={token}")
    public ModelAndView getFoosBySimplePathWithPathVariable(
    						     @PathVariable String token,
    						     HttpServletResponse response,
      						     HttpServletRequest request,
      						     @ModelAttribute("passwordReset") PasswordReset passwordReset) {
    	
    	mav = null;
    	AccountToken resetToken = accountPassowrdResetDao.findByToken(token);
    	if(resetToken == null) {
    		
    		mav = new ModelAndView("reset-password");
    		mav.addObject("error", "Could not find password reset token.");
    		return mav;
    	} else {
    		
            AccountToken rs = accountPassowrdResetDao.findByToken(token);
            String username = rs.getAccount();
            String updatedPassword = passwordReset.getPassword();
            accountService.updatePassword(updatedPassword, username);
//          accountPassowrdResetDao.delete(token); 
        }
  
		return mav;	
  }

}