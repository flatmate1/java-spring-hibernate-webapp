package pl.miki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.miki.dao.AccountDao;
import pl.miki.entity.Account;

@Service(value="accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public Account findAccount(String username) {
		return accountDao.findAccount(username);
	}
	
	@Transactional
	public void deleteAccount(String username) {
		accountDao.deleteAccount(username);
	
	}
	
	@Transactional
	public void addAccount(Account account) {
		accountDao.addAccount(account);
		
	}

	@Transactional
	public Account findAccountByEmail(String email) {	
		return accountDao.findAccountByEmail(email);
	}

	@Transactional
	public void updatePassword(String password, String username) {
		accountDao.updatePassword(password, username);
		
	}

}
