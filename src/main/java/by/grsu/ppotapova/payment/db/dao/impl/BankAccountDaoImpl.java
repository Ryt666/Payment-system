 package by.grsu.ppotapova.payment.db.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ppotapova.payment.db.dao.AbstractDao;
import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.web.dto.SortDto;
import by.grsu.ppotapova.payment.web.dto.TableStateDto;


public class BankAccountDaoImpl extends AbstractDao implements IDao<Integer, BankAccount> {

	// single instance of this class to be used by the all consumers
	public static final BankAccountDaoImpl INSTANCE = new BankAccountDaoImpl();

	// private constructor disallows instantiation of this class ('Singleton'
	// pattern) outside of current class
	private BankAccountDaoImpl() {
		super();
	}

	@Override
	public void insert(BankAccount entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("insert into bank_account(id, number, blocked) values(?,?,?)");
			pstmt.setString(2, entity.getNumber());
			pstmt.setBoolean(3, entity.getBlocked());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "bank_account"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert bank_account entity", e);
		}
	}

	@Override
	public void update(BankAccount entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update bank_account  set number=?, blocked=? where  id=?");
			pstmt.setInt(3, entity.getId());
			pstmt.setString(1, entity.getNumber());
			pstmt.setBoolean(2, entity.getBlocked());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update bank_account entity", e);
		}
	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from bank_account  where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete bank_account  entity", e);
		}

	}

	@Override
	public BankAccount getById(Integer id) {
		BankAccount entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from bank_account  where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get bank_account  entity by id", e);
		}

		return entity;
	}

	@Override
	public List<BankAccount> getAll() {
		List<BankAccount> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from bank_account ");
			while (rs.next()) {
				BankAccount entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select bank_account entities", e);
		}

		return entitiesList;
	}

	private BankAccount rowToEntity(ResultSet rs) throws SQLException {
		BankAccount entity = new BankAccount();
		entity.setId(rs.getInt("id"));
		entity.setNumber(rs.getString("number"));
		entity.setBlocked(rs.getBoolean("blocked"));
		return entity;
	}

	public List<BankAccount> find(TableStateDto tableStateDto) {
		List<BankAccount> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			StringBuilder sql = new StringBuilder("select * from bank_account");

			final SortDto sortDto = tableStateDto.getSort();
			if (sortDto != null) {
				sql.append(String.format(" order by %s %s", sortDto.getColumn(), resolveSortOrder(sortDto)));
			}

			sql.append(" limit " + tableStateDto.getItemsPerPage());
			sql.append(" offset " + resolveOffset(tableStateDto));

			System.out.println("searching BankAccounts sing SQL: " + sql);
			ResultSet rs = c.createStatement().executeQuery(sql.toString());
			while (rs.next()) {
				BankAccount entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select BankAccount entities", e);
		}
		return entitiesList;
	}

	@Override
	public int count() {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select count(*) as c from bank_account");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");
		} catch (SQLException e) {
			throw new RuntimeException("can't get bank_accounts count", e);
		}
	}

}