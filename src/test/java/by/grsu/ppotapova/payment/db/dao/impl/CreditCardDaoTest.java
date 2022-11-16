package by.grsu.ppotapova.payment.db.dao.impl;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.db.model.CreditCard;

public class CreditCardDaoTest extends AbstractTest {
	
	private static final IDao<Integer, BankAccount> bankAccountDao = BankAccountDaoImpl.INSTANCE;
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;
	private static final IDao<Integer, CreditCard> creditCardDao = CreditCardDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		CreditCard entity = new CreditCard();
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setClientId(saveClient("Polina").getId());
		entity.setNumber(12345);
		entity.setExpiryDate(getCurrentTime());
		creditCardDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}


	@Test
	public void testUpdate() {
		CreditCard entity = new CreditCard();
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setClientId(saveClient("Polina").getId());
		entity.setNumber(12345);
		entity.setExpiryDate(getCurrentTime());
		creditCardDao.insert(entity);

		Integer newNumber = 54321;
		
		entity.setNumber(newNumber);
		creditCardDao.update(entity);

		CreditCard updatedEntity = creditCardDao.getById(entity.getId());
		Assertions.assertEquals(newNumber, updatedEntity.getNumber());
	}

	@Test
	public void testDelete() {
		CreditCard entity = new CreditCard();
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setClientId(saveClient("Polina").getId());
		entity.setNumber(12345);
		entity.setExpiryDate(getCurrentTime());
		creditCardDao.insert(entity);

		creditCardDao.delete(entity.getId());

		Assertions.assertNull(creditCardDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		CreditCard entity = new CreditCard();
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setClientId(saveClient("Polina").getId());
		entity.setNumber(12345);
		entity.setExpiryDate(getCurrentTime());
		creditCardDao.insert(entity);

		CreditCard selectedEntity = creditCardDao.getById(entity.getId());

	
		Assertions.assertEquals(entity.getBankAccountId(), selectedEntity.getBankAccountId());
		Assertions.assertEquals(entity.getClientId(), selectedEntity.getClientId());
		Assertions.assertEquals(entity.getNumber(), selectedEntity.getNumber());
		Assertions.assertEquals(entity.getExpiryDate(), selectedEntity.getExpiryDate());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			CreditCard entity = new CreditCard();
			entity.setBankAccountId(saveBankAccount(1 + i).getId());
			entity.setClientId(saveClient("Polina"+ i).getId());
			entity.setNumber(12345);
			entity.setExpiryDate(getCurrentTime());
			creditCardDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, creditCardDao.getAll().size());
	}

	private BankAccount saveBankAccount(int number) {
		BankAccount entity = new BankAccount();
		entity.setNumber(65234);
		entity.setBlocked(true);
		bankAccountDao.insert(entity);
		return entity;
	}
	
	private Client saveClient(String name) {
		Client entity = new Client();
		entity.setName("Polina");
		entity.setSurname("Potapova");
		entity.setAddress("Gaspodarchia,12");
		entity.setPhone("+5623147856");
		clientDao.insert(entity);
		return entity;
	}
}