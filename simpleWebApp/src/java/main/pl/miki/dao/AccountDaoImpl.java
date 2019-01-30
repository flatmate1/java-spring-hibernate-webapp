package pl.miki.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.miki.entity.Account;
import pl.miki.entity.Role;


@Transactional
@Repository
public class AccountDaoImpl implements AccountDao {
    
    private final SessionFactory sessionFactory;
    
    public AccountDaoImpl(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
 
    @Override
    public Account findAccount(String username ) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.eq("username", username));
        return (Account) crit.uniqueResult();
    }

	@Override
	public void deleteAccount(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccount(Account account) {
		   Session currentSession;
		 
		    try {
		        currentSession = sessionFactory.getCurrentSession(); 

		    } catch (HibernateException e) {
		        currentSession = sessionFactory.openSession();
		        System.out.println("Opened Session");
		    } 
		    
		    Role role = new Role();
		    role.setAccount(account);
		    role.setUsername(account.getUsername());
		    role.setRole("ROLE_USER");
		    currentSession.save(account);
		    currentSession.save(role);
		    System.out.println("Data Saved");
		}

	@Override
	public Account findAccountByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.eq("email", email));
        return (Account) crit.uniqueResult();
	}

	@Override
	public void updatePassword(String password, String username) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = 
				session.createQuery("SELECT a FROM Account a WHERE a.username = :username", Account.class);
		theQuery.setParameter("username", username);

		Account account = (Account) theQuery.getSingleResult();
		
		account.setPassword(password);
		
		session.update(account);
		
		
	}
 
}
