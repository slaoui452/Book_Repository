package com.inpt.projet.dto;

import com.inpt.projet.Clients.User;

public class UserRequest {

	public UserRequest(User user) {
		super();
		this.user = user;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
}
