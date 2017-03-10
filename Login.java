package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chitfund.DBMS.DBMSDao;
import com.chitfund.Login.LoginDao;
import com.chitfund.Person.PersonBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		int pid=Integer.parseInt(request.getParameter("InputUserID"));
		String pswd=request.getParameter("InputPasswords");
		//PrintWriter out = response.getWriter();
		PersonBean pb=new PersonBean();
		pb.setPid(pid);
		pb.setPassword(pswd);
		DBMSDao ddLogin=new DBMSDao();
		boolean check=ddLogin.getLoginDetails(pb);
		if(check)
		{
			PersonBean ptemp=ddLogin.getPersonDetails(pid);
			HttpSession session =request.getSession();
			session.setAttribute("person", ptemp);
		    if(ptemp.getType()==1)
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
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
	        rd.include(request,response);  
		}
	}

}
