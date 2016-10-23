package com.kapp.pojo;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {
	@Id
	private int userId;
	
	@Column
    private String userName;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column
	private boolean prFlag;
	
    public User(int userId, String userName, boolean prFlag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.prFlag = prFlag;
	}

	public boolean isPrFlag() {
		return prFlag;
	}

	public void setPrFlag(boolean prFlag) {
		this.prFlag = prFlag;
	}
	private String birthday;  
      
    public User(){}  
      
    public User(String name, String birthday) {  
        this.userName = name;  
        this.birthday = birthday;  
    }  

    public String getBirthday() {  
        return birthday;  
    }  
    public void setBirthday(String birthday) {  
        this.birthday = birthday;  
    }  
      
} 