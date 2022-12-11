package by.grsu.ppotapova.payment.db.model;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard {
	
	private Integer id;
	
	private String number;
	
	private Timestamp expiryDate;
	
	private Integer clientId;
	
	private Integer bankAccountId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Timestamp getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(Integer bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", number=" + number + ", expiryDate=" + expiryDate + ", clientId=" + clientId
				+ ", bankAccountId=" + bankAccountId + "]";
	}
	
}
