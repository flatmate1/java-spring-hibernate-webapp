package pl.miki.entity;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
 
    private static final long serialVersionUID = -2054386655979281969L;
 
    @Id
    @Column(name="account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;

    @Column(name = "username", length = 20)
    private String username;
   
    @Column(name = "password", length = 20)
    private String password;
    private boolean active;

    @Column(name = "email")
    private String email;
    
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    @Column(name = "Active", length = 1, nullable = false)
    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString()  {
        return "["+ this.username+","+ this.password+"]";
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}