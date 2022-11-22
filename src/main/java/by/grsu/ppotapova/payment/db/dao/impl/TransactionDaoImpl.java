package by.grsu.ppotapova.payment.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ppotapova.payment.db.dao.AbstractDao;
import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.Transaction;

public class TransactionDaoImpl extends AbstractDao implements IDao<Integer, Transaction> {
	public static final TransactionDaoImpl INSTANCE = new TransactionDaoImpl();

	private TransactionDaoImpl() {
		super();
	}

	@Override
	public void insert(Transaction entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into _transaction(number, bank_account_id, amount, currency, type, _data, comment) values(?,?,?,?,?,?)");
			pstmt.setInt(1,entity.getNumber());
			pstmt.setInt(2,entity.getBankAccountId());
			pstmt.setInt(3, entity.getAmount());
			pstmt.setString(4, entity.getCurrency());
			pstmt.setString(5, entity.getType());
			pstmt.setTimestamp(6, entity.getDate());
			pstmt.setString(7,entity.getComment());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "_transaction"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Transaction entity", e);
		}

	}

	@Override
	public void update(Transaction entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update _transaction set number=?, bank_account_id=?, amount=?, currency=?, type=?, _data=?, comment=? where id=?");
			pstmt.setInt(1,entity.getNumber());
			pstmt.setInt(2,entity.getBankAccountId());
			pstmt.setInt(3, entity.getAmount());
			pstmt.setString(4, entity.getCurrency());
			pstmt.setString(5, entity.getType());
			pstmt.setTimestamp(6, entity.getDate());
			pstmt.setString(7,entity.getComment());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Transaction entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from _transaction where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Transaction entity", e);
		}
	}

	@Override
	public Transaction getById(Integer id) {
		Transaction entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from _transaction where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Transaction entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Transaction> getAll() {
		List<Transaction> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from _transaction");
			while (rs.next()) {
				Transaction entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Transaction entities", e);
		}

		return entitiesList;
	}

	private Transaction rowToEntity(ResultSet rs) throws SQLException {
		Transaction entity = new Transaction();
		entity.setId(rs.getInt("id"));
		entity.setNumber(rs.getInt("number"));
		entity.setBankAccountId(rs.getInt("bank_account_id"));
		entity.setAmount(rs.getInt("amount"));
		entity.setCurrency(rs.getString("currency"));
		entity.setType(rs.getString("type"));
		entity.setDate(rs.getTimestamp("_data"));
		entity.setComment(rs.getString("comment"));
		return entity;
	}

}