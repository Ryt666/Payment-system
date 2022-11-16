package by.grsu.ppotapova.payment.db.model;

public class BankAccount {
	private int id;
	private int number;
	private boolean blocked;
	@Override
	public String toString () {
		return "bankaccount [ id: " + id +"; number: "+ number + "; blocked: "+ blocked +"]";
	}


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
	public boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}



}
