package javaBean;

import java.sql.Timestamp;
//alt insert  自动生成set get方法
public class User {
	private String userId;
	private String userName;
	private String password;
	private String mailAddress;
	private Integer userType;
	private Timestamp registerDate;
	private String enable;
	private String headerIconUrl;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	
	public String getEnable() {
		return enable;
	}
	
	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	public String getHeaderIconUrl() {
		return headerIconUrl;
	}
	
	public void setHeaderIconUrl(String headerIconUrl) {
		this.headerIconUrl = headerIconUrl;
	}
}