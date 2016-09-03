package com.pyda.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jakubpyda on 03/09/16.
 */
@Entity
class Account {
	@Id
	@GeneratedValue
	private Long id;
	private String username, password;
	private boolean active;

	public Account() {
	}

	Account(String username, String password, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", active=" + active +
				'}';
	}
}