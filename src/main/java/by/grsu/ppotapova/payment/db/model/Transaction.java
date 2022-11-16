package by.grsu.ppotapova.payment.db.model;

import java.sql.Timestamp;
public class Transaction {
	private int id;
	private int bankAccountId;
	private int amount;
	private String currency;
	private String type;
	private Timestamp date;
	private String comment;

	@Override
	public String toString () {
		return "transaction [ id: " + id +"bank_account:"+bankAccountId +"; amount: "+ amount + "; currency: "+ currency + "type: " + type + "date: " + date +"comment: " + comment + "]";
	}

		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bank_account_id) {
		this.bankAccountId = bank_account_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
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
