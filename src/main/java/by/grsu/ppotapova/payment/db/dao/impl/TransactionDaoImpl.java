package by.grsu.ppotapova.payment.db.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ppotapova.payment.db.dao.AbstractDao;
import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.db.model.Transaction;
import by.grsu.ppotapova.payment.web.dto.SortDto;
import by.grsu.ppotapova.payment.web.dto.TableStateDto;

public class TransactionDaoImpl extends AbstractDao implements IDao<Integer, Transaction> {
	public static final TransactionDaoImpl INSTANCE = new TransactionDaoImpl();

	private TransactionDaoImpl() {
		super();
	}

	@Override
	public void insert(Transaction entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into _transaction( bank_account_id, amount, currency, type, _data, comment) values(?,?,?,?,?,?)");
		
			pstmt.setInt(1,entity.getBankAccountId());
			pstmt.setInt(2, entity.getAmount());
			pstmt.setString(3, entity.getCurrency());
			pstmt.setString(4, entity.getType());
			pstmt.setTimestamp(5, entity.getDate());
			pstmt.setString(6,entity.getComment());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "_transaction"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Transaction entity", e);
		}

	}

	@Override
	public void update(Transaction entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update _transaction set bank_account_id=?, amount=?, currency=?, type=?, _data=?, comment=? where id=?");
			
			pstmt.setInt(1,entity.getBankAccountId());
			pstmt.setInt(2, entity.getAmount());
			pstmt.setString(3, entity.getCurrency());
			pstmt.setString(4, entity.getType());
			pstmt.setTimestamp(5, entity.getDate());
			pstmt.setString(6,entity.getComment());
			pstmt.setInt(7,entity.getId());
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
		entity.setBankAccountId(rs.getInt("bank_account_id"));
		entity.setAmount(rs.getInt("amount"));
		entity.setCurrency(rs.getString("currency"));
		entity.setType(rs.getString("type"));
		entity.setDate(rs.getTimestamp("_data"));
		entity.setComment(rs.getString("comment"));
		return entity;
	}
	
	public List<Transaction> find(TableStateDto tableStateDto) {
		List<Transaction> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			StringBuilder sql = new StringBuilder("select * from _transaction");

			final SortDto sortDto = tableStateDto.getSort();
			if (sortDto != null) {
				sql.append(String.format(" order by %s %s", sortDto.getColumn(), resolveSortOrder(sortDto)));
			}

			sql.append(" limit " + tableStateDto.getItemsPerPage());
			sql.append(" offset " + resolveOffset(tableStateDto));

			System.out.println("searching Clients using SQL: " + sql);
			ResultSet rs = c.createStatement().executeQuery(sql.toString());
			while (rs.next()) {
				Transaction entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Transaction entities", e);
		}
		return entitiesList;
	}

	@Override
	public int count() {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select count(*) as c from _transaction");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");
		} catch (SQLException e) {
			throw new RuntimeException("can't get _transactions count", e);
		}
	}

}