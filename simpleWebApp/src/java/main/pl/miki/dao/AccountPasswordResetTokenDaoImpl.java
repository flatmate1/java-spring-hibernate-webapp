package pl.miki.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.miki.entity.Account;
import pl.miki.entity.AccountToken;
import pl.miki.entity.Product;
import pl.miki.entity.Role;

@Transactional
@Repository
public class AccountPasswordResetTokenDaoImpl implements AccountPasswordResetTokenDao{

	private final SessionFactory sessionFactory;

	public AccountPasswordResetTokenDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public AccountToken findByToken(String token) {
		// Reading the records from the table
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query theQuery = 
				currentSession.createQuery("SELECT u FROM AccountToken u WHERE u.token = :token", AccountToken.class);
		
		theQuery.setParameter("token", token);
		
		// execute query and get result list
		AccountToken accountToken = (AccountToken) theQuery.getSingleResult();

				
		// return the results		
		return accountToken;
		
	}

	@Override
	public void save(AccountToken accountToken) {
		  Session currentSession;
			 
		    try {
		        currentSession = sessionFactory.getCurrentSession(); 

		    } catch (HibernateException e) {
		        currentSession = sessionFactory.openSession();
		        System.out.println("Opened Session");
		    } 
		    
		    currentSession.save(accountToken);
		    System.out.println("Data Saved");
		
	}

	@Override
	public void delete(String acountToken) {

	}

}
