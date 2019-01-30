package pl.miki.dao;

import pl.miki.entity.AccountToken;

public interface AccountPasswordResetTokenDao {
	
	AccountToken findByToken(String token);
	void save(AccountToken accountToken);
	void delete(String token);

}
