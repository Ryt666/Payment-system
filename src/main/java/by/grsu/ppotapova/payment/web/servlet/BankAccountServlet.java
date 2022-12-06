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
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.web.dto.BankAccountDto;
import by.grsu.ppotapova.payment.web.dto.TableStateDto;




public class BankAccountServlet extends AbstractListServlet{
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
		int totalBankAccount = bankAccountDao.count(); // get count of ALL items

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalBankAccount); 
		 
		List<BankAccount> bankAccounts = bankAccountDao.find(tableStateDto); // get data using paging and sorting params

		List<BankAccountDto> dtos = bankAccounts.stream().map((entity) -> {
			BankAccountDto dto = new BankAccountDto();
			// copy necessary fields as-is
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			dto.setBlocked(entity.getBlocked());

			
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("bank_account.jsp").forward(req, res); // delegate request processing to JSP
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String bankAccountIdStr = req.getParameter("id");
		BankAccountDto dto = new BankAccountDto();
		if (!Strings.isNullOrEmpty(bankAccountIdStr)) {
			// object edit
			Integer bankAccountId = Integer.parseInt(bankAccountIdStr);
			BankAccount entity = bankAccountDao.getById(bankAccountId);
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			dto.setBlocked(entity.getBlocked());
		}
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("bank_account-edit.jsp").forward(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		BankAccount bankAccount = new BankAccount();
		String bankAccountIdStr = req.getParameter("id");
		bankAccount.setNumber(req.getParameter("number"));
		bankAccount.setBlocked(Boolean.parseBoolean(req.getParameter("blocked")));
		
		if (Strings.isNullOrEmpty(bankAccountIdStr)) {
			// new entity
			bankAccountDao.insert(bankAccount);
		} else {
			// updated entity
			bankAccount.setId(Integer.parseInt(bankAccountIdStr));
			bankAccountDao.update(bankAccount);
		}
		res.sendRedirect("/bankAccount"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		bankAccountDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}