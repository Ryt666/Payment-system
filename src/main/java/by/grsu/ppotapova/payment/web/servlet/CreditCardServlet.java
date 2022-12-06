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
import by.grsu.ppotapova.payment.db.dao.impl.ClientDaoImpl;
import by.grsu.ppotapova.payment.db.dao.impl.CreditCardDaoImpl; 
import by.grsu.ppotapova.payment.db.model.BankAccount;
import by.grsu.ppotapova.payment.db.model.Client;
import by.grsu.ppotapova.payment.db.model.CreditCard;
import by.grsu.ppotapova.payment.web.dto.CreditCardDto;
import by.grsu.ppotapova.payment.web.dto.TableStateDto;
import by.grsu.ppotapova.payment.web.dto.BankAccountDto;
import by.grsu.ppotapova.payment.web.dto.ClientDto;

public class CreditCardServlet extends AbstractListServlet {
	private static final IDao<Integer, CreditCard> creditCardDao = CreditCardDaoImpl.INSTANCE;
	private static final IDao<Integer, BankAccount> bankAccountDao = BankAccountDaoImpl.INSTANCE;
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;

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
		int totalClient = creditCardDao.count(); // get count of ALL items

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalClient); // init TableStateDto for specific
																					// Servlet and saves it in current
																					// request using key
																					// "currentPageTableState" to be
																					// used by 'paging' component
		 
		List<CreditCard> creditCards = creditCardDao.find(tableStateDto); // get data using paging and sorting params


		List<CreditCardDto> dtos = creditCards.stream().map((entity) -> {
			CreditCardDto dto = new CreditCardDto();
			// copy necessary fields as-is
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			dto.setExpiryDate(entity.getExpiryDate());
			// build data for complex fields
			BankAccount bankAccount = bankAccountDao.getById(entity.getBankAccountId());
			dto.setBankAccountNumber(bankAccount.getNumber());

			Client client = clientDao.getById(entity.getClientId());
			dto.setClientName(client.getName() + " " + client.getSurname());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("credit_card.jsp").forward(req, res); // delegate request processing to JSP
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String creditCardIdStr = req.getParameter("id");
		CreditCardDto dto = new CreditCardDto();
		if (!Strings.isNullOrEmpty(creditCardIdStr)) {
			// object edit
			Integer creditCardId = Integer.parseInt(creditCardIdStr);
			CreditCard entity = creditCardDao.getById(creditCardId);
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			dto.setExpiryDate(entity.getExpiryDate());
			
			
			dto.setClientId(entity.getClientId());
			dto.setBankAccountId(entity.getBankAccountId());
			
			
			
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allBankAccounts", getAllBankAccountsDtos());
		req.setAttribute("allClients", getAllClientsDtos());
		req.getRequestDispatcher("credit_card-edit.jsp").forward(req, res);
	}

	private List<BankAccountDto> getAllBankAccountsDtos() {
		return bankAccountDao.getAll().stream().map((entity) -> {
			BankAccountDto dto = new BankAccountDto();
			dto.setId(entity.getId());
			dto.setNumber(entity.getNumber());
			return dto;
		}).collect(Collectors.toList());
	}
	private List<ClientDto> getAllClientsDtos() {
		return clientDao.getAll().stream().map((entity) -> {
			ClientDto dto = new ClientDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			return dto;
		}).collect(Collectors.toList());
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		CreditCard creditCard = new CreditCard();
		String creditCardIdStr = req.getParameter("id");
		String bankAccountIdStr = req.getParameter("bankAccountId");
		String clientIdStr = req.getParameter("clientId");

		creditCard.setNumber(req.getParameter("number"));
		creditCard.setBankAccountId(bankAccountIdStr == null ? null : Integer.parseInt(bankAccountIdStr));
		creditCard.setClientId(clientIdStr == null ? null : Integer.parseInt(clientIdStr));
		creditCard.setExpiryDate(new Timestamp(new Date().getTime()));
		if (Strings.isNullOrEmpty(creditCardIdStr)) {
			// new entity
			creditCard.setExpiryDate(new Timestamp(new Date().getTime()));
			creditCardDao.insert(creditCard);
		} else {
			// updated entity
			creditCard.setId(Integer.parseInt(creditCardIdStr));
			creditCardDao.update(creditCard);
		}
		res.sendRedirect("/creditCard"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		creditCardDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}