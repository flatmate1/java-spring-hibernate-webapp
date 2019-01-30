package pl.miki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.miki.entity.Account;
import pl.miki.service.AccountService;

@Controller
public class RegisterController {
	

	public final AccountService accountService;
	
	public RegisterController(AccountService accountService) {
		this.accountService = accountService;
	}
	
    @GetMapping(value = "/register")
    public ModelAndView showForm() {
        return new ModelAndView("register", "account", new Account());
    }
 
    @PostMapping(value = "/register")
    public String submit(@ModelAttribute("account")Account account, BindingResult bindingResult) {
    	accountService.addAccount(account);
        return "redirect:/login";
    }
}
    