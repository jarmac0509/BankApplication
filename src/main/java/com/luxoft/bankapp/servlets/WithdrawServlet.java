package main.java.com.luxoft.bankapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.luxoft.bankapp.dao.AccountDAOImpl;
import main.java.com.luxoft.bankapp.exceptions.BankException;
import main.java.com.luxoft.bankapp.exceptions.DAOException;
import main.java.com.luxoft.bankapp.model.Account;
import main.java.com.luxoft.bankapp.model.Bank;
import main.java.com.luxoft.bankapp.service.BankService;

public class WithdrawServlet extends HttpServlet {
	Account acc;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String clientName = (String) req.getSession().getAttribute("clientName");
		System.out.println("withdraw is"+req.getParameter("amount"));
		float withdraw=Float.parseFloat(req.getParameter("amount"));
//		try {
//			acc=new ClientDAOImpl().findClientByName(new Bank("My Bank"), clientName).getActiveAccount();
//			acc.withdraw(withdraw);
//			new AccountDAOImpl().save(acc);
//		} catch ( DAOException | BankException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		BankService bankService=(BankService)req.getSession().getServletContext().getAttribute("bankService");
		Account acc=bankService.getClient(new Bank("My Bank"), clientName).getActiveAccount();
		
		try {
			acc.withdraw(withdraw);
			new AccountDAOImpl().save(acc);
		} catch (DAOException | BankException e) {
			e.printStackTrace();
		}
		res.sendRedirect("/balance");
}
}