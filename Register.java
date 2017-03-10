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

import com.chitfund.Login.LoginDao;
import com.chitfund.Person.PersonBean;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	LoginDao ld=new LoginDao();
	//PersonBean pb=new PersonBean();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hellooo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String p1=request.getParameter("InputPassword1");
		String p2=request.getParameter("InputPassword2");
		PrintWriter out = response.getWriter();
		
		if(p1.equals(p2))
		{
			PersonBean pb=ld.register(request.getParameter("InputName"),request.getParameter("InputUserName"),request.getParameter("InputMobileNumber"),request.getParameter("InputPassword1"),request.getParameter("InputType"));
			HttpSession session =request.getSession();
		    session.setAttribute("person", pb);
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeRegister.jsp");  
		    rd.forward(request,response);  
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.html");  
	        rd.include(request,response);  
		}
	}
}

	/*public PersonBean returnPerson()
	{
		return pb;
	}*/


