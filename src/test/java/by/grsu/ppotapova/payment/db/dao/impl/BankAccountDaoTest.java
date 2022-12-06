package by.grsu.ppotapova.payment.db.dao.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.BankAccount;

public class BankAccountDaoTest extends AbstractTest {
	private static final IDao<Integer, BankAccount> dao = BankAccountDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		
		BankAccount entity = new BankAccount();
		
		entity.setNumber("112345555");
		entity.setBlocked(true);
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		BankAccount entity = new BankAccount();
		entity.setNumber("12345");
		entity.setBlocked(true);
		dao.insert(entity);

		entity.setNumber("6789");
		entity.setBlocked(false);
		dao.update(entity);

		BankAccount updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals( entity.getId(), updatedEntity.getId());
		Assertions.assertEquals( entity.getNumber(), updatedEntity.getNumber());
		Assertions.assertEquals( entity.getBlocked(), updatedEntity.getBlocked());
		
		
	}

	@Test
	public void testDelete() {
		BankAccount entity = new BankAccount();
		entity.setId(1);
		entity.setNumber("112345555");
		entity.setBlocked(true);
		dao.insert(entity);

		dao.delete(entity.getId());

		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		BankAccount entity = new BankAccount();
		entity.setId(1);
		entity.setNumber("112345555");
		entity.setBlocked(true);
		dao.insert(entity);

		BankAccount selectedEntity = dao.getById(entity.getId());

		Assertions.assertEquals(entity.getId(), selectedEntity.getId());
		Assertions.assertEquals(entity.getNumber(), selectedEntity.getNumber());
		Assertions.assertEquals(entity.getBlocked(), selectedEntity.getBlocked());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			BankAccount entity = new BankAccount();
			entity.setId( 1 + i); // generate some random meaningless name as it is just a test (the data can be unreal)
			entity.setNumber("112345555");
			entity.setBlocked(true);
			dao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
}