package pl.miki.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_token")
public class AccountToken {
	
	@Id
	@Column(name="token_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tokenId;
	
	private String username;
	
	@Column(name = "token", nullable = false, unique = true)
	private String token;
	
    @Column(nullable = false)
    private Date expiryDate;

    public int getId() {
        return tokenId;
    }

    public void setId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount() {
        return username;
    }

    public void setAccount(String username) {
        this.username = username;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
}
    
