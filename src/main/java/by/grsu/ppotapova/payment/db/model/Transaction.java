package by.grsu.ppotapova.payment.db.model;

import java.sql.Timestamp;
import java.sql.Date;
public class Transaction {
	
	private Integer id;
	
	private Integer bankAccountId;
	
	private Integer amount;
	
	private String currency;
	
	private String type;
	
	private Timestamp date;
	
	private String comment;

	@Override
	public String toString () {
		return "transaction [ id: " + id  +"bank_account:"+bankAccountId +"; amount: "+ amount + "; currency: "+ currency + "type: " + type + "date: " + date +"comment: " + comment + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(Integer bank_account_id) {
		this.bankAccountId = bank_account_id;
	}
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	

	
		
	}

