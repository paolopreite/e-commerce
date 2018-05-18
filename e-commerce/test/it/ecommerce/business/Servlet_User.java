package it.ecommerce.business;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ecommerce.entity.User;

/**
 * Servlet implementation class Servlet_User
 */
@WebServlet("/Servlet_User")
public class Servlet_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB
	UserBeanLocal userBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		User u = new User();
		u.setNome("Luca");
		u.setCognome("Verdi");
		u.setAddress("Via Roma");
		u.setCap("10100");
		u.setCity("Roma");
		u.setCountry("Italia");
		u.setUsername("LVerdi");
		u.setPassword("pwd");
		userBean.addUser(u);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
