package pl.miki.dao;

import pl.miki.entity.Account;

public interface AccountDao {
 
    
    Account findAccount(String username);
    
    Account findAccountByEmail(String email);
    
    void updatePassword(String password, String username);
    
    void deleteAccount(String username);
	
	void addAccount(Account account);
	
	
    
}