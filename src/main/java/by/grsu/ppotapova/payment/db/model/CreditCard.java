package by.grsu.ppotapova.payment.db.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard {
	
	private int id;
	
	private int number;
	
	private Timestamp expiryDate;
	
	private int clientId;
	
	private int bankAccountId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Timestamp getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", number=" + number + ", expiryDate=" + expiryDate + ", clientId=" + clientId
				+ ", bankAccountId=" + bankAccountId + "]";
	}
	
}
