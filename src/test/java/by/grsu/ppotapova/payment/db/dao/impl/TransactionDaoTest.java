package by.grsu.ppotapova.payment.db.dao.impl;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Transaction;


public class TransactionDaoTest extends AbstractTest {
	
	private static final IDao<Integer, BankAccount> bankAccountDao = BankAccountDaoImpl.INSTANCE;
	private static final IDao<Integer, Transaction> ttransactionDao = TransactionDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Transaction entity = new Transaction();
		
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setAmount(12345);
		entity.setCurrency("$");
		entity.setType("sdfg");
		entity.setDate(getCurrentTime());
		entity.setComment("fj");
		ttransactionDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}


	@Test
	public void testUpdate() {
		
		Transaction entity = new Transaction();
		
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setAmount(12345);
		entity.setCurrency("$");
		entity.setType("sdfg");
		entity.setDate(getCurrentTime());
		entity.setComment("fj");
		ttransactionDao.insert(entity);

		
		entity.setAmount(12345);
		ttransactionDao.update(entity);

		Transaction updatedEntity = ttransactionDao.getById(entity.getId());
		Assertions.assertEquals(entity.getAmount(), updatedEntity.getAmount());
		
		
	}

	@Test
	public void testDelete() {
		Transaction entity = new Transaction();
		
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setAmount(12345);
		entity.setCurrency("$");
		entity.setType("sdfg");
		entity.setDate(getCurrentTime());
		entity.setComment("fj");
		ttransactionDao.insert(entity);

		ttransactionDao.delete(entity.getId());

		Assertions.assertNull(ttransactionDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Transaction entity = new Transaction();
		
		entity.setBankAccountId(saveBankAccount(1).getId());
		entity.setAmount(12345);
		entity.setCurrency("$");
		entity.setType("sdfg");
		entity.setDate(getCurrentTime());
		entity.setComment("fj");
		ttransactionDao.insert(entity);

		Transaction selectedEntity = ttransactionDao.getById(entity.getId());

		Assertions.assertEquals( entity.getId(), selectedEntity.getId());
		
		Assertions.assertEquals(entity.getAmount(), selectedEntity.getAmount());
		Assertions.assertEquals(entity.getCurrency(), selectedEntity.getCurrency());
		Assertions.assertEquals(entity.getType(), selectedEntity.getType());
		Assertions.assertEquals(entity.getDate(), selectedEntity.getDate());
		Assertions.assertEquals(entity.getComment(), selectedEntity.getComment());
		
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Transaction entity = new Transaction();
			entity.setBankAccountId(saveBankAccount(1 + i).getId());
			entity.setAmount(12345);
			entity.setCurrency("$");
			entity.setType("sdfg");
			entity.setDate(getCurrentTime());
			entity.setComment("fj");
			ttransactionDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, ttransactionDao.getAll().size());
	}

	private BankAccount saveBankAccount(int number) {
		BankAccount entity = new BankAccount();
		entity.setNumber(65234);
		entity.setBlocked(true);
		bankAccountDao.insert(entity);
		return entity;
	}
	
	
}