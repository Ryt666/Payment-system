package by.grsu.ppotapova.payment.web.dto;

public class BankAccountDto {
	
	private Integer id;
	
	private Integer number;
	
	private boolean blocked;
	@Override
	public String toString () {
		return "bankaccount [ id: " + id +"; number: "+ number + "; blocked: "+ blocked +"]";
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}



}
