package com.phase1.api.dto;

import java.util.List;

public class Invites {

	public Invites() {
		super();
	}
	
	private String userId;
	
	private List<String> emails;

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}