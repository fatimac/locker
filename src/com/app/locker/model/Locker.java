package com.app.locker.model;

public class Locker {

	public static final String LOCKER_ID = "locker_id";
	public static final String USERNAME = "username";
	public static final String EMAIL_ADDRESS = "email_address";
	public static final String PASSWORD = "password";
	public static final String WEBSITE_NAME = "website_name";
	public static final String WEBSITE_URL = "website_url";

	private int lockerId;
	private String username;
	private String emailAddress;
	private String password;
	private String websiteName;
	private String websiteUrl;

	public Locker() {
		// TODO Auto-generated constructor stub
	}

	public Locker(String username, String emailAddress, String password,
			String websiteName, String websiteUrl) {
		super();
		this.username = username;
		this.emailAddress = emailAddress;
		this.password = password;
		this.websiteName = websiteName;
		this.websiteUrl = websiteUrl;
	}

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

}
