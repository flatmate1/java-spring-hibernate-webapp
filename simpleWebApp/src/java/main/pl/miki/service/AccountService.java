package pl.miki.service;

import pl.miki.entity.Account;

public interface AccountService {
		
    Account findAccount(String username);
    Account findAccountByEmail(String email);
    void updatePassword(String password, String username);
    void deleteAccount(String username);
	void addAccount(Account account);
	
}
