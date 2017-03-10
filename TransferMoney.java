package com.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chitfund.Person.PersonBean;
import com.chitfund.Transaction.TransactionDao;

/**
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDao td=new TransactionDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
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
		HttpSession session=request.getSession();
		PersonBean pp=(PersonBean)session.getAttribute("person");
		String amount=request.getParameter("Tamount");
		td.transferAmount(pp,amount);
		if(pp.getType()==1)
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("UserFirstPage.jsp");  
		    rd.forward(request,response);  
	    }
	    else
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("GHFirstPage.jsp");  
		    rd.forward(request,response);
	    }
	}

}
