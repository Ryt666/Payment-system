package by.grsu.ppotapova.payment.web.security;

import java.io.Serializable;

public class Client implements Serializable {

	public Client(String email, String password, String name, String surname) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}

	private String email;
	private String password;
	private String name;
	private String surname;
	private boolean blocked;

	public boolean isBlocked() {
		return blocked;
	}

	public Client setBlocked(boolean blocked) {
		this.blocked = blocked;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void settName(String name) {
		this.name = name;
	}

	public String getSurame() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}