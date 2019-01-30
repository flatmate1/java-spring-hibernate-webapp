package pl.miki.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
 
	 @Id
	 @Column(name="username")
	 private String username;
	 
	 @Column(name="role")
	 private String role;
	 
	 @JoinColumn(name = "username")
	 @OneToOne(cascade = CascadeType.ALL)
     private Account account;

	 public String getRole() {
		 return role;
	 }
	
	 public void setRole(String role) {
		 this.role = role;
	 }

	 public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	 
}