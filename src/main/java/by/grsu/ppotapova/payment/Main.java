package by.grsu.ppotapova.payment;

import java.sql.Date;
import java.sql.Timestamp;

import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.db.model.CreditCard;
import by.grsu.ppotapova.payment.db.model.Transaction;

public class Main {

	public static void main(String[] args) {

		Client c1 = new Client();
		c1.setId(1);
		c1.setName("Polina");
		c1.setSurname("Potapova");
		c1.setAddress("г. Гродно");
		c1.setPhone("+375298624393");
		System.out.println(c1.toString());
		CreditCard cc1=new CreditCard();
		cc1.setId(0);
		cc1.setNumber("458725488");
		cc1.setExpiryDate(new Timestamp(new Date(0).getTime()));
		cc1.setBankAccountId(1);
		cc1.setClientId(1);
		System.out.println(cc1.toString());
		BankAccount ba1 = new BankAccount();
		ba1.setId(1);
		ba1.setNumber("11qwe2345555");
		ba1.setBlocked(true);
		System.out.println(ba1.toString());
		Transaction tr1 = new Transaction();
		tr1.setId(1);
		tr1.setBankAccountId(1);
		tr1.setAmount(12);
		tr1.setCurrency("jjdj");
		tr1.setType("fv");
		tr1.setDate(new Timestamp(new Date(0).getTime()));
		tr1.setComment("sadfgh");
		System.out.println(tr1.toString());


	}

}
