package by.grsu.ppotapova.payment.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.dao.impl.BankAccountDaoImpl;
import by.grsu.ppotapova.payment.db.dao.impl.TransactionDaoImpl;
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Transaction;
import by.grsu.ppotapova.payment.web.dto.TransactionDto;

public class TransactionServlet extends HttpServlet {
	private static final IDao<Integer, Transaction> transactionDao = TransactionDaoImpl.INSTANCE;
	private static final IDao<Integer, BankAccount> bankAccountDao = BankAccountDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet");
		String viewParam = req.getParameter("view");
		if ("edit".equals(viewParam)) {
			handleEditView(req, res);
		} else {
			handleListView(req, res);
		}
	}

	private void handleListView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Transaction> transactions = transactionDao.getAll(); // get data

		List<TransactionDto> dtos = transactions.stream().map((entity) -> {
			TransactionDto dto = new TransactionDto();
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			dto.setAmount(entity.getAmount());
			dto.setCurrency(entity.getCurrency());
			dto.setType(entity.getType());
			dto.setDate(entity.getDate());
			dto.setComment(entity.getComment());


			BankAccount bankAccount = bankAccountDao.getById(entity.getBankAccountId());
			dto.setBankAccountNumber(bankAccount.getBankAccountNumber());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("transaction.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String modelIdStr = req.getParameter("id");
		TransactionDto dto = new TransactionDto();
		if (!Strings.isNullOrEmpty(transactionIdStr)) {
			Integer transactionId = Integer.parseInt(transactionIdStr);
			Transaction entity = transactionDao.getById(transactinId);
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			dto.setAmount(entity.getAmount());
			dto.setCurrency(entity.getCurrency());
			dto.setType(entity.getType());
			dto.setDate(entity.getDate());
			dto.setComment(entity.getComment());
			dto.setBankAccountId(entity.getBankAccountId());

		}
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("add_transaction.jsp").forward(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Model model = new Model();
		String modelIdStr = req.getParameter("id");
		String brandIdStr = req.getParameter("brandId");
		model.setName(req.getParameter("name"));
		model.setActual(Boolean.parseBoolean(req.getParameter("actual")));
		model.setBrandId(brandIdStr == null ? null : Integer.parseInt(brandIdStr));
		model.setUpdated(new Timestamp(new Date().getTime()));
		if (Strings.isNullOrEmpty(modelIdStr)) {
			model.setCreated(new Timestamp(new Date().getTime()));
			transactionDao.insert(model);
		} else {
			model.setId(Integer.parseInt(modelIdStr));
			transactionDao.update(model);
		}
		res.sendRedirect("/model");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		transactionDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}