package by.grsu.ppotapova.payment.db.model;

public class Client {
	private Integer id;
	private String name;
	private String surname;
	private String address;
	private String phone;

	@Override
	public String toString () {
		return "client [ id: " + id +"; name: "+ name + "; surname: "+ surname +";phone:"+ phone +";address: "+ address +"]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}



}
