package com.flipkart.mainservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");
        String appeder = " ";
		System.out.println("username--->" + username);
		System.out.println("password--->" + password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhanu", "root", "root");

			//Statement stmt = con.createStatement();
			String query ="select * from customer3 where firstname = ? and password=?";
PreparedStatement obj = con.prepareStatement(query);
             obj.setString(1,username );
             obj.setString(2, password);
             
			ResultSet result = obj.executeQuery();
					
			boolean login = false;
			while (result.next()) {
				login = true;
			}

			if (login) {
				System.out.println("login successfull");
				appeder+="loggin successfull";
			} else {
				System.out.println("login failed");
				appeder+="login failed";
			}

			System.out.println("result-->" + result);
			obj.close();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().append(appeder).append(username+" "+password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
