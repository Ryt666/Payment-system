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
			dto.setAmount(entity.getAmount());
			dto.setCurrency(entity.getCurrency());
			dto.setType(entity.getType());
			dto.setDate(entity.getDate());
			dto.setComment(entity.getComment());


			BankAccount bankAccount = bankAccountDao.getById(entity.getBankAccountId());
			dto.setBankAccountNumber(bankAccount.getNumber());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("transaction.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String transactionIdStr = req.getParameter("id");
		TransactionDto dto = new TransactionDto();
		if (!Strings.isNullOrEmpty(transactionIdStr)) {
			Integer transactionId = Integer.parseInt(transactionIdStr);
			Transaction entity = transactionDao.getById(transactionId);
			dto.setId(entity.getId());
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
		Transaction transaction = new Transaction();
		String transactionIdStr = req.getParameter("id");
		String bankAccountIdStr = req.getParameter("bankAccountId");
		transaction.setAmount(Integer.parseInt(req.getParameter("number")));
		transaction.setBankAccountId(bankAccountIdStr == null ? null : Integer.parseInt(bankAccountIdStr));
		transaction.setDate(new Timestamp(new Date().getTime()));
		transaction.setCurrency(req.getParameter("currency"));
		transaction.setType(req.getParameter("type"));
		transaction.setComment(req.getParameter("comment"));
		if (Strings.isNullOrEmpty(transactionIdStr)) {
			transaction.setDate(new Timestamp(new Date().getTime()));
			transactionDao.insert(transaction);
		} else {
			transaction.setId(Integer.parseInt(transactionIdStr));
			transactionDao.update(transaction);
		}
		res.sendRedirect("/model");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		transactionDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}