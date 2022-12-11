package by.grsu.ppotapova.payment.db.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ppotapova.payment.db.dao.AbstractDao;
import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.db.model.CreditCard;
import by.grsu.ppotapova.payment.web.dto.SortDto;
import by.grsu.ppotapova.payment.web.dto.TableStateDto;

public class CreditCardDaoImpl extends AbstractDao implements IDao<Integer, CreditCard> {
	public static final CreditCardDaoImpl INSTANCE = new CreditCardDaoImpl();

	private CreditCardDaoImpl() {
		super();
	}

	@Override
	public void insert(CreditCard entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into credit_card(number,expiry_date,client_id,bank_account_id) values(?,?,?,?)");
			pstmt.setString(1, entity.getNumber());
			pstmt.setTimestamp(2,entity.getExpiryDate());
			pstmt.setInt(3, entity.getClientId());
			pstmt.setInt(4, entity.getBankAccountId());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "credit_card"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert CreditCard entity", e);
		}

	}

	@Override
	public void update(CreditCard entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update credit_card set number=?, expiry_date=?, client_id=?, bank_account_id=? where id=?");
			pstmt.setString(1, entity.getNumber());
			pstmt.setTimestamp(2,entity.getExpiryDate());
			pstmt.setInt(3, entity.getClientId());
			pstmt.setInt(4, entity.getBankAccountId());
			pstmt.setInt(5, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update CreditCard entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from credit_card where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete CreditCard entity", e);
		}
	}

	@Override
	public CreditCard getById(Integer id) {
		CreditCard entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from credit_card where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get CreditCard entity by id", e);
		}

		return entity;
	}

	@Override
	public List<CreditCard> getAll() {
		List<CreditCard> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from credit_card");
			while (rs.next()) {
				CreditCard entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select CreditCard entities", e);
		}

		return entitiesList;
	}

	private CreditCard rowToEntity(ResultSet rs) throws SQLException {
		CreditCard entity = new CreditCard();
		entity.setId(rs.getInt("id"));
		entity.setNumber(rs.getString("number"));
		entity.setExpiryDate(rs.getTimestamp("expiry_date"));
		entity.setClientId(rs.getInt("client_id"));
		entity.setBankAccountId(rs.getInt("bank_account_id"));
		return entity;
	}
	public List<CreditCard> find(TableStateDto tableStateDto) {
		List<CreditCard> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			StringBuilder sql = new StringBuilder("select * from credit_card");

			final SortDto sortDto = tableStateDto.getSort();
			if (sortDto != null) {
				sql.append(String.format(" order by %s %s", sortDto.getColumn(), resolveSortOrder(sortDto)));
			}

			sql.append(" limit " + tableStateDto.getItemsPerPage());
			sql.append(" offset " + resolveOffset(tableStateDto));

			System.out.println("searching CreditCards using SQL: " + sql);
			ResultSet rs = c.createStatement().executeQuery(sql.toString());
			while (rs.next()) {
				CreditCard entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select CreditCard entities", e);
		}
		return entitiesList;
	}

	@Override
	public int count() {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select count(*) as c from credit_card");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");
		} catch (SQLException e) {
			throw new RuntimeException("can't get credit_cards count", e);
		}
	}

}