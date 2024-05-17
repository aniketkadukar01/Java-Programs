package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/voter_register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			userdao = new UserDaoImpl();
		}catch(Exception e) {
			throw new ServletException("Error in init" + getClass(),e);
		}
		
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userdao.cleanUp();
		}catch(Exception e) {
			System.out.println("Error in destroy"+ getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			String firstname = request.getParameter("fn");
			String lastname = request.getParameter("ln");
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			LocalDate date =LocalDate.parse(request.getParameter("dob"));
			
			int age=Period.between(date,LocalDate.now()).getYears();
			if(age>=21) {
				User newVoter = new User(firstname,lastname,email,password,Date.valueOf(date));
				String regStatus=userdao.voterRegistration(newVoter);
				pw.print("<h5>"+regStatus+"</h5>");
			}else {
				pw.print("<h5>Voter registration failed,Invalid Age!!!</h5>");
			}
			
		}catch(Exception e) {
			throw new ServletException("Error in service"+getClass(),e);
		}
	}

}
