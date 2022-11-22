package by.grsu.ppotapova.payment.web.dto;

import java.sql.Timestamp;

public class CreditCardDto {

    private Integer id;
	
	private Long number;
	
	private Timestamp expiryDate;
	
	private Integer clientId;
	
	private String clientName;
	
	private Integer bankAccountId;
	
	private String bankAccountName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
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
	
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClienttName(String clientName) {
		this.clientName = clientName;
	}
	
	
	
}