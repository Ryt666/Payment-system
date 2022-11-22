package by.grsu.ppotapova.payment.web.context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.grsu.ppotapova.payment.db.dao.AbstractDao;
import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.dao.impl.BankAccountDaoImpl;
import by.grsu.ppotapova.payment.db.dao.impl.ClientDaoImpl;
import by.grsu.ppotapova.payment.db.dao.impl.CreditCardDaoImpl;
import by.grsu.ppotapova.payment.db.dao.impl.TransactionDaoImpl;
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.db.model.CreditCard;
import by.grsu.ppotapova.payment.db.model.Transaction;

public class AppStartupListener implements ServletContextListener {
	private static final IDao<Integer, BankAccount> bankAccountDao = BankAccountDaoImpl.INSTANCE;
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;
	private static final IDao<Integer, CreditCard> creditCardDao = CreditCardDaoImpl.INSTANCE;
	private static final IDao<Integer, Transaction> transactionDao = TransactionDaoImpl.INSTANCE;

	private static final String DB_NAME = "production-db";

	private void initDb() throws SQLException {
		AbstractDao.init(DB_NAME);
		if (!AbstractDao.isDbExist()) {
			System.out.println(String.format("DB '%s' doesn't exist and will be created", DB_NAME));
			AbstractDao.createDbSchema();
			loadInitialData();
		} else {
			System.out.println(String.format("DB '%s' exists", DB_NAME));
		}
	}

	private void loadInitialData() {
		BankAccount bankAccountEntity = new BankAccount();
		bankAccountEntity.setNumber(125);
		bankAccountEntity.setBlocked(false);
		bankAccountDao.insert(bankAccountEntity);
		System.out.println("created: " + bankAccountEntity);

		Client clientEntity = new Client();
		clientEntity.setName("Polina");
		clientEntity.setSurname("Potapova");
		clientEntity.setPhone("+375298624393");
		clientEntity.setAddress("Saveckaja,25");
		clientDao.insert(clientEntity);
		System.out.println("created: " + clientEntity);

		Transaction transactionEntity = new Transaction();
		transactionEntity.setBankAccountId(bankAccountEntity.getId());
		transactionEntity.setAmount(125);
		transactionEntity.setCurrency("$");
		transactionEntity.setType("fgdsa");
		transactionEntity.setComment("fjhgfds");
		transactionDao.insert(transactionEntity);
		System.out.println("created: " + transactionEntity);

		CreditCard creditCardEntity = new CreditCard();
		creditCardEntity.setNumber(5478);
		creditCardEntity.setExpiryDate(getCurrentTime());
		creditCardEntity.setClientId(clientEntity.getId());
		creditCardEntity.setBankAccountId(bankAccountEntity.getId());
		creditCardDao.insert(creditCardEntity);
		System.out.println("created: " + creditCardEntity);
		System.out.println("initial data created");
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		try {
			initDb();
		} catch (SQLException e) {
			throw new RuntimeException("can't init DB", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}