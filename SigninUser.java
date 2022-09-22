package com.flipkart.mainservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SigninUser
 */
@WebServlet("/signinUser")
public class SigninUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("firstname---->>"+firstname);
		System.out.println("lastname---->>"+lastname);
		System.out.println("email---->>"+email);
		System.out.println("password---->>"+password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con
			=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhanu","root","root");
			
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate("insert into customer3(firstname,lastname,password,id) values('"+firstname+"','"+lastname+"','"+password+"',"+id+")");
			System.out.println("result-->"+result);
			stmt.close();
			con.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		response.getWriter().append("welcome ").append(firstname+" "+lastname);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
