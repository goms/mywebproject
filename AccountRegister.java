package com.Servlets;


import java.io.IOException;
import java.io.PrintWriter;

import com.Servlets.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chitfund.Account.AccountBean;
import com.chitfund.Account.AccountDao;
import com.chitfund.DBMS.DBMSDao;
import com.chitfund.Person.PersonBean;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
	Register r=new Register();
	DBMSDao dd=new DBMSDao();
	PersonBean pB=null;
	String accNo=null,bname=null;
	int balance=1000,pid=5;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AccountRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		AccountDao ad=new AccountDao();
		boolean fl=false;
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		pB=(PersonBean) session.getAttribute("person");
		fl=ad.getAccountDetails(pB,request.getParameter("accountNumber"),request.getParameter("bankName"));
		if(fl)
		{
			request.setAttribute("person", pB);
			request.setAttribute("account", ad);
			session=request.getSession(false);
			RequestDispatcher rd=request.getRequestDispatcher("FirstPage.html");  
	        rd.forward(request,response);  
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeRegister.jsp");  
	        rd.forward(request,response);  
		}
	}
	public PersonBean getPersons()
	{
		return pB;
	}
	public String getAccNo()
	{
		return accNo;
	}
	public String  getBankName()
	{
		return bname;
	}
	public int returnBalance()
	{
		return balance;
	}
	public int returnPID()
	{
		return pid;
	}

}
