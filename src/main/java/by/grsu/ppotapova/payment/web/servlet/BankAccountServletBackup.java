package by.grsu.ppotapova.payment.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grsu.ppotapova.payment.db.dao.IDao;
import by.grsu.ppotapova.payment.db.dao.impl.BankAccountDaoImpl;
import by.grsu.ppotapova.payment.db.model.BankAccount;

public class BankAccountServletBackup extends HttpServlet {
	private static final IDao<Integer, BankAccount> bankAccountDao = BankAccountDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer bankAccountId = Integer.parseInt(req.getParameter("id")); // read request parameter
		BankAccount bankAccountById = bankAccountDao.getById(bankAccountId); // from DB

		res.setContentType("text/html");// setting the content type

		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");

		if (bankAccountById == null) {
			pw.println("no bankAccount by id=" + bankAccountId);
		} else {
			pw.println(bankAccountById.toString());
		}

		pw.println("</body></html>");
		pw.close();// closing the stream
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();// get the stream to write the data
		pw.println("<html><body>");
		try {
			Integer paramNumber = Integer.parseInt(req.getParameter("number"));
			Boolean paramBlocked = Boolean.parseBoolean(req.getParameter("meaning"));
			BankAccount bankAccountEntity = new BankAccount();
			bankAccountEntity.setNumber(paramNumber);
			bankAccountEntity.setBlocked(paramBlocked);
			bankAccountDao.insert(bankAccountEntity);
			pw.println("Saved:" + bankAccountEntity);

		} catch (Exception e) {
			pw.println("Error:" + e.toString());
		}

		pw.println("</body></html>");
		pw.close();
	}
}