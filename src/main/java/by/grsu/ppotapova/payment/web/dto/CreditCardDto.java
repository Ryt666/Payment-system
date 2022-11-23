package by.grsu.ppotapova.payment.web.dto;

import java.sql.Timestamp;

public class CreditCardDto {

    private Integer id;
	
	private Integer number;
	
	private Timestamp expiryDate;
	
	private Integer clientId;
	
	private String clientName;
	
	private Integer bankAccountId;
	
	private Integer bankAccountNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
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
	
	public Integer getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(Integer bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	
	
}